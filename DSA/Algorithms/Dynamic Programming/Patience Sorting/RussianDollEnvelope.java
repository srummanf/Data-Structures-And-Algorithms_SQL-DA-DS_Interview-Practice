/** You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.

One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.

Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).

Note: You cannot rotate an envelope.

 

Example 1:

Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
Output: 3
Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
Example 2:

Input: envelopes = [[1,1],[1,1],[1,1]]
Output: 1
 

Constraints:

1 <= envelopes.length <= 105
envelopes[i].length == 2
1 <= wi, hi <= 105 */

import java.util.*;

public class RussianDollEnvelope {

    public static int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        
        // Sort the envelopes by width in ascending order.
        // If two envelopes have the same width, sort them by height in descending order.
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            } else {
                return a[0] - b[0];
            }
        });
        
        // Extract the heights and find the LIS
        int[] heights = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            heights[i] = envelopes[i][1];
        }
        
        return patienceSorting(heights);
    }

    private static int patienceSorting(int[] nums) {
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

    public static void main(String[] args) {
        int[][] envelopes1 = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        System.out.println("Maximum number of envelopes you can Russian doll: " + maxEnvelopes(envelopes1)); // Expected: 3
        
        int[][] envelopes2 = {{1, 1}};
        System.out.println("Maximum number of envelopes you can Russian doll: " + maxEnvelopes(envelopes2)); // Expected: 1
    }
}