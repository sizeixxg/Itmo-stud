package characters;

import enums.WeatherCondition;
import exceptions.EscapeFailedException;
import interfaces.Fisher;
import interfaces.Rower;
import items.Boat;
import records.SkillSet;

public class Slave extends Human implements Rower, Fisher {
    private PirateGuard guard;
    private boolean isfree;

    public Slave(String name, SkillSet skills, PirateGuard guard){
        super(name, skills);
        this.isfree=false;
        this.guard=guard;
    }

    private void tryEscape(PirateGuard guard, WeatherCondition condition, Boat boat) throws EscapeFailedException {
        guard.setElite(this);
        guard.makeDecision(condition,boat);
        int guardScore = guard.getSkills().strength();
        int slaveScore = this.getSkills().strength();
        if (guard.isElite()==true) {
            guardScore+=10;
        }
        if (!guard.isVigilaint()){
            slaveScore+=10;
        }
        if (slaveScore<guardScore){
            throw new EscapeFailedException(slaveScore,guardScore);
        }
        else {
            this.isfree = true;
        }
    }
    private void tryEscape(PirateGuard guard, Slave slave2, WeatherCondition condition, Boat boat) throws EscapeFailedException {
        guard.setElite(this);
        guard.makeDecision(condition,boat);
        int guardScore = guard.getSkills().strength();
        int slaveScore = this.getSkills().strength()+slave2.getSkills().strength();
        if (guard.isElite()==true) {
            guardScore+=10;
        }
        if (!guard.isVigilaint()){
            slaveScore+=10;
        }
        if (slaveScore<guardScore){
            throw new EscapeFailedException(slaveScore,guardScore);
        }
        else {
            this.isfree = true;
            slave2.isfree=true;
        }
    }

    public boolean getisfree(){
        return isfree;
    }

    @Override
    public void row(Boat boat) {
        while (boat.getDistance() < 50 && super.getStamina()>0) {
            boat.addDistance(this);
            super.reduceStamina(15 - getSkills().rowingSkill());
            System.out.println(getName() + " гребет,сил осталось: " + getStamina());
        }
    }

    @Override
    public void fish(Boat boat) {
        while (boat.getFish()<50 && getStamina()>0) {
            int caught = getSkills().fishingSkill();
            boat.addFish(caught);
            reduceStamina(5);
        }
    }

    @Override
    public void makeDecision(WeatherCondition condition, Boat boat){
        if (boat.getFish()>=50){
            switch (condition){
                case STORM,FOG:
                    try{
                        tryEscape(guard, condition, boat);
                        if (isfree==true){
                            System.out.println("Побег удался!");
                        }
                    } catch (EscapeFailedException err){
                        System.out.println(err.getMessage());
                        boat.returnToHarbor(this);
                    }
                    break;
                case CLEAR:
                    System.out.println("Погода не позволила осуществить попытку побега");
                    break;
            }
        }
    }
}
