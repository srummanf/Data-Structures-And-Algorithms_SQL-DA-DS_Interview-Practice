// DP 17
/**
 * Recurrence
 * f(ind, s){
 * if(ind == 0) return arr[0] == s ? 1:0;
 *if (s == 0) return 1;
 * int notpick = 0 + f(ind-1, s);
 * int pick = 0;
 * if(a[ind] <= s){
 * pick = 1 + f(ind-1, s-arr[ind]);
 * }
 * return notpick + pick;
 * }
 */
import java.util.*;

public class dp_17_CountSubSetSumEqualToK {

  public static int f(int ind, int s, int[] arr) {
    if (s == 0) return 1;
    if (ind == 0) return arr[0] == s ? 1 : 0;
    int notpick = f(ind - 1, s, arr);
    int pick = 0;
    if (arr[ind] <= s) {
      pick = f(ind - 1, s - arr[ind], arr);
    }
    return notpick + pick;
  }

  public static int DP_TopDown(int ind, int s, int[] arr, int[][] dp) {
    if (s == 0) return 1;
    if (ind == 0) return arr[0] == s ? 1 : 0;
    if (dp[ind][s] != -1) return dp[ind][s];
    int notpick = 0 + DP_TopDown(ind - 1, s, arr, dp);
    int pick = 0;
    if (arr[ind] <= s) {
      pick = DP_TopDown(ind - 1, s - arr[ind], arr, dp);
    }
    return dp[ind][s] = notpick + pick;
  }

  public static int DP_BottomUp(int ind, int s, int arr[]) {
    int dp[][] = new int[arr.length][s + 1];
    //base cond 1
    for (int i = 0; i < arr.length; i++) {
      dp[i][0] = 1;
    }
    //base cond 2
    if (arr[0] <= s) dp[0][arr[0]] = 1;

    for (int i = 1; i < arr.length; i++) {
      for (int j = 1; j <= s; j++) {
        int notpick = dp[i - 1][j];
        int pick = 0;
        if (arr[i] <= j) {
          pick = dp[i - 1][j - arr[i]];
        }
        dp[i][j] = notpick + pick;
      }
    }
    return dp[arr.length - 1][s];
  }

  public static void main(String[] args) {
    int[] arr = { 1, 4, 4, 5 };
    int s = 5;
    int[][] dp = new int[arr.length][s + 1];
    for (int[] row : dp) Arrays.fill(row, -1);
    System.out.println(f(arr.length - 1, s, arr));
    System.out.println(DP_TopDown(arr.length - 1, s, arr, dp));
    System.out.println(DP_BottomUp(arr.length - 1, s, arr));
  }
}
