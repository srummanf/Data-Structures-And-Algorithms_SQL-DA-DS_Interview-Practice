/** You are given an integer array nums and an integer k. You want to find a subsequence of nums of length k that has the largest sum.

Return any such subsequence as an integer array of length k.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements. */

// My solution -- PQ

import java.util.*;

public class Solution {
    public static int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < n; i++) {
            maxHeap.offer(new int[]{nums[i], i});
        }
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            indices.add(maxHeap.poll()[1]);
        }
        Collections.sort(indices);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = nums[indices.get(i)];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int[] result = maxSubsequence(nums, k);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}



// ===== ===== ===== =====  ===== ==== ==== ===== ===== ===== =====  ===== ==== ==== ===== ===== ===== =====  ===== ==== ==== ===== ===== ===== =====  ===== ==== ==== ===== ===== =====

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        // Initialize an array 'ans' to store the result subsequence of length k
        int[] ans = new int[k];
      
        // Create a list 'indices' to keep track of the original indices of the array elements
        List<Integer> indices = new ArrayList<>();
      
        // Loop to fill 'indices' with the array indices
        for (int i = 0; i < nums.length; ++i) {
            indices.add(i);
        }
      
        // Sort 'indices' based on the values in 'nums' from highest to lowest
        indices.sort((i1, i2) -> Integer.compare(nums[i2], nums[i1]));
      
        // Initialize a temporary array 'topIndices' to store the first k sorted indices
        int[] topIndices = new int[k];
        for (int i = 0; i < k; ++i) {
            topIndices[i] = indices.get(i);
        }
      
        // Sort 'topIndices' to maintain the original order of selected k elements
        Arrays.sort(topIndices);
      
        // Fill the 'ans' array with the elements corresponding to the sorted indices
        for (int i = 0; i < k; ++i) {
            ans[i] = nums[topIndices[i]];
        }
      
        // Return the result array containing the max subsequence of length k
        return ans;
    }
}