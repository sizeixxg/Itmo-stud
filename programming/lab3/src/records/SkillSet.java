package records;

public record SkillSet(int fishingSkill, int strenght, int rowingSkill) {
    public SkillSet{
        if (fishingSkill<0 || strenght<0 || rowingSkill<0) {
            throw new IllegalArgumentException("Значения умений не могут быть отрицательными");
        }
    }
}
