import java.util.Arrays;
import java.util.HashMap;

class Solution {

  public static void decreaseFrequency(
    HashMap<Integer, Integer> map,
    int element
  ) {
    if (map.containsKey(element)) {
      int currentFreq = map.get(element);
      if (currentFreq > 1) {
        map.put(element, currentFreq - 1);
      } else {
        map.remove(element);
      }
    }
  }

  public boolean isPossibleDivide(int[] nums, int k) {
    if (nums.length % k != 0) return false;

    HashMap<Integer, Integer> freqMap = new HashMap<>();
    for (int num : nums) {
      freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
    }

    Arrays.sort(nums);
    for (int num : nums) {
      if (freqMap.containsKey(num)) {
        int current = num;
        for (int i = 0; i < k; i++) {
          if (!freqMap.containsKey(current)) {
            return false;
          }
          decreaseFrequency(freqMap, current);
          current++;
        }
      }
    }
    return true;
  }
}
