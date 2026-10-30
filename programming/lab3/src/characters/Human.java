package characters;

import records.SkillSet;

public abstract class Human {
    final private String name;
    private int stamina=100;
    private final SkillSet skills;

    public Human(String name, SkillSet skills){
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

    protected void reduceStamina(int amount){
        stamina-=amount;
    }

}
