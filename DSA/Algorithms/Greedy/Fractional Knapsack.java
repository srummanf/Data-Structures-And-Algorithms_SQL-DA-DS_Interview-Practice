class Solution {
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) {
        // Create an array to store the value-to-weight ratios along with indices
        double[] ratio = new double[n];
        for (int i = 0; i < n; i++) {
            ratio[i] = (double) arr[i].value / arr[i].weight;
        }

        // Sort the items manually based on the ratio
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ratio[i] < ratio[j]) {
                    // Swap ratios
                    double tempRatio = ratio[i];
                    ratio[i] = ratio[j];
                    ratio[j] = tempRatio;

                    // Swap corresponding items
                    Item tempItem = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tempItem;
                }
            }
        }

        double ans = 0.0;

        // Iterate through sorted items and fill the knapsack
        for (int i = 0; i < n; i++) {
            if (arr[i].weight <= W) {
                // If the item can fit fully in the knapsack
                ans += arr[i].value;
                W -= arr[i].weight;
            } else {
                // If the item can only partially fit in the knapsack
                ans += (arr[i].value * ((double) W / arr[i].weight));
                break; // the knapsack is full now
            }
        }

        return ans;
    }
}
