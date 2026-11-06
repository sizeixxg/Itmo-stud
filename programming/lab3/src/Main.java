import characters.PirateGuard;
import characters.Slave;
import enums.WeatherCondition;
import exceptions.BoatOvercrowdedException;
import interfaces.Fisher;
import interfaces.Rower;
import items.Boat;
import records.SkillSet;

import static java.lang.IO.println;

public class Main {
    static void main(String[] args) {
        WeatherCondition condition = WeatherCondition.RandCondition();

        Boat aurora = new Boat();
        int placesForSlave= aurora.getCapacity()-1;

        PirateGuard guard = new PirateGuard("Пиратик", new SkillSet((int)(Math.random()*10), (int)(Math.random()*10), (int)(Math.random()*10)));
        try {
            aurora.addPasanger(guard);
        }catch (BoatOvercrowdedException err){
            System.out.println(err.getMessage());
        }

        int count = (int) (Math.random() * 3) + 1;
        if (count==1){
            System.out.println(count+" раб пытаются сесть в лодку, мест осталось: "+ placesForSlave);
        } else {
            System.out.println(count + " раба пытаются сесть в лодку, мест осталось:"+ placesForSlave);
        }
        for (int i = 0; i < count; i++) {
            Slave slave = new Slave("Раб " + (i + 1), new SkillSet((int)(Math.random()*10), (int)(Math.random()*10), (int)(Math.random()*10)), guard);
            try {
                aurora.addPasanger(slave);
            }catch (BoatOvercrowdedException err){
                System.out.println(err.getMessage());
            }
        }

        aurora.sail();
        aurora.rowToDistance(100);

        boolean ReachFishSpot = aurora.getDistance()>=100;
        if (ReachFishSpot) {
            for (Rower rower : aurora.getCrew()) {
                if (rower instanceof Fisher fisher) {
                    fisher.fish(aurora);
                }
            }
            if (aurora.getFish() >= 50) {
                System.out.println("Поймано достаточно рыбы: " + aurora.getFish());
                for (Rower rower : aurora.getCrew()) {
                    if (rower instanceof Slave slave) {
                        slave.makeDecision(condition, aurora);
                        break;
                    }
                }
            } else {
                System.out.println("Силы закончились. Поймано рыбы: " + aurora.getFish());
                aurora.returnToHarbor("Не удалось поймать достаточно рыбы.");
            }
        } else aurora.returnToHarbor("Не удалось доплыть до рыбного места.");
        }
    }
