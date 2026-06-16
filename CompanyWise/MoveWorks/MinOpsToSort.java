// Asked in OA
// https://www.geeksforgeeks.org/minimize-moves-to-sort-array-in-non-decreasing-order-by-breaking-elements-in-two-parts/

// https://www.youtube.com/watch?v=kFe_LRWuZjE

// Java code to implement the approach

/** Minimum Splits to Make Array Non-Decreasing

Problem Statement:
You are given an array of integers. You can split any element into multiple smaller integers whose sum equals the original element. Find the minimum number of splits needed to make the entire array sorted in non-decreasing order.

Example:

Input: [3, 2, 4]  
Output: 1  

Explanation:  
- Split 3 into [1, 2].  
- Now the array becomes [1, 2, 2, 4], which is non-decreasing.  


Intuition:
To avoid decreasing order, we must ensure each element from right to left is ≤ the next. If not, split it into groups that fit within the next element.

Key Steps:

Start from the last element, move backwards.

If the current element > next, split it into groups small enough so that its largest group ≤ next.

Count splits as (value - 1) / next.

Update next = largest group after split.

Return total splits. */

import java.lang.*;
import java.util.*;

class GFG {

  // Function to count the minimum
  // number of splits
  public static int minimumSplits(int arr[], int n) {
    int totalSplits = 0;

    // Get the value at the last index
    int prevVal = arr[n - 1];

    for (int idx = n - 2; idx >= 0; idx--) {
      totalSplits += (arr[idx] - 1) / prevVal;
      int numGroups = ((arr[idx] - 1) / prevVal + 1);
      prevVal = arr[idx] / numGroups;
    }

    return totalSplits;
  }

  // Driver code
  public static void main(String[] args) {
    int arr[] = { 3, 2, 4 };
    int N = arr.length;

    int minSplit = minimumSplits(arr, N);
    System.out.print(minSplit);
  }
}
