package logistics;

import logistics.io.DataLoader;
import logistics.knapsack.Knapsack;
import logistics.model.PackageItem;
import logistics.util.PerformanceMonitor;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        DataLoader.test();
        Knapsack.test();
        PackageItem.test();
        PerformanceMonitor.test();
    }
}