// Asked in Mock

// f(n-1, t) number of n to form t


/**
 * INFINITE SUPPLY , MULTIPLY ----- DONT MOVE
 * int nottake = 0 + f(ind-1, t)
 * int take = 0;
 * if(arr[ind] <= t) take = 1 + f(ind, t-arr[ind])
 * return Math.min(take, nottake)
 *
 * check for base case at index 0
 * if(ind == 0){
 * if(t%arr[i] == 0) return t/arr[i];
 * else return 9999999////1e9;}
 */

// *** In DP , whenever you return SUM --> for Base Case : if Minimum is asked , return Integer.MAX and vice versa (Similar problem is seen in dp_19_KnapSack)

public class dp_20_MinCoins {

  static int recursion(int ind, int t, int[] arr) {
    if (ind == 0) {
      if (t % arr[0] == 0) {
        return t / arr[0];
      } else {
        return (int) Math.pow(10, 9);
      }
    }
    int nottake = recursion(ind - 1, t, arr);
    int take = (int) Math.pow(10, 9);
    if (arr[ind] <= t) {
      take = 1 + recursion(ind, t - arr[ind], arr);
    }
    return Math.min(take, nottake);
  }

  //O(n*t) time and O(n*t) space
  static int DP_topdown(int ind, int t, int[] arr, int[][] dp) {
    if (ind == 0) {
      if (t % arr[0] == 0) return t / arr[0]; else return (int) Math.pow(10, 9);
    }
    if (dp[ind][t] != -1) return dp[ind][t];
    int nottake = 0 + DP_topdown(ind - 1, t, arr, dp);
    int take = (int) Math.pow(10, 9);
    if (arr[ind] <= t) {
      take = 1 + DP_topdown(ind, t - arr[ind], arr, dp);
    }
    return dp[ind][t] = Math.min(take, nottake);
  }

  // Tabulation
  /**
   * base case
   * target can be 0  to T
   * for(T = 0 to target){
   * if(T%arr[0] == 0) dp[0][T] = T/arr[0]; else dp[0][T] = 99999999;}
   *
   * for ind 1 to n-1
   * for T = 0 to target
   * copy the recursion
   */

  static int DP_bottomup(int t, int[] arr, int[][] dp) {
    for (int T = 0; T <= t; T++) {
      if (T % arr[0] == 0) {
        dp[0][T] = T / arr[0];
      } else {
        dp[0][T] = (int) Math.pow(10, 9);
      }
    }

    for (int i = 1; i < arr.length; i++) {
      for (int j = 0; j <= t; j++) {
        int nottake = 0 + dp[i - 1][t];
        int take = (int) Math.pow(10, 9);
        if (arr[i] <= t) {
          take = 1 + dp[i][t - arr[i]];
        }
        dp[i][t] = Math.min(take, nottake);
      }
    }

    return dp[arr.length - 1][t];
  }

  public static void main(String[] args) {
    int[] arr = { 1, 2, 5 };
    int t = 11;
    int[][] dp = new int[arr.length][t + 1];
    for (int row[] : dp) java.util.Arrays.fill(row, -1);
    System.out.println(
      recursion(arr.length - 1, t, arr) == (int) Math.pow(10, 9)
        ? -1
        : recursion(arr.length - 1, t, arr)
    );

    System.out.println(
      DP_topdown(arr.length - 1, t, arr, dp) == (int) Math.pow(10, 9)
        ? -1
        : DP_topdown(arr.length - 1, t, arr, dp)
    );

    System.out.println(
      DP_bottomup(t, arr, dp) == (int) Math.pow(10, 9)
        ? -1
        : DP_bottomup(t, arr, dp)
    );
  }
}
