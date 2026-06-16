import java.util.ArrayList;
import java.util.List;

public class LIS_Patience_Sorting {
    public int lengthOfLIS(int[] nums) {
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
      
        return piles.size();
    }

    private int binarySearch(List<Integer> sorted, int target) {
        int left = 0, right = sorted.size();
        int result = sorted.size();
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (sorted.get(mid) < target) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LIS_Patience_Sorting solution = new LIS_Patience_Sorting();
        int[] nums = {5, 8, 3, 7, 9, 1};
        int length = solution.lengthOfLIS(nums);
        System.out.println("Length of Longest Increasing Subsequence: " + length);
    }
}
