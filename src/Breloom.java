import ru.ifmo.se.pokemon.Type;

public final class Breloom extends Shroomish {
    public Breloom(String name, int level){
        super(name, level);
        setStats(60, 130, 80, 60, 60, 70);
        addType(Type.FIGHTING);
        addMove(new MachPunch());
    }
}
