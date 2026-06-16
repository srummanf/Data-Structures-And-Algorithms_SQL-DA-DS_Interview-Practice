// Striver DP 5 : https://www.youtube.com/watch?v=GrMBfJNk_NY&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=6

import java.util.*;

class dp_4_MaxSumOfNonAdjElem {

  // RECURSIVE SOL
  // f(ind){
  //     if(ind ==0) return a[0];
  //     if( ind < 0) return 0;
  //
  //     else
  //     pick = a[ind] + f(ind-2);
  //     nonpick = 0 + f(ind-1);

  //     return max(pick, nonpick);
  // }

  int topDownMemo(int ind, int a[], int DP[]) {
    if (ind == 0) return a[0];
    if (ind < 0) return 0;
    if (DP[ind] != -1) return DP[ind];
    int pick = a[ind] + topDownMemo(ind - 2, a, DP);
    int nonpick = 0 + topDownMemo(ind - 1, a, DP);

    return DP[ind] = (Math.max(pick, nonpick));
  }

  int bottomUpTabu(int a[]) {
    int DP[] = new int[a.length];
    DP[0] = a[0];
    for (int i = 1; i < a.length; i++) {
    //   int pick = a[i] + DP[i - 2];
    int pick = a[i];
    if(i>1){
        pick += DP[i-2];
    }
      int nonpick = 0 + DP[i - 1];
      DP[i] = Math.max(pick, nonpick);
    }
    return DP[a.length - 1];
  }

  int bottomUpTabuSpaceOptimised(int a[]) {
    int prev = a[0];
    int prev2 = 0;
    for (int i = 1; i < a.length; i++) {
    //   int pick = a[i] + DP[i - 2];
    int pick = a[i];
    if(i>1){
        pick += prev2;
    }
      int nonpick = 0 + prev;
      int curi = Math.max(pick, nonpick);

      prev2 = prev;
      prev = curi;
    }
    return prev;
  }

  public static void main(String[] args) {
    int a[] = { 5, 5, 10, 10, 5 };
    int n = a.length;
    int DP[] = new int[n];
    for (int i = 0; i < n; i++) {
      DP[i] = -1;
    }
    dp_4_MaxSumOfNonAdjElem m = new dp_4_MaxSumOfNonAdjElem();
    System.out.println(m.topDownMemo(n - 1, a, DP));
    System.out.println(m.bottomUpTabu(a));
    System.out.println(m.bottomUpTabuSpaceOptimised(a));
  }
}
