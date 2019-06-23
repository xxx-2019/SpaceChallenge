
public class Item implements Comparable<Item>{
    private int weight;
    private String name;
    private boolean loaded;

    public Item() {
        weight = 0;
        name = "";
        loaded = false;
    }

    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
        loaded = false;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isLoaded() {
        return loaded;
    }

    public void setLoaded(boolean loading) {
        this.loaded = loading;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Item o) {
        if (this.weight == o.weight) {
            return 0;
        } else {
            if (this.weight > o.weight) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
