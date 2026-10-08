package moves;

import ru.ifmo.se.pokemon.*;

public final class Swagger extends StatusMove {
    public Swagger(){
        super(Type.NORMAL, 0, 0.85);
    }
    @Override
    protected void applyOppEffects(Pokemon target){
        Effect.confuse(target);
        target.setMod(Stat.ATTACK, 2);
    }
    @Override
    protected String describe(){
        return "использует Сваггер";
    }
}
