

class LongestSubarrayWithSumLessThanEqualToK {
    public int longestSubarray(int[] nums, int k) {
        int left = 0, right = 0, maxLength = 0, currentSum = 0;

        while (right < nums.length) {
            currentSum += nums[right];

            while (currentSum > k && left <= right) {
                currentSum -= nums[left];
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubarrayWithSumLessThanEqualToK solution = new LongestSubarrayWithSumLessThanEqualToK();
        int[] nums = { 1, 2, 3, 4, 5 };
        int k = 8;
        System.out.println(solution.longestSubarray(nums, k)); // Output: 4
    }
}


