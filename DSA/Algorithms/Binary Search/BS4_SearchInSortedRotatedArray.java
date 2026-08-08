class BS4_SearchInSortedRotatedArray {
  public static void main(String args[]) {
    
    int arr[] = {4,5,6,7,0,1,2};
    int target = 0;
    System.out.println(search(arr, target));
  }

  public static int search(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (nums[mid] == target) {
        return mid;
      }

      // Check if the left half is sorted
      if (nums[low] <= nums[mid]) {
        // Target is in the left half
        if (target >= nums[low] && target < nums[mid]) {
          high = mid - 1;
        } else { // Target is in the right half
          low = mid + 1;
        }
      } else { // Right half is sorted
        // Target is in the right half
        if (target > nums[mid] && target <= nums[high]) {
          low = mid + 1;
        } else { // Target is in the left half
          high = mid - 1;
        }
      }
    }

    return -1; // Target not found
  }
}