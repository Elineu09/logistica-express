package logistics;

import java.util.ArrayList;

import logistics.io.DataLoader;
import logistics.knapsack.Knapsack;
import logistics.model.PackageItem;
import logistics.util.PerformanceMonitor;

public class Main {
    public static void main(String[] args) throws Exception {
        String filePath = "data/delivery_data.txt";

        DataLoader.LoadResult data = DataLoader.loadFile(filePath);
        
        ArrayList<PackageItem> items = data.items;
        int capacity = data.capacity;
        
        System.out.println("\n###### LOGÍSTICA EXPRESS ######");
        System.out.println("Capacidade do camião: " + capacity + "KG");
        System.out.println("Quantidade de pacotes: " + items.size());
        
        PerformanceMonitor monitor = new PerformanceMonitor();
        monitor.start();
        
        Knapsack.Result result = Knapsack.solve(items, capacity);
        monitor.stop();

        result.display();
    }
}