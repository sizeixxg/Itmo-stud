import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

public final class SludgeBomb extends SpecialMove {
    public SludgeBomb(){
        super(Type.POISON, 90, 1);
    }
    @Override
    protected String describe(){
        return "ядовито плюет";
    }
    @Override
    protected void applyOppEffects(Pokemon target){
        if (Math.random()<0.3)
            Effect.poison(target);
    }
}
