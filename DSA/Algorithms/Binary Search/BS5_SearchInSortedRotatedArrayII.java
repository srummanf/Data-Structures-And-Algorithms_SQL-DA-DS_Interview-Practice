/** Problem Statement: Search in a Sorted Rotated Array with Duplicates
 * 
Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
 */

class BS5_SearchInSortedRotatedArrayII {
  public static void main(String args[]) {
    
    int arr[] = {4,5,6,7,0,1,2};
    int target = 0;
    System.out.println(search(arr, target));
  }

  public static boolean search(int[] nums, int target) {
    int l = 0;
        int r = nums.length - 1;

        while (l <= r) {

            int mid = l + (r - l) / 2;

            if (nums[mid] == target)
                return true;

            // Duplicate values -> cannot determine sorted side
            if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
                l++;
                r--;
                continue;
            }    

            // Left part sorted
            if (nums[l] <= nums[mid]) {

                if (nums[l] <= target && target < nums[mid])
                    r = mid - 1;
                else
                    l = mid + 1;
            }

            // Right part sorted
            else {

                if (nums[mid] < target && target <= nums[r])
                    l = mid + 1;
                else
                    r = mid - 1;
            }
        }

        return false;
  }
}