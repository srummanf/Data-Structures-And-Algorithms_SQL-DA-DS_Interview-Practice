// class Solution {
//     int[] w;

//     public Solution(int[] w) {
//         this.w = w;
//     }

//     public int pickIndex() {
//         if(w.length==1) return 1;
//         int sum = 0;
//         for(int i: w){
//             sum+=i;
//         }
//         int random = (int) ((Math.random() * (w.length-1 - 0)) + 0);

//         return w[random]/sum;
//     }
// }

// /**
//  * Your Solution object will be instantiated and called as such:
//  * Solution obj = new Solution(w);
//  * int param_1 = obj.pickIndex();
//  */

import java.util.Random;

class Solution {
    private int[] prefixSums;
    private int totalSum;
    private Random random;

    public Solution(int[] w) {
        this.prefixSums = new int[w.length];
        this.totalSum = 0;
        this.random = new Random();

        for (int i = 0; i < w.length; i++) {
            totalSum += w[i];
            prefixSums[i] = totalSum;
        }
    }

    public int pickIndex() {
        int target = random.nextInt(totalSum) + 1; // Generate a random value between 1 and totalSum

        int left = 0;
        int right = prefixSums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (prefixSums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
