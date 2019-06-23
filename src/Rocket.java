public class Rocket implements SpaceShip {
    private int weight;
    private int weightMax;
    private int cost;

    public Rocket() {
        weight = 0;
        weightMax = 0;
    }

    public Rocket(int cost, int weight, int weightMax) {
        this.cost = cost;
        this.weight = weight;
        this.weightMax = weightMax;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setWeightMax(int weightMax) {
        this.weightMax = weightMax;
    }

    public int getWeight() {
        return weight;
    }

    public int getWeightMax() {
        return weightMax;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
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
    public boolean canCerry(Item item) {
        if (weight + item.getWeight() > weightMax) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void carry(Item item) {
        weight += item.getWeight();
    }
}
