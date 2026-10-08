import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

public final class Flamethrower extends SpecialMove {
    public Flamethrower(){
        super(Type.FIRE, 90, 1);
    }
    @Override
    protected String describe(){
        return "жеска выпускает огонь";
    }
    @Override
    protected void applyOppEffects(Pokemon target){
        if (Math.random()<0.1){
            Effect.burn(target);
        }
    }
}
