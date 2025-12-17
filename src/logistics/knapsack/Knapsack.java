package logistics.knapsack;

import logistics.model.PackageItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Knapsack {

    public static Result solve(List<PackageItem> items, int capacity) {
        int n = items.size();

        int[][] dp = new int[n + 1][capacity + 1];

        // Programação dinâmica
        for (int i = 1; i <= n; i++) {
            PackageItem item = items.get(i - 1);
            int weight = item.getWeight();
            int value = item.getValue();

            for (int w = 0; w <= capacity; w++) {
                if (weight > w) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(
                        dp[i - 1][w],
                        value + dp[i - 1][w - weight]
                    );
                }
            }
        }

        // Reconstrução dos itens selecionados
        int w = capacity;
        List<PackageItem> selectedItems = new ArrayList<>();

        for (int i = n; i > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                PackageItem item = items.get(i - 1);
                selectedItems.add(item);
                w -= item.getWeight();
            }
        }

        Collections.reverse(selectedItems);

        return new Result(dp[n][capacity], selectedItems);
    }
    public static class Result {
        private final int maxValue;
        private final List<PackageItem> selectedItems;

        public Result(int maxValue, List<PackageItem> selectedItems) {
            this.maxValue = maxValue;
            this.selectedItems = selectedItems;
        }

        public int getMaxValue() {
            return maxValue;
        }

        public List<PackageItem> getSelectedItems() {
            return selectedItems;
        }
 
        public void display() {
            int totalWeight = 0;

            System.out.println("\n\n###### RESULTADO ######");
            System.out.println("Valor económico máximo: $" + maxValue);

            for (PackageItem item : selectedItems){
                System.out.println("Item: " + item.getWeight() + "KG => $" + item.getValue());
                totalWeight += item.getWeight();
            }

            System.out.println("Peso total transportado: " + totalWeight + "KG");

        }
    }
}
