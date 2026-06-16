// Patience Sorting

import java.util.*;

public class Main {

    public static int patienceSorting(int[] nums) {
        if (nums.length == 0) {
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

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int lisLength = patienceSorting(nums);
        System.out.println("Length of Longest Increasing Subsequence: " + lisLength);
    }
}




// --------------------------------

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> sorted = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int index = binarySearch(sorted, nums[i]);

            if (index == sorted.size())
                sorted.add(nums[i]); // greatest: so insert it
            else
                sorted.set(index, nums[i]); // replace
        }

        return sorted.size();
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
}