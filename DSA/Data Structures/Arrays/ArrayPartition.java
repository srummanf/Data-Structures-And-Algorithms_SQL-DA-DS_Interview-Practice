/*
 * You are given an integer array nums of size n and a positive integer k.

Divide the array into one or more arrays of size 3 satisfying the following conditions:

Each element of nums should be in exactly one array.
The difference between any two elements in one array is less than or equal to k.
Return a 2D array containing all the arrays. If it is impossible to satisfy the conditions, return an empty array. And if there are multiple answers, return any of them.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayPartition {

  public int[][] divideArray(int[] nums, int k) {
    Arrays.sort(nums);
    List<int[]> res = new ArrayList<>();
    for (int i = 2; i < nums.length; i += 3) {
      if (nums[i] - nums[i - 2] > k) return new int[][] {};
      res.add(new int[] { nums[i - 2], nums[i - 1], nums[i] });
    }
    return res.toArray(new int[res.size()][]);
  }

  public static void main(String[] args) {
    ArrayPartition ap = new ArrayPartition();
    int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8 };
    int k = 3;
    int[][] res = ap.divideArray(nums, k);
    for (int[] arr : res) {
      for (int i : arr) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }
}
