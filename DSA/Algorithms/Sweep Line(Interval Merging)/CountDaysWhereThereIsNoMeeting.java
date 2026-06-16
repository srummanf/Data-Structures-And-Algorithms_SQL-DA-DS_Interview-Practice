/**You are given a positive integer days representing the total number of days an employee is available for work (starting from day 1). You are also given a 2D array meetings of size n where, meetings[i] = [start_i, end_i] represents the starting and ending days of meeting i (inclusive).

Return the count of days when the employee is available for work but no meetings are scheduled.

Note: The meetings may overlap.

 

Example 1:

Input: days = 10, meetings = [[5,7],[1,3],[9,10]]

Output: 2

Explanation:

There is no meeting scheduled on the 4th and 8th days.

Example 2:

Input: days = 5, meetings = [[2,4],[1,3]]

Output: 1

Explanation:

There is no meeting scheduled on the 5th day.

Example 3:

Input: days = 6, meetings = [[1,6]]

Output: 0

Explanation:

Meetings are scheduled for all working days. */

import java.math.*;
import java.util.*;

class Solution {
    public int countDays(int days, int[][] meetings) {
        int n = meetings.length;
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr.isEmpty() || meetings[i][0] > arr.get(arr.size() - 1).get(1)) {
                arr.add(Arrays.asList(meetings[i][0], meetings[i][1]));
            } else {
                arr.get(arr.size() - 1).set(1,
                        Math.max(arr.get(arr.size() - 1).get(1), meetings[i][1]));
            }
        }
        // System.out.println(arr);
        int count = 0;
        n = arr.size();
        for (int i = 1; i < n; i++) {
            count += arr.get(i).get(0) - arr.get(i - 1).get(1) - 1;
        }
        if (days > arr.get(n - 1).get(1))
            count += days - arr.get(n - 1).get(1) ;
        if(arr.get(0).get(0) >=2){
            count += arr.get(0).get(0) - 1;
        }
        return count;
    }
}