package characters;

import enums.WeatherCondition;
import records.SkillSet;
import java.util.Objects;

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

    protected void reduceStamina(int amount) throws IllegalArgumentException{
        if (amount<0) {
            throw new IllegalArgumentException("Выносливость не может быть отрицательной");
        }
        if (stamina-amount>0) {
            stamina -= amount;
        }
        else
            stamina=0;
    }
    abstract protected void makeDecision(WeatherCondition condition);

    @Override
    public String toString(){
        return "имя= "+ name + "остаток сил= "+ stamina + "умения: ;" +skills;
    }
    @Override
    public boolean equals(Object obj){
        if (obj==this)
            return true;
        if (obj == null || obj.getClass()!=this.getClass())
            return false;
        Human o = (Human) obj;

        return (Objects.equals(name, o.name)||Objects.equals(skills, o.skills));
    }

    @Override
    public int hashCode(){
        return Objects.hash(name,skills);
    }


}
