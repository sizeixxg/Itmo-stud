package items;

import characters.Slave;
import exceptions.BoatOvercrowdedException;
import interfaces.Rower;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Boat {
    private List<Rower> crew = new ArrayList<>();
    private int fishStock;
    private int capacity=4;
    private boolean atSea;
    private int distanceFromLand=0;

    public void addFish(int amount){
        this.fishStock+=amount;
    }

    public int getDistance(){
        return distanceFromLand;
    }

    public void addDistance(Rower rower){
        distanceFromLand+=rower.getSkills().rowingSkill();
    }

    public void rowToDistance(int targetDistance){
        while (distanceFromLand<targetDistance){
            int currentDistance = distanceFromLand;
            for (Rower rower:crew){
                rower.row(this);
                if (distanceFromLand>=targetDistance){
                    System.out.println("Лодка отплыла на необходимое расстояние, можно рыбачить");
                    break;
                }
            }
            if (currentDistance==distanceFromLand){
                System.out.println("Лодка встала, никто не может продолжать грести");
                break;
            }
        }
    }

    public int getFish(){
        return fishStock;
    }

    public void addPasanger(Rower rower) throws BoatOvercrowdedException {
        if (crew.size()>=capacity){
            throw new BoatOvercrowdedException(capacity);
        }
        else {
            crew.add(rower);
            System.out.println(rower.getName()+" Сел в лодку");
        }
    }

    public void removePassanger(Rower rower){
        crew.remove(rower);
        System.out.println(rower.getName()+" Вышел покурить, место освободилось");
    }

    public void sail(){
        atSea=true;
        System.out.println("Лодка вышла в море");
    }

    public void returnToHarbor(Slave slave){
        if (slave.getisfree()==false){
            atSea=false;
            distanceFromLand=0;
            System.out.println("Попытка побега была провалена, лодка возращается в порт");
        }
    }
    public void returnToHarbor() {
        atSea = false;
        distanceFromLand = 0;
        System.out.println("Поймать достаточно рыбы не удалось, лодка с злым пиратом возвращается в порт");
    }

    public List<Rower> getCrew(){
        return crew;
    }

    @Override
    public String toString(){
        return "Вместимость лодки:"+ capacity + " рыбы поймано:" + getFish();
    }

    @Override
    public boolean equals(Object obj){
        if (obj==this){
            return true;
        }
        if (obj==null || obj.getClass()!=this.getClass()){
            return false;
        }
        Boat o = (Boat)obj;
        return (Objects.equals(this.capacity, o.capacity) && Objects.equals(this.crew, o.crew) && Objects.equals(this.fishStock, o.fishStock));
    }

    @Override
    public int hashCode(){
        return Objects.hash(capacity, crew, fishStock);
    }
}
