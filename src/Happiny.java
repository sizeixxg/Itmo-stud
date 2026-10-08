import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Happiny extends Pokemon {
    public Happiny(String name, int level){
        super(name, level);
        setType(Type.NORMAL);
        setStats(100, 5, 5, 15, 65, 30);
        setMove(new Swagger(), new DreamEater());
    }
}
