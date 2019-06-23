import java.util.ArrayList;

public class Rocket implements SpaceShip {

    private long cost;
    private int weight;
    private int maxWeight;
    private ArrayList<Item> cargo;

    Rocket(long cost, int weight) {
        this.cost = cost;
        this.weight = weight;
    }

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item i) {

        return (i.getWeight() + getWeight()) <= getMaxWeight();
    }

    @Override
    public boolean carry(Item i) {
        if (canCarry(i)) {
            cargo.add(i);
            weight += i.getWeight();
            return true;
        }
        else{
            return false;
        }
    }

    public long getCost() {
        return cost;
    }

    public int getWeight() {
        return weight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

}
