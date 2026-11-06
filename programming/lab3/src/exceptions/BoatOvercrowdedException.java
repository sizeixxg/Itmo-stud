package exceptions;

public class BoatOvercrowdedException extends RuntimeException {
    private final int capacity;
    public BoatOvercrowdedException(int capacity){
        this.capacity=capacity;
    }

    @Override
    public String getMessage(){
        return "Лодка переполнена, рыб не был посажен" ;
    }
}
