package items;

public class Boat {
    private int fishStock;

    public void addFish(int amount){
        this.fishStock+=amount;
    }
    public int getFish(){
        return fishStock;
    }
}
