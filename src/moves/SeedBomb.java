package moves;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Type;

public final class SeedBomb extends PhysicalMove {
    public SeedBomb(){
        super(Type.GRASS, 80, 1);
    }
    @Override
    protected String describe(){
        return "бросает семенную бобму";
    }
}
