/** This is Leetcode Hard question : 446
 * Video Solution: https://www.youtube.com/watch?v=cau0JE1q_ZA
 * Code : https://tutorialcup.com/leetcode-solutions/arithmetic-slices-ii-subsequence-leetcode-solution.htm
 *
 * Major Learning: Array of Map, Manipulation of old matrix and how to remember it
 * Dynamic Programming → DP with HashMap / State Compression

 */

import java.util.*;

public class Arithmetic_II_Subsequence {

  public int numOfArithmeticSlices(int[] nums) {
    int n = nums.length;
    long ans = 0;
    Map<Integer, Integer>[] frequencyArrayMap = new Map[n]; // Array of Map
    for (int i = 0; i < n; i++) {
      frequencyArrayMap[i] = new HashMap<>(); // Initialize each element of array with a new HashMap
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        long commondiff = (long) nums[i] - (long) nums[j];
        // This line isnt necessary, but for more fruitful optimisation   if(commondiff<Integer.MIN_VALUE || commondiff> Integer.MAX_VALUE)continue;
        int diff = (int) commondiff;
        int prevFreq = frequencyArrayMap[j].getOrDefault(diff, 0);
        int currFreq = frequencyArrayMap[i].getOrDefault(diff, 0);
        ans += prevFreq;
        frequencyArrayMap[i].put(diff, prevFreq + currFreq + 1);
      }
    }
    return (int) ans;
  }

  public static void main(String[] args) {
    Arithmetic_II_Subsequence obj = new Arithmetic_II_Subsequence();
    int[] nums = { 2, 4, 6, 8, 10 };
    System.out.println(obj.numOfArithmeticSlices(nums));
  }
}
