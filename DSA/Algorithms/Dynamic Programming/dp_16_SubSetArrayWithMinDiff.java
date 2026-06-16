import java.util.Arrays;

public class dp_16_SubSetArrayWithMinDiff {

  public static boolean bruteDPsum(int idx, int target, int[] arr) {
    if (idx == 0) return arr[0] == target;
    if (target == 0) return true;
    boolean nottake = bruteDPsum(idx - 1, target, arr);
    boolean take = false;
    if (arr[idx] <= target) {
      take = bruteDPsum(idx - 1, target - arr[idx], arr);
    }
    return take || nottake;
  }

  public static int fTab(int[][] dp, int[] arr, int target) {
    int n = arr.length;

    for (int i = 0; i < n; i++) dp[i][0] = 1;

    if (arr[0] <= target) dp[0][arr[0]] = 1;

    for (int i = 1; i < n; i++) {
      for (int j = 1; j <= target; j++) {
        if (dp[i - 1][j] == 1) dp[i][j] = 1;

        if (arr[i] <= j) {
          if (dp[i - 1][j - arr[i]] == 1) dp[i][j] = 1;
        }
      }
    }

    int mini = Integer.MAX_VALUE;
    for (int i = 0; i <= target; i++) {
      int a = i;
      int b = target - i;
      if (dp[n - 1][i] == 1) {
        mini = Math.min(mini, Math.abs(a - b));
      }
    }
    return mini;
  }

  public static void main(String[] args) {
    int[] arr = { 14, 13, 7 };
    int target = 0;
    for (int i : arr) {
      target = target + i;
    }
    int n = arr.length;
    int[][] dp = new int[n][target + 1];
    for (int[] row : dp) Arrays.fill(row, -1);
    System.out.println(fTab(dp, arr, target));

    int minans = Integer.MAX_VALUE;
    int a = Integer.MIN_VALUE;
    int b = Integer.MAX_VALUE;
    int s = 0;
    for (int i : arr) {
      a = Math.max(a, i);
      b = Math.min(b, i);
      s += i;
    }
    for (int i = a; i <= b; i++) {
      boolean check = bruteDPsum(arr.length - 1, s-i, arr);
      if (check) {
        minans = Math.min(minans, i);
        System.out.println(a + "--" + b + "---" + minans);
      }
    }
  }
}
