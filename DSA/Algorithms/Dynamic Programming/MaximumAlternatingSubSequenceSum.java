/** The alternating sum of a 0-indexed array is defined as the sum of the elements at even indices minus the sum of the elements at odd indices.

For example, the alternating sum of [4,2,5,3] is (4 + 5) - (2 + 3) = 4.
Given an array nums, return the maximum alternating sum of any subsequence of nums (after reindexing the elements of the subsequence).

A subsequence of an array is a new array generated from the original array by deleting some elements (possibly none) without changing the remaining elements' relative order. For example, [2,7,4] is a subsequence of [4,2,3,7,2,1,4] (the underlined elements), while [2,4,2] is not.

 

Example 1:

Input: nums = [4,2,5,3]
Output: 7
Explanation: It is optimal to choose the subsequence [4,2,5] with alternating sum (4 + 5) - 2 = 7.
Example 2:

Input: nums = [5,6,7,8]
Output: 8
Explanation: It is optimal to choose the subsequence [8] with alternating sum 8.
Example 3:

Input: nums = [6,2,1,2,4,5]
Output: 10
Explanation: It is optimal to choose the subsequence [6,1,5] with alternating sum (6 + 5) - 1 = 10.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 105 */

// ---------------------------------- RECURSION ---------------------------------

/** public long f(int idx, int[] nums, boolean flag){

        if(idx>=nums.length) return 0;

        long nottake = f(idx+1, nums, flag);
        
        int val = nums[idx];
        if(!flag) val=-val;
        long take = val + f(idx+1, nums, !flag);

        return Math.max(take, nottake);
    }
    public long maxAlternatingSum(int[] nums) {

        return f(0, nums, true);
        
    }
} */

// DP array -- t[][1 means even , 0 means odd]

import java.util.Arrays;

class Solution {
    int n;
    long[][] t;

    public long maxAlternatingSum(int[] nums) {
        n = nums.length;
        t = new long[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(t[i], -1);
        }
        return solve(0, nums, true);
    }

    private long solve(int idx, int[] nums, boolean iseven) {
        if (idx >= n) {
            return 0;
        }
        if (t[idx][iseven ? 1 : 0] != -1) {
            return t[idx][iseven ? 1 : 0];
        }

        long skip = solve(idx + 1, nums, iseven);

        long val = nums[idx];
        if (!iseven) {
            val = -val;
        }

        long take = solve(idx + 1, nums, !iseven) + val;

        return t[idx][iseven ? 1 : 0] = Math.max(skip, take);
    }
}
