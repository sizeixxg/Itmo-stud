import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public final class SeismicToss extends PhysicalMove {
    private int level;
    public SeismicToss(){
        super(Type.FIGHTING, 0 , 1);
    }
    @Override
    protected String describe(){
        return "использует Seismic Toss";
    }

    @Override
    protected double calcBaseDamage(Pokemon att, Pokemon def) {
         level = att.getLevel();
         return level;
    }

    @Override
    protected void applyOppDamage(Pokemon def, double damage) {
        def.setMod(Stat.HP, level);
    }
}
