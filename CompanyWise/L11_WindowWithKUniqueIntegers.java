import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return countSubarraysWithAtMostKDistinct(nums, k) - countSubarraysWithAtMostKDistinct(nums, k - 1);
    }

    private int countSubarraysWithAtMostKDistinct(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int count = 0;

        for (int r = 0; r < nums.length; r++) {
            // Add current element to the map
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            // While there are more than k distinct elements, shrink the window
            while (map.size() > k) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }
                l++;
            }

            // Count the number of subarrays ending at r
            count += r - l + 1;
        }

        return count;
    }
}
