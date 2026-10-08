package pokemons;

import moves.Confide;
import moves.SludgeBomb;
import moves.Swagger;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Shroomish extends Pokemon {
    public Shroomish(String name, int level) {
        super(name, level);
        setType(Type.GRASS);
        setStats(60, 40, 60, 40, 60 , 35);
        setMove(new Confide(), new Swagger(), new SludgeBomb());
    }
}
