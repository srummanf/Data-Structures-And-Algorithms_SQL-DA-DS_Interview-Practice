/**
 * Problem: Find Single Element in a Sorted Array
 * 
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.
 * 
 * Example 1:
 * Input: nums = [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * 
 * Example 2:
 * Input: nums = [3,3,7,7,10,11,11]
 * Output: 10
 * 
 * Constraints:
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^5
 */

/**
 * Approach:
 * 1. We can use binary search to find the single element in the sorted array.
 * 2. We will check the middle element and its neighbors to determine if it is the single element.
 * 3. If the middle element is equal to its left neighbor, we will check if the index of the middle element is odd or even to determine which side to search next.
 * 4. If the middle element is equal to its right neighbor, we will check if the index of the middle element is odd or even to determine which side to search next.
 * 5. We will continue this process until we find the single element.
 */

// Concept of Even Odd Indexing: 

class BS8_FindSingleElementInDuplicateSortedArray {

    public boolean isOdd(int n) {
        return n % 2 == 1 ? true : false;
    }

    public boolean isEven(int n) {
        return n % 2 == 0 ? true : false;
    }

    public int singleNonDuplicate(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            return nums[nums.length - 1];
        }

        int l = 1;
        int r = nums.length - 2;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            // left elimination
            if ((isOdd(mid) && nums[mid] == nums[mid - 1]) || (isEven(mid) && nums[mid] == nums[mid + 1])) {
                l = mid + 1; 
            }else {
                r = mid - 1;
            }

        }

        return -1;

    }

    public static void main(String[] args) {
        BS8_FindSingleElementInDuplicateSortedArray obj = new BS8_FindSingleElementInDuplicateSortedArray();
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println("Single element in the duplicate sorted array: " + obj.singleNonDuplicate(nums));
    }
}
