import characters.PirateGuard;
import characters.Slave;
import enums.WeatherCondition;
import exceptions.BoatOvercrowdedException;
import items.Boat;
import records.SkillSet;

import static java.lang.IO.println;

public class Main {
    static void main(String[] args) {
        PirateGuard guard = new PirateGuard("Пиратик", new SkillSet(3,5,5));
        Slave robinson = new Slave("Робинзон",new SkillSet(8,6,7), guard);
        Slave boy = new Slave("Мальчик", new SkillSet(2,2,2), guard);
        PirateGuard guard1 = new PirateGuard("Пиратик", new SkillSet(3,5,5));

        WeatherCondition condition= WeatherCondition.STORM;

        Boat aurora = new Boat();
        try {aurora.addPasanger(robinson);}catch (BoatOvercrowdedException err){
            System.out.println(err.getMessage());
        }
        try {aurora.addPasanger(boy);}catch (BoatOvercrowdedException err){
            System.out.println(err.getMessage());
        }
        try {aurora.addPasanger(guard);}catch (BoatOvercrowdedException err){
            System.out.println(err.getMessage());
        }
        try {aurora.addPasanger(guard1);}catch (BoatOvercrowdedException err){
            System.out.println(err.getMessage());
        }
        aurora.removePassanger(guard);
        aurora.sail();

        println(aurora);
        println(robinson);

        boy.row(aurora);
        robinson.row(aurora);

        robinson.fish(aurora);
        boy.fish(aurora);

        robinson.makeDecision(condition, aurora);

    }
}