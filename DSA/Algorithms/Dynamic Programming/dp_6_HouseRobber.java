// Striver DP 6 : https://www.youtube.com/watch?v=3WaxQMELSkw&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=7

// Similar to prev questiom, [MaxSumOfNonAdjElem.java], only difference is that the array is circular now || First and Last elements are adjacent

import java.util.Arrays;

class dp_6_HouseRobber {

  int topDownMemo(int ind, int a[], int DP[]) {
    if (ind == 0) return a[0];
    if (ind < 0) return 0;
    if (DP[ind] != -1) return DP[ind];
    int pick = a[ind] + topDownMemo(ind - 2, a, DP);
    int nonpick = 0 + topDownMemo(ind - 1, a, DP);

    return DP[ind] = (Math.max(pick, nonpick));
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
    dp_6_HouseRobber h = new dp_6_HouseRobber();
    int a[] = { 5, 5, 10, 100, 10, 5 };

    int DP1[] = new int[a.length];
    int DP2[] = new int[a.length]; 
    Arrays.fill(DP1, -1);
    Arrays.fill(DP2, -1);

    int temp[] = new int[a.length - 1];
    for (int i = 0; i < a.length - 1; i++) {
      temp[i] = a[i];
    }
    System.out.println(Arrays.toString(temp));
    int val1 = h.topDownMemo(0, temp, DP1);
    int v1= h.bottomUpTabuSpaceOptimised(temp);
    
    for (int i = 1; i < a.length; i++) {
        temp[i - 1] = a[i];
    }
    System.out.println(Arrays.toString(temp));
    int val2 = h.topDownMemo(0, temp, DP2);
    int v2= h.bottomUpTabuSpaceOptimised(temp);

    System.out.println(Math.max(v1, v2));
  }
}
