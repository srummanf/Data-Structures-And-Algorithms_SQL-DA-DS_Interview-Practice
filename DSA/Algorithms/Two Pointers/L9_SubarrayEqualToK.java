import java.util.HashMap;

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1); // There's one way to get a sum of 0: by having an empty subarray
        
        int currentSum = 0;
        int result = 0;
        
        for (int num : nums) {
            currentSum += num; // Update the running sum
            
            // Check if there is a subarray with sum equal to `goal` ending at this index
            if (hm.containsKey(currentSum - goal)) {
                result += hm.get(currentSum - goal);
            }
            
            // Update the prefix sum count map
            hm.put(currentSum, hm.getOrDefault(currentSum, 0) + 1);
        }
        
        return result;
    }
}
