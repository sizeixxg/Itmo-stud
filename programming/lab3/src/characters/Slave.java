package characters;

import enums.WeatherCondition;
import interfaces.Fisher;
import interfaces.Rower;
import items.Boat;
import records.SkillSet;

public class Slave extends Human implements Rower, Fisher {
    private boolean isfree;
    public Slave(String name, SkillSet skills){
        super(name , skills);
        this.isfree=false;
    }

    private void tryEscape(PirateGuard guard){

    }

    public boolean isIsfree(){
        return isfree;
    }

    @Override
    public void row(Boat boat){
        super.reduceStamina(15 - getSkills().rowingSkill());
        System.out.println(getName()+" гребет,сил осталось: "+getStamina());
    }

    @Override
    public void fish(Boat boat) {
        while (boat.getFish()<50 || getStamina()>0) {
            int caught = getSkills().fishingSkill();
            boat.addFish(caught);
            reduceStamina(5);
        }
    }

    @Override
    public void makeDecision(WeatherCondition condition, Boat boat){
        if (condition==WeatherCondition.FOG && boat.getFish()>=50){

        }
    }



}
