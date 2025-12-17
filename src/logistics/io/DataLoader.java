package logistics.io;

import logistics.model.PackageItem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataLoader {

    public static class LoadResult {
        public int capacity;
        public ArrayList<PackageItem> items;

        public LoadResult(int capacity, ArrayList<PackageItem> items) {
            this.capacity = capacity;
            this.items = items;
        }
    }

    public static LoadResult loadFile(String path) {

        int capacity = 0;
        ArrayList<PackageItem> items = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            capacity = Integer.parseInt(br.readLine().trim());

            String line;

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");

                int weight = Integer.parseInt(parts[0].trim());
                int value = Integer.parseInt(parts[1].trim());

                items.add(new PackageItem(weight, value));
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return new LoadResult(capacity, items);
    }
}
