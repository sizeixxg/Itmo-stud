package characters;

import enums.WeatherCondition;
import interfaces.Rower;
import items.Boat;
import records.SkillSet;

public class PirateGuard extends Human implements Rower {
    private boolean vigilaint;
    private boolean Elite;

    public PirateGuard(String name, SkillSet skills){
        super(name, skills);
        this.vigilaint=false;
        this.Elite=false;
    }

    public boolean isElite(){
        return this.Elite;
    }
    public boolean isVigilaint(){
        return this.vigilaint;
    }

    @Override
    public void row(Boat boat) {
        while (boat.getDistance() < 50 && super.getStamina()>0) {
            boat.addDistance(this);
            super.reduceStamina(15 - getSkills().rowingSkill());
            System.out.println(getName() + " тоже гребет,сил осталось: " + getStamina());
        }
    }

    @Override
    public void makeDecision(WeatherCondition condition, Boat boat){
        switch (condition) {
            case FOG:
                this.vigilaint=false;
                break;
            case CLEAR:
                this.vigilaint=true;
                break;
            case STORM:
                this.vigilaint=false;
                break;
        }
    }
    public void setElite(Slave rab){
        if (rab.getSkills().fishingSkill()>5){
            Elite=false;
        }
        else {
            Elite = true;
        }
    }
}
