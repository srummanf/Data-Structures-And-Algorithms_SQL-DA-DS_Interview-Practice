// Equivalent to finding the longest subarray with at most k zeroes

public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int maxLen = 0;
        int l = 0;
        int count = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0)
                count++;
            while (count > k) {
                if (nums[l] == 0)
                    count--;
                l++;
            }
            maxLen = Math.max(maxLen, (r - l + 1));
        }
        return maxLen;

    }

    public static void main(String[] args) {
        MaxConsecutiveOnesIII solution = new MaxConsecutiveOnesIII();
        int[] nums = {1, 1, 0, 0, 1, 1, 1, 0, 1};
        int k = 2;
        System.out.println(solution.longestOnes(nums, k)); // Output: 7
    }
}
