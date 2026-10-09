package moves;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public final class DoubleEdge extends PhysicalMove {
    public DoubleEdge(){
        super(Type.NORMAL, 120, 1);
    }
    @Override
    protected String describe(){
        return "использует Double-Edge";
    }
    @Override
    protected void applySelfDamage(Pokemon att, double damage){
        att.setMod(Stat.HP, (int)Math.round(damage/3));
    }
}
