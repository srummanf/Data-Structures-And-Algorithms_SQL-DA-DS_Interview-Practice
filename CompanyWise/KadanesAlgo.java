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




















// Return the sum along with the array and its length
public class Main {

    public static int[] MinKadanesAlgo(int[] nums) {
        int sum = nums[0];
        int minSum = nums[0];
        int start = 0, end = 0, tempStart = 0;

        for (int i = 1; i < nums.length; i++) {
            if (sum + nums[i] > nums[i]) {
                sum = nums[i];
                tempStart = i;
            } else {
                sum += nums[i];
            }

            if (sum < minSum) {
                minSum = sum;
                start = tempStart;
                end = i;
            }
        }
        return new int[]{minSum, end - start + 1};
    }

    public static int[] MaxKadanesAlgo(int[] nums) {
        int sum = nums[0];
        int maxSum = nums[0];
        int start = 0, end = 0, tempStart = 0;

        for (int i = 1; i < nums.length; i++) {
            if (sum + nums[i] < nums[i]) {
                sum = nums[i];
                tempStart = i;
            } else {
                sum += nums[i];
            }

            if (sum > maxSum) {
                maxSum = sum;
                start = tempStart;
                end = i;
            }
        }
        return new int[]{maxSum, end - start + 1};
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int[] minResult = MinKadanesAlgo(nums);
        System.out.println("Minimum Sum: " + minResult[0] + ", Length of Subarray: " + minResult[1]);

        int[] maxResult = MaxKadanesAlgo(nums);
        System.out.println("Maximum Sum: " + maxResult[0] + ", Length of Subarray: " + maxResult[1]);
    }
}
