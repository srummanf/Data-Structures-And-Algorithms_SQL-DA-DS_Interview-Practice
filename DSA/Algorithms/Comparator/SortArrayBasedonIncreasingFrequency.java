/** Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.

Return the sorted array.

 

Example 1:

Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]
Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
Example 2:

Input: nums = [2,3,1,3,2]
Output: [1,3,3,2,2]
Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
Example 3:

Input: nums = [-1,1,-6,4,5,-6,1,4,1]
Output: [5,-1,4,4,-6,-6,1,1,1]
 

Constraints:

1 <= nums.length <= 100
-100 <= nums[i] <= 100 */

import java.util.*;

class Solution {
    public int[] frequencySort(int[] nums) {
        // Step 1: Build a frequency map
        TreeMap<Integer, Integer> frequencyMap = new TreeMap<>(Collections.reverseOrder());
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Use a priority queue to sort based on frequency and value
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>((a, b) -> {
            if (a.get(0).equals(b.get(0))) {
                return b.get(1) - a.get(1); // Sort by value in decreasing order if frequencies are the same
            }
            return a.get(0) - b.get(0); // Sort by frequency in increasing order
        });

        // Step 3: Add frequency and value pairs to the priority queue
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(entry.getValue());
            temp.add(entry.getKey());
            pq.add(temp);
        }

        // Step 4: Build the result array based on the sorted pairs
        int idx = 0;
        while (!pq.isEmpty()) {
            ArrayList<Integer> entry = pq.poll();
            int frequency = entry.get(0);
            int value = entry.get(1);
            for (int i = 0; i < frequency; i++) {
                nums[idx++] = value;
            }
        }

        return nums;
    }
}
