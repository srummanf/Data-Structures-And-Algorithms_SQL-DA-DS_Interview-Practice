//  https://leetcode.com/problems/minimum-number-game/
/*
 * You are given a 0-indexed integer array nums of even length and there is also an empty array arr. Alice and Bob decided to play a game where in every round Alice and Bob will do one move. The rules of the game are as follows:

Every round, first Alice will remove the minimum element from nums, and then Bob does the same.
Now, first Bob will append the removed element in the array arr, and then Alice does the same.
The game continues until nums becomes empty.
Return the resulting array arr.
 */

class Solution {

  public int[] numberGame(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    int ans[] = new int[n];
    int pos = 0;
    for (int i = 0; i < n; i++) {
      if (i % 2 == 0) {
        pos = i + 1;
      } else {
        pos = i - 1;
      }
      ans[i] = nums[pos];
    }
    return ans;
  }
}
