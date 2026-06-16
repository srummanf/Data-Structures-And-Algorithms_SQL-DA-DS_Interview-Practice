import java.util.*;
// Memoization 
class Fibonacci {

  int fib(int n, int dp[]) {
    if (n <= 1) {
      return n;
    } else if (dp[n] != -1) {
      return dp[n];
    } else {
      return dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
    }
  }

  public static void main(String[] args) {
    Fibonacci f = new Fibonacci();
    int n = 10;
    int dp[] = new int[n + 1];
    Arrays.fill(dp, -1);
    System.out.println(f.fib(n, dp));
  }
}


// For tabulation  --> Bottom Up
// dp[0] = 0;
// dp[1] = 1;
// for (int i = 2; i <= n; i++) {
//   dp[i] = dp[i - 1] + dp[i - 2];
// } 