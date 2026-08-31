/** The distance of a pair of integers a and b is defined as the absolute difference between a and b.

Given an integer array nums and an integer k, return the kth smallest distance among all the pairs nums[i] and nums[j] where 0 <= i < j < nums.length.

 

Example 1:

Input: nums = [1,3,1], k = 1
Output: 0
Explanation: Here are all the pairs:
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2
Then the 1st smallest distance pair is (1,1), and its distance is 0.
Example 2:

Input: nums = [1,1,1], k = 2
Output: 0
Example 3:

Input: nums = [1,6,1], k = 3
Output: 5 */

import java.util.Arrays;

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        // Sort the array to make it easier to find pairs with the smallest differences
        Arrays.sort(nums);
        int n = nums.length;
        
        // Set the initial binary search range: 
        // left is the smallest possible distance (0) and 
        // right is the largest possible distance (max(nums) - min(nums))
        int left = 0, right = nums[n - 1] - nums[0];
        
        // Perform binary search to find the k-th smallest distance
        while (left < right) {
            // Calculate the midpoint distance in the current range
            int mid = (left + right) / 2;
            int count = 0; // Count of pairs with distance <= mid
            int j = 0; // Pointer to find valid pairs
            
            // Iterate through each element to count valid pairs
            for (int i = 0; i < n; i++) {
                // Move the second pointer j as far as possible while the difference is <= mid
                while (j < n && nums[j] - nums[i] <= mid) {
                    j++;
                }
                // Number of pairs with the first element nums[i] and distance <= mid
                count += j - i - 1;
            }
            
            // If we found at least k pairs with distance <= mid, we search for smaller distances
            if (count >= k) {
                right = mid;
            } else {
                // Otherwise, we search for larger distances
                left = mid + 1;
            }
        }
        
        // After binary search ends, left will be the k-th smallest distance
        return left;
    }
}