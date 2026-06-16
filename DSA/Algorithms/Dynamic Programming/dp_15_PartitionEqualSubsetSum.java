// DP  14

// Recursive solutione
// boolean f(int ind, int target, int arr[]){
//     if(target==0) return true;
//     if(ind==0) return arr[0]= =target; --> This will return true if array[0] equal to target

//     boolean nottake = f(ind-1, target, arr);
//     boolean take = false;
//     if(a[ind]<= target){
//         take = f(ind-1, target-a[ind], arr);
//     }

//     return take || nottake;
// }
class Solution {
    public boolean f(int ind, int target, int[] arr, int[][] dp) {
        if (target == 0)
            return true;
        if (ind == 0)
            return arr[0] == target;
        if (dp[ind][target] != -1)
            return dp[ind][target] == 0 ? false : true;

        boolean notTaken = f(ind - 1, target, arr, dp);

        boolean taken = false;
        if (arr[ind] <= target)
            taken = f(ind - 1, target - arr[ind], arr, dp);

        dp[ind][target] = notTaken || taken ? 1 : 0;
        return notTaken || taken;
    }

    public boolean canPartition(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if (sum % 2 != 0)
            return false;
        int dp[][] = new int[n][sum / 2 + 1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return f(n - 1, sum / 2, arr, dp);
    }
}



import java.util.ArrayList;
import java.util.Arrays;

public class dp_15_PartitionEqualSubSeqSum {

  boolean f(int ind, int target, int arr[]) {
    if (target == 0) return true;
    if (ind == 0) return arr[0] == target;

    boolean nottake = f(ind - 1, target, arr);
    boolean take = false;
    if (arr[ind] <= target) {
      take = f(ind - 1, target - arr[ind], arr);
    }

    return take || nottake;
  }

  // Memoization

  public static boolean f(int ind, int target, int[] arr, int[][] dp) {
    // If the target sum is achieved, return true
    if (target == 0) return true;

    // If we have considered all elements but haven't reached the target, return
    // false
    if (ind == 0) return arr[0] == target;

    // If the result for this subproblem has already been calculated, return it
    if (dp[ind][target] != -1) return dp[ind][target] == 0 ? false : true;

    // Try not taking the current element
    boolean notTaken = f(ind - 1, target, arr, dp);

    // Try taking the current element if it doesn't exceed the target
    boolean taken = false;
    if (arr[ind] <= target) taken = f(ind - 1, target - arr[ind], arr, dp);

    // Store the result in the DP table and return whether either option was
    // successful
    dp[ind][target] = notTaken || taken ? 1 : 0;
    return notTaken || taken;
  }

  // Tabulation
  public static boolean fTab(int[][] dp, int[] arr, int target) {
    int n = arr.length;

    // If the target is 0, we can always achieve it
    for (int i = 0; i < n; i++) dp[i][0] = 1;

    // If we have only one element, we can achieve the target if the element is
    // equal to it
    if (arr[0] <= target) dp[0][arr[0]] = 1;

    // Consider all elements an  d target sums
    for (int i = 1; i < n; i++) {
      for (int j = 1; j <= target; j++) {
        // If we can achieve the current target sum without the current element, we can
        // achieve
        // it with the current element as well
        if (dp[i - 1][j] == 1) dp[i][j] = 1;

        // If the current element is less than the target, we can achieve the current
        // target by
        // either including or excluding the current element
        if (arr[i] <= j) {
          if (dp[i - 1][j - arr[i]] == 1) dp[i][j] = 1;
        }
      }
    }

    // Return whether we can achieve the target sum with all elements
    return dp[n - 1][target] == 1;
  }

  public static boolean subsetSumToK(int n, int k, int arr[]) {
    // Write your code here.
    int dp[][] = new int[n][k + 1];
    int dp2[][] = new int[n][k + 1];
    for (int row[] : dp) Arrays.fill(row, -1);
    for (int row[] : dp2) Arrays.fill(row, -1);
    // return f(n - 1, k, arr, dp);
    return fTab(dp2, arr, k);
  }

  // Bitwise Ops
  public static int findWays(int num[], int tar) {
    // Write your code here.
    int ans = 0;
    int sum = 0;
    int n = num.length;
    ArrayList<Integer> arr = new ArrayList<>();
    int powSize = (int) Math.pow(2, n);
    for (int counter = 0; counter < powSize; counter++) {
      for (int j = 0; j < n; j++) {
        if ((counter & (1 << j)) != 0) {
          // System.out.print(num[j]);
          sum += num[j];
        }
      }
      if (sum == tar) {
        ans++;
      }
      sum = 0;
      // System.out.println();
    }
    return ans;
  }

  public static void main(String[] args) {
    int arr[] = { 1, 2, 3, 4, 5 };
    int n = arr.length;
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += arr[i];
    }
    System.out.println(subsetSumToK(n, sum / 2, arr));
    System.out.println(findWays(arr, sum / 2));
  }
}
