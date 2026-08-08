class Solution {
    public int[] searchRange(int[] nums, int target) {

        int[] ans = {-1, -1};

        int leftmost = -1;
        int rightmost = -1;

        // Find leftmost
        int l = 0, r = nums.length - 1, mid;

        while (l <= r) {

            mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                leftmost = mid;
                r = mid - 1;
            } 
            else if (nums[mid] < target) {
                l = mid + 1;
            } 
            else {
                r = mid - 1;
            }
        }

        // Find rightmost
        l = 0;
        r = nums.length - 1;

        while (l <= r) {

            mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                rightmost = mid;
                l = mid + 1;
            } 
            else if (nums[mid] < target) {
                l = mid + 1;
            } 
            else {
                r = mid - 1;
            }
        }

        ans[0] = leftmost;
        ans[1] = rightmost;

        return ans;
    }
}