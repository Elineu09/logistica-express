package logistics.model;

public class PackageItem {

    private int weight;
    private int value;

    public PackageItem(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }
}
