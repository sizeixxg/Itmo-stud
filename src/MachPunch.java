import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Type;

public final class MachPunch extends PhysicalMove {
    public MachPunch(){
        super(Type.FIGHTING, 40, 1, 1, 1);
    }
    @Override
    protected String describe(){
        return "использует Mach Punch";
    }
}
