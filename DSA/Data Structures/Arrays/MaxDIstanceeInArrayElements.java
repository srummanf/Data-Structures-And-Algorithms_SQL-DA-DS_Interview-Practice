class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int n = arrays.size();
        int minVal = arrays.get(0).get(0);
        int maxVal = arrays.get(0).get(arrays.get(0).size() - 1);
        int maxDist = 0;

        for (int i = 1; i < n; i++) {
            List<Integer> array = arrays.get(i);
            int currentMin = array.get(0);
            int currentMax = array.get(array.size() - 1);

            // Update the max distance by considering current array's min and max
            maxDist = Math.max(maxDist, Math.abs(currentMax - minVal));
            maxDist = Math.max(maxDist, Math.abs(maxVal - currentMin));

            // Update minVal and maxVal to track global min and max values
            minVal = Math.min(minVal, currentMin);
            maxVal = Math.max(maxVal, currentMax);
        }

        return maxDist;
    }
}


// class Solution {
//     public int maxDistance(List<List<Integer>> arrays) {
//         int n = arrays.size();
//         int maxia = Integer.MIN_VALUE;
//         int maxib = Integer.MIN_VALUE;
//         int minia = Integer.MAX_VALUE;
//         int minib = Integer.MAX_VALUE;

//         int ans = Integer.MIN_VALUE;
//         for (int i = 0; i < n - 1; i++) {
//             int sa_n_a = arrays.get(i).size();
//             int sa_n_b = arrays.get(i + 1).size();
//             // mini = Math.min(arrays.get(i).get(0), mini);
//             // maxi = Math.max(arrays.get(i).get(sa_n - 1), maxi);
//             maxia = Math.max(arrays.get(i).get(sa_n_a - 1), maxia);
//             maxib = Math.max(arrays.get(i + 1).get(sa_n_b - 1), maxib);
//             minia = Math.min(arrays.get(i).get(0), minia);
//             minib = Math.min(arrays.get(i + 1).get(0), minib);

//             ans = Math.max(Math.abs(minia - minib), Math.max(Math.abs(minia - maxib),
//                     Math.max(Math.abs(maxia - minib), Math.max(ans, Math.abs(maxia - maxib)))));

//         }

//         return ans;

//     }
// }