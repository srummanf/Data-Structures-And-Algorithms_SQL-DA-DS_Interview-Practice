// Striver DP 3 : https://www.youtube.com/watch?v=EgG3jsGoPvQ&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=4&pp=iAQB

/** Problem Statement: Given an array of integers representing the heights of stones in a river,
 * a frog is on the first stone and wants to reach the last stone. The frog can jump to the next stone or
 * skip one stone. The cost of a jump is the absolute difference between the heights of the two stones.
 * Find the minimum cost to reach the last stone.
 *
 * Sample Input: [10, 20, 30, 10]
 * Sample Output: 20.0
 * Example: For the input [10, 20, 30, 10], the frog can jump from stone 1 to stone 2 (cost = 10),
 * then from stone 2 to stone 4 (cost = 20), for a total cost of 30.
 * Or it can jump from stone 1 to stone 3 (cost = 20),then from stone 3 to stone 4 (cost = 20), for a total cost of 40.
 * The minimum cost is 30. */
class dp_3_FrogJump {

    int left, right;

    int jump_memoization_topdown(int arr[], int ind, int dp[]) {

        if (dp[ind] != -1) {
            return dp[ind];
        }
        
        if (ind == 0) {
            return 0;
        }

        if (ind == 1) {
            return Math.abs(arr[ind] - arr[ind - 1]);
        }

        left
                = jump_memoization_topdown(arr, ind - 1, dp)
                + Math.abs(arr[ind] - arr[ind - 1]);
        if (ind > 1) {
            right
                    = jump_memoization_topdown(arr, ind - 2, dp)
                    + Math.abs(arr[ind] - arr[ind - 2]);
        }
        return dp[ind] = Math.min(left, right);
    }

    int jump_tabulation_bottomup(int arr[], int ind) {
        int dp[] = new int[arr.length];
        int l = 0, r = 0;
        dp[0] = 0;
        dp[1] = Math.abs(arr[1] - arr[0]);
        for (int i = 2; i < arr.length; i++) {
            l = dp[i - 1] + Math.abs(arr[i] - arr[i - 1]);
            if (i > 1) {
                r = dp[i - 2] + Math.abs(arr[i] - arr[i - 2]);
            }
            dp[i] = Math.min(l, r);
        }
        // System.out.println(Arrays.toString(dp));
        return dp[arr.length - 1];
    }

    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 10};
        int n = arr.length;
        int dp[] = new int[n];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        dp_3_FrogJump f = new dp_3_FrogJump();
        System.out.println(f.jump_memoization_topdown(arr, arr.length - 1, dp));
        System.out.println(f.jump_tabulation_bottomup(arr, arr.length - 1));
    }
}
