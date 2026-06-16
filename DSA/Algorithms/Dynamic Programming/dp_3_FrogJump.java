// Striver DP 3 : https://www.youtube.com/watch?v=EgG3jsGoPvQ&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=4&pp=iAQB

class dp_3_FrogJump {

  float left, right;

  float jump_memoization_topdown(int arr[], int ind, float dp[]) {
    if (ind == 0) return 0.0f;
    if (dp[ind] != -1) return dp[ind];

    if (ind == 1) {
      return Math.abs(arr[ind] - arr[ind - 1]);
    }

    left =
      jump_memoization_topdown(arr, ind - 1, dp) +
      Math.abs(arr[ind] - arr[ind - 1]);
    if (ind > 1) {
      right =
        jump_memoization_topdown(arr, ind - 2, dp) +
        Math.abs(arr[ind] - arr[ind - 2]);
    }
    return dp[ind] = Math.min(left, right);
  }

  float jump_tabulation_bottomup(int arr[], int ind) {
    float dp[] = new float[arr.length];
    float l = 0.0f, r = 0.0f; // initialize r to 0.0f
    dp[0] = 0.0f;
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
    int arr[] = { 10, 20, 30, 10 };
    int n = arr.length;
    float dp[] = new float[n];
    float dp2[] = new float[n];
    for (int i = 0; i < dp.length; i++) {
      dp[i] = -1.0f;
      dp2[i] = -1.0f;
    }
    dp_3_FrogJump f = new dp_3_FrogJump();
    System.out.println(f.jump_memoization_topdown(arr, arr.length - 1, dp));
    System.out.println(f.jump_tabulation_bottomup(arr, arr.length - 1));
  }
}
