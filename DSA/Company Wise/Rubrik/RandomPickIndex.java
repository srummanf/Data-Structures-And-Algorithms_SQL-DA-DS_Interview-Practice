/** Given an integer array nums with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.

Implement the Solution class:

Solution(int[] nums) Initializes the object with the array nums.
int pick(int target) Picks a random index i from nums where nums[i] == target. If there are multiple valid i's, then each index should have an equal probability of returning.
 

Example 1:

Input
["Solution", "pick", "pick", "pick"]
[[[1, 2, 3, 3, 3]], [3], [1], [3]]
Output
[null, 4, 0, 2]

Explanation
Solution solution = new Solution([1, 2, 3, 3, 3]);
solution.pick(3); // It should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
solution.pick(1); // It should return 0. Since in the array only nums[0] is equal to 1.
solution.pick(3); // It should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
 

Constraints:

1 <= nums.length <= 2 * 104
-231 <= nums[i] <= 231 - 1
target is an integer from nums.
At most 104 calls will be made to pick. */

import java.util.Random;

class Solution {
    private int[] nums;
    private Random rand;

    public Solution(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }

    public int pick(int target) {
        int count = 0;
        int result = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                // Reservoir sampling: Replace result with probability 1/count
                if (rand.nextInt(count) == 0) {
                    result = i;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1, 2, 3, 3, 3});
        System.out.println(solution.pick(3)); // Should return 2, 3, or 4 randomly
        System.out.println(solution.pick(1)); // Should return 0
        System.out.println(solution.pick(3)); // Should return 2, 3, or 4 randomly
    }
}


// import java.util.ArrayList;
// import java.util.List;
// import java.util.Random;

// class Solution {
//     private int[] nums;
//     private Random rand;

//     public Solution(int[] nums) {
//         this.nums = nums;
//         this.rand = new Random();
//     }

//     public int pick(int target) {
//         List<Integer> indices = new ArrayList<>();
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] == target) {
//                 indices.add(i);
//             }
//         }
//         return indices.get(rand.nextInt(indices.size()));
//     }
// }

// /**
//  * Your Solution object will be instantiated and called as such:
//  * Solution obj = new Solution(nums);
//  * int param_1 = obj.pick(target);
//  */
