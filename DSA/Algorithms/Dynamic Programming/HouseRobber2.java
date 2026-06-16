/** You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police. */

/** Same as House Robber 1 -- Breaking the Array:

part1 is the subarray from index 0 to n-2 (Arrays.copyOfRange(nums, 0, nums.length - 1)).
part2 is the subarray from index 1 to n-1 (Arrays.copyOfRange(nums, 1, nums.length)). */
// Company Tags                : Airbnb, Microsoft

import java.util.Arrays;

public class Solution {
    public int f(int idx, int[] nums, int[] dp) {
        if (idx < 0)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];
        int take = nums[idx] + f(idx - 2, nums, dp);
        int nottake = f(idx - 1, nums, dp);

        return dp[idx] = Math.max(take, nottake);
    }

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] part1 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] part2 = Arrays.copyOfRange(nums, 1, nums.length);

        int n1 = part1.length;
        int[] dp1 = new int[n1];
        Arrays.fill(dp1, -1);

        int n2 = part2.length;
        int[] dp2 = new int[n2];
        Arrays.fill(dp2, -1);

        return Math.max(f(n1 - 1, part1, dp1), f(n2 - 1, part2, dp2));
    }
}
