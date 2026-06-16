import java.util.*;

class Solution {
    public int patienceSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        List<Integer> piles = new ArrayList<>();

        for (int num : nums) {
            int idx = Collections.binarySearch(piles, num);
            if (idx < 0) idx = -idx - 1;
            if (idx == piles.size()) {
                piles.add(num);
            } else {
                piles.set(idx, num);
            }
        }

        return piles.size();
    }

    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;

        // Compute LIS from the left
        int[] lisLeft = new int[n];
        for (int i = 0; i < n; i++) {
            lisLeft[i] = patienceSort(Arrays.copyOfRange(nums, 0, i + 1));
        }

        // Compute LIS from the right by reversing the array
        int[] reversedNums = new int[n];
        for (int i = 0; i < n; i++) {
            reversedNums[i] = nums[n - 1 - i];
        }
        int[] lisRight = new int[n];
        for (int i = 0; i < n; i++) {
            lisRight[i] = patienceSort(Arrays.copyOfRange(reversedNums, 0, i + 1));
        }

        // Compute the maximum length of the bitonic subsequence
        int maxLength = 0;
        for (int i = 1; i < n - 1; i++) {
            if (lisLeft[i] > 1 && lisRight[n - 1 - i] > 1) {
                maxLength = Math.max(maxLength, lisLeft[i] + lisRight[n - 1 - i] - 1);
            }
        }

        // Return the maximum length of the bitonic subsequence
        return maxLength;
    }
}
