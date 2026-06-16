/* Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order. */

import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hm.put(nums[i], i);
        }

        for (int i = 0; i < n; i++) {
            int rem = target - nums[i];
            if (hm.containsKey(rem) && hm.get(rem) != i) {
                return new int[] { i, hm.get(rem) };
            }
        }
        return new int[0];
    }
}

