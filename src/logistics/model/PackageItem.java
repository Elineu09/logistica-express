package logistics.model;

public class PackageItem {
        private int weight;
        private int value;

    public PackageItem(int weigth, int value) {
        this.weigth = weigth;
        this.value = value;
    }

    public int getWeigth() {
        return weigth;
    }

    public int getValue() {
        return value;
    }
}
