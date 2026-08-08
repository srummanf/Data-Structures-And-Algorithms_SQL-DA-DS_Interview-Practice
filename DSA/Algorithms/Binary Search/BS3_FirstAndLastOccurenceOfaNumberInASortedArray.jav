class Solution {
    public int firstOccurrence(int[] arr, int n, int k) {
        int low = 0, high = n - 1;
        int first = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] == k) {
                first = mid;
                // look for smaller index on the left
                high = mid - 1;
            } else if (arr[mid] < k) {
                low = mid + 1; // look on the right
            } else {
                high = mid - 1; // look on the left
            }
        }
        return first;
    }

    public int lastOccurrence(int[] arr, int n, int k) {
        int low = 0, high = n - 1;
        int last = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] == k) {
                last = mid;
                // look for larger index on the right
                low = mid + 1;
            } else if (arr[mid] < k) {
                low = mid + 1; // look on the right
            } else {
                high = mid - 1; // look on the left
            }
        }
        return last;
    }
    public int[] searchRange(int[] nums, int target) {

        int n = nums.length;
        int low = 0;
        int high = n - 1;
        // int first = -1;
        // int last = -1;

        // while (low <= high) {
        //     int mid = (low + high) / 2;
        //     if (nums[mid] == target) {
        //         first = mid;
        //         high = mid - 1;
        //     } else if (nums[mid] < target)
        //         low = mid + 1;
        //     else
        //         high = mid - 1;
        // }

        // while (low <= high) {
        //     int mid = (low + high) / 2;
        //     if (nums[mid] == target) {
        //         last = mid;
        //         low = mid + 1;
        //     } else if (nums[mid] < target)
        //         low = mid + 1;
        //     else
        //         high = mid - 1;
        // }

        int first = firstOccurrence(nums, n, target);
        if (first == -1) return new int[] { -1, -1};
        int last = lastOccurrence(nums, n, target);
        return new int[] {first, last};

    }
}