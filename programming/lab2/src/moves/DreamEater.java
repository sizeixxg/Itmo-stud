package moves;

import ru.ifmo.se.pokemon.*;

public final class DreamEater extends SpecialMove {
    public DreamEater(){
        super(Type.PSYCHIC, 100, 1);
    }
    @Override
    protected String describe(){
        return "использует Dream Eater";
    }
    @Override
    protected boolean checkAccuracy(Pokemon att, Pokemon def){
        if (def.getCondition()==Status.SLEEP){
            return super.checkAccuracy(att, def);
        }
        else
            return false;
    }
    @Override
    protected void applySelfDamage(Pokemon att, double damage) {
        att.setMod(Stat.HP, -(int)Math.round(damage/2));
    }
}
