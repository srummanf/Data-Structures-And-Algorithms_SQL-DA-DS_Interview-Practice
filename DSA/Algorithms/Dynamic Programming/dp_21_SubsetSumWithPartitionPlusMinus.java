/**
 * DP 18
 * Count Partitions With Given Difference | Dp on Subsequences
 * [.,.,.,.,..,.,.] Divide the array into two parts such that the difference of the sum of the two parts is equal to the given difference.
 * Now S1 - S2 = D
 * TSum = Total Sum of Array
 * if we know S1, then S2 = TSum - S1
 * S1 - (TSum - S1) = D
 * 2S1 - TSum = D
 * S1 = (D + TSum) / 2
 * 
 * So we need subset sum whose value is (D+Tsum)/2 
 * 
 *  Recursive solutione
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
 */

import java.util.Arrays;

/**
 * SubsetSumWithPartition
 */
public class dp_21_SubsetSumWithPartitionPlusMinus {

  public static int f(int ind, int s, int[] arr) {
    if (s == 0) return 1;
    if (ind == 0) {
      if (s == 0 && arr[0] == 0) return 2;
      if (s == 0 || s == arr[0]) return 1;
      return 0;
    }
    int notpick = 0 + f(ind - 1, s, arr);
    int pick = 0;
    if (arr[ind] <= s) {
      pick = f(ind - 1, s - arr[ind], arr);
    }
    return notpick + pick;
  }

  public static int DP_TopDown(int ind, int s, int[] arr, int[][] dp) {
    if (s == 0) return 1;
    if (ind == 0) {
      if (s == 0 && arr[0] == 0) return 2;
      if (s == 0 || s == arr[0]) return 1;
      return 0;
    }
    if (dp[ind][s] != -1) return dp[ind][s];
    int notpick = 0 + DP_TopDown(ind - 1, s, arr, dp);
    int pick = 0;
    if (arr[ind] <= s) {
      pick = DP_TopDown(ind - 1, s - arr[ind], arr, dp);
    }
    return dp[ind][s] = notpick + pick;
  }

  public static void main(String[] args) {
    int[] arr = { 2, 3, 5, 6, 8, 10 };
    int d = 10;
    int tsum = 0;
    for (int i = 0; i < arr.length; i++) {
      tsum += arr[i];
    }
    if (tsum - d < 0 || (tsum + d) % 2 != 0) {
      System.out.println(0);
      return;
    }
    
    System.out.println(f(arr.length - 1, (d + tsum) / 2, arr));
    int[][] dp = new int[arr.length][(d + tsum) / 2 + 1];
    for (int[] row : dp) {
      Arrays.fill(row, -1);
    }
    System.out.println(DP_TopDown(arr.length - 1, (d + tsum) / 2, arr, dp));
  }
}
