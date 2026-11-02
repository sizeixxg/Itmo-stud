package interfaces;
import items.Boat;
import records.SkillSet;

public interface Rower {
    SkillSet getSkills();
    String getName();
    void row(Boat boat);
}
