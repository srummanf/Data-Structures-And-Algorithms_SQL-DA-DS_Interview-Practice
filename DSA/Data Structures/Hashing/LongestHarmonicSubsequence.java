import java.util.HashMap;

public class LongestHarmonicSubsequence {

  public int findLHS(int[] nums) {
    HashMap<Integer, Integer> hm = new HashMap<>();
    int ans = 0;
    for (int i : nums) {
      hm.put(i, hm.getOrDefault(i, 0) + 1);
    }
    for (int key : hm.keySet()) {
      if (hm.containsKey(key + 1)) {
        ans = Math.max(ans, hm.get(key) + hm.get(key + 1));
      }
    }
    return ans;
  }
  public static void main(String[] args) {
    LongestHarmonicSubsequence obj = new LongestHarmonicSubsequence();
    int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
    System.out.println(obj.findLHS(nums));
  }
}
