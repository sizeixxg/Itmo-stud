package characters;

import enums.WeatherCondition;
import records.SkillSet;

public abstract class Human {
    private final String name;
    private int stamina=100;
    private final SkillSet skills;

    protected Human(String name, SkillSet skills){
        this.name=name;
        this.skills=skills;
    }

    public String getName(){
        return name;
    }
    public int getStamina(){
        return stamina;
    }
    public SkillSet getSkills(){
        return skills;
    }

    protected void reduceStamina(int amount) throws IllegalAccessException{
        if (amount<0)
            throw new IllegalAccessException("Выносливость не может быть отрицательной");
        if (stamina-amount>0)
            stamina-=amount;
        else
            stamina=0;
    }
    abstract protected void makeDecision(WeatherCondition condition);




}
