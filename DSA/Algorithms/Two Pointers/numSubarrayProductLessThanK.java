/**
 * Given an array of integers nums and an integer k, return the number of
 * contiguous subarrays where the product of all the elements in the subarray is
 * strictly less than k.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [10,5,2,6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are:
 * [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly
 * less than k.
 * Example 2:
 * 
 * Input: nums = [1,2,3], k = 0
 * Output: 0
 * Intuition:
 * 
 * Imagine a sliding window traversing the array. We keep track of the product
 * of elements within the window. If the product becomes greater than or equal
 * to k, we need to shrink the window from the left side until the product
 * becomes less than k. This process ensures that all subarrays considered have
 * a product strictly less than k.
 * 
 * Approach:
 * 
 * Initialization: Set left and right pointers to 0, product to 1 (initial empty
 * subarray), and count to 0 (to store final subarray count).
 * Sliding Window:
 * While right hasn't reached the end (right < n):
 * Expand the window: Multiply product by the current element nums[right].
 * Shrink the window (if necessary):
 * While product is greater than or equal to k:
 * Divide product by the leftmost element nums[left] and increment left. This
 * shrinks the window and reduces the product.
 * Count subarrays:
 * Add 1 + (right - left) to count. This accounts for:
 * 1: The single-element subarray ending at right.
 * (right - left): The number of contiguous subarrays within the current window
 * (excluding elements already removed in the inner loop).
 * Increment right to move the window one step forward.
 * Return Result:
 * Return the final count representing the total number of subarrays with
 * product less than k.
 * Time Complexity:
 * 
 * Best Case: O(n) if k is very small (product never exceeds k) or very large
 * (no window shrinking needed).
 * Average Case: O(n) due to the efficient sliding window approach. In each
 * iteration, either right is incremented (constant time) or left is incremented
 * (constant time) in the inner loop. This leads to a maximum of n iterations
 * overall.
 * Worst Case: O(2*n) if elements in nums are very close to 1 and k is just
 * slightly larger than the product of all elements. In this scenario, the
 * window might shrink very slowly, leading to more iterations in the worst
 * case.
 * Space Complexity:
 * 
 * O(1) as we use constant extra space (left, right, product, and count)
 * independent of the input size.
 */

 /**
  * numSubarrayProductLessThanK
  */
 public class numSubarrayProductLessThanK {
 
     public int numSubarrayProductLessThanK(int[] nums, int k) {
         int l = 0;
         int result = 0;
         int product = 1;
         if (k <= 1)
             return 0;
         for (int r = 0; r < nums.length; r++) {
             product = product * nums[r];
             while (product >= k) {
                 product = product / nums[l];
                 l++;
             }
             result += r - l + 1;
         }
         return result;
     }

        public static void main(String[] args) {
            numSubarrayProductLessThanK ob = new numSubarrayProductLessThanK();
            int nums[] = { 10, 5, 2, 6 };
            int k = 100;
            System.out.println(ob.numSubarrayProductLessThanK(nums, k));
        }
 }