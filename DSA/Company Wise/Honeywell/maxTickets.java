/** Consider an array of n ticket prices, tickets. A number, m, is defined as the size of some subsequence of tickets, s, where each element covers an unbroken range of integers. That is, if the elements in s are sorted, the absolute difference between any elements/and / + 1 is either 0 or 1. Determine the maximum length of a subsequence chosen from the tickets array.

Example

tickets = [8, 5, 4, 8, 4]

Valid subsequences, sorted, are (4, 4, 5} and {8, 8). These subsequences have m values of 3 and 2, respectively. Return 3.

Function Description

Complete the function max Tickets in the editor below.

max Tickets has the following parameter(s): int tickets[n]: the ticket prices

Returns

int: the maximum possible value of m Constraints

1sn≤105

1 ≤ tickets[i] ≤ 109 */

import java.util.*;

public class Solution {
    public static int maxTickets(List<Integer> tickets) {
        // Sort the tickets array
        Collections.sort(tickets);

        int maxLength = 1;  // To store the maximum length of subsequence
        int currentLength = 1;  // To store the current subsequence length

        // Traverse the sorted array
        for (int i = 1; i < tickets.size(); i++) {
            // Check if the current element continues the subsequence
            if (Math.abs(tickets.get(i) - tickets.get(i - 1)) <= 1) {
                currentLength++;  // Extend the current subsequence
            } else {
                // Reset the current subsequence length
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1;
            }
        }

        // Final check for the last subsequence
        maxLength = Math.max(maxLength, currentLength);

        return maxLength;
    }

    public static void main(String[] args) {
        // Example usage:
        List<Integer> tickets = Arrays.asList(8, 5, 4, 8, 4);
        System.out.println(maxTickets(tickets));  // Output should be 3
    }
}
