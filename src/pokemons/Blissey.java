package pokemons;

import moves.ChargeBeam;

public final class Blissey extends Chansey {
    public Blissey(String name, int level){
        super(name, level);
        setStats(255, 10, 10, 75, 135, 55);
        addMove(new ChargeBeam());
    }
}
