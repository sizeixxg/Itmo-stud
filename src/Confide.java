import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public final class Confide extends StatusMove {
    public Confide(){
        super(Type.NORMAL,0,1);
    }
    @Override
    protected String describe(){
        return "уменьшил заряд специальной атаки противника на 1";
    }
    @Override
    protected void applyOppEffects(Pokemon target){
        target.setMod(Stat.SPECIAL_ATTACK, -1);
    }
    @Override
    protected boolean checkAccuracy(Pokemon att, Pokemon def){
        return true;
    }
}
