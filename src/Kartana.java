import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public final class Kartana extends Pokemon {
    public Kartana(String name, int level) {
        super(name, level);
        setType(Type.GRASS, Type.STEEL);
        setStats(59, 181, 131, 59, 31, 109);
        setMove(new SeedBomb(), new Flamethrower(), new DoubleEdge(), new Confide());
    }
}
