
public class MaxSumCircularSubarray {
    public int MinKadanesAlgo(int[] nums) {
        int sum = nums[0];
        int minSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.min(sum + nums[i], nums[i]);
            minSum = Math.min(minSum, sum);
        }
        return minSum;
    }

    public int MaxKadanesAlgo(int[] nums) {
        int sum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public int maxSubarraySumCircular(int[] nums) {
        int t = 0;
        for (int i : nums) {
            t += i;
        }
        int maxSum = MaxKadanesAlgo(nums);
        int minSum = MinKadanesAlgo(nums);
        int curSum = t-minSum;
        if(maxSum>0) return Math.max(maxSum, curSum);
        return maxSum;
    }
}
