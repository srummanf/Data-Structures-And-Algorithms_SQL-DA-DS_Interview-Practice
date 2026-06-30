/* Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order. 

Sample Input: nums = [2,7,11,15], target = 9
Sample Output: [0,1]

Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
*/

import java.util.*;
class L3_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        // Create a HashMap to store the elements of the array and their indices
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

    public static void main(String args[]) {
        L3_TwoSum t = new L3_TwoSum();
        int nums[] = { 2, 7, 11, 15 };
        int target = 9;
        int ans[] = t.twoSum(nums, target);
        System.out.println(ans[0] + " " + ans[1]);
    }
}

