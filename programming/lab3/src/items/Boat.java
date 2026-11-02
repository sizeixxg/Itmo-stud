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
    private int capacity=3;
    private boolean atSea;

    public void addFish(int amount){
        this.fishStock+=amount;
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
        }
    }

    public void removePassanger(Rower rower){
        crew.remove(rower);
    }

    public void sail(){
        atSea=true;
    }

    public void returnToHarbor(Slave slave){
        if (slave.getisfree()==false){
            atSea=false;
            System.out.println("Попытка побега была провалена, лодка возращается в порт");
        }
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
