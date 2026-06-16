import java.util.*;

class LIS {

  public static int lengthOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    List<Integer> piles = new ArrayList<>();

    for (int num : nums) {
      int position = Collections.binarySearch(piles, num);
      if (position < 0) {
        position = -(position + 1);
      }
      if (position == piles.size()) {
        piles.add(num);
      } else {
        piles.set(position, num);
      }
    }
    System.out.println(piles);
    return piles.size();
  }

  public static void main(String[] args) {
    LIS solution = new LIS();
    int[] nums = { 5, 8, 3, 7, 9, 1 };
    int length = solution.lengthOfLIS(nums);

    System.out.println("Length of Longest Increasing Subsequence: " + length);
  }
}
