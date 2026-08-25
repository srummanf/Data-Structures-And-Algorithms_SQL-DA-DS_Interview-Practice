/**
 * Problem: Find Peak Element
 * Link: https://leetcode.com/problems/find-peak-element/
 * Level: Medium
 * 
 * Approach:
 * 1. A peak element is an element that is strictly greater than its neighbors.
 * 2. We can use binary search to find a peak element in O(log n) time complexity.
 * 3. We check the middle element and compare it with its neighbors to determine the direction to search for a peak.
 * 4, Through this process, we can find any 1 peak element in the array. If you want to find all peak elements, you can use a linear scan of the array in O(n) time complexity.
 */


class BS9_FindPeakElement {

    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        if (nums[0] > nums[1]) {
            return 0;
        }

        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }

        int left = 1;
        int right = nums.length - 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid-1] < nums[mid] && nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
