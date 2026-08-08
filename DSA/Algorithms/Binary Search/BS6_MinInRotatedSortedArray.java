/** Problem Statement: Find Minimum in a Rotated Sorted Array
 * 
 * Input: nums = [3,4,5,1,2]
 * Output: 1
 */

class BS6_MinInRotatedSortedArray{
    public int findMin(int[] nums) {

        int l = 0;
        int r = nums.length - 1;

        while (l < r) {

            int mid = l + (r - l) / 2;

            if (nums[mid] > nums[r]) {
                // Minimum is on the right
                l = mid + 1;
            } 
            else {
                // Minimum is at mid or on the left
                r = mid;
            }
        }

        return nums[l];
    }

    public static void main(String[] args) {
        BS6_MinInRotatedSortedArray obj = new BS6_MinInRotatedSortedArray();
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println("Minimum element in the rotated sorted array: " + obj.findMin(nums));
    }
}