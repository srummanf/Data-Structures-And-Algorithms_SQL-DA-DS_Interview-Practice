/**
 * Problem statement
You are given a list of ‘N’ non-overlapping intervals (each interval can be represented using two integers ‘start’ and ‘end’), sorted in ascending order (based on ‘start’ values). Your task is to insert a given interval in the list, such that all the intervals are present in sorted order.

In case the given interval overlaps with other intervals, merge all necessary intervals to produce a list containing only non-overlapping intervals.

Example:

Let’s say the list of intervals is: [[1,3], [5,7], [8,12]] and we need to insert the interval [4,6] into the list. [4,6] must be inserted in the second position. After insertion, since [4,6] overlaps with [5,7], we merge them into one interval [4,7]. So, our resulting list is:  [[1,3], [4,7], [8,12]]
 */

import java.util.*;

public class MergeOverlappingSubproblem {

  public static ArrayList<ArrayList<Integer>> insertInterval(
    ArrayList<ArrayList<Integer>> arr,
    ArrayList<Integer> newInterval
  ) {
    // Add the new interval to the list
    arr.add(newInterval);

    // Sort the list based on the starting times of the intervals
    Collections.sort(arr, (a, b) -> Integer.compare(a.get(0), b.get(0)));

    // Initialize the result list
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    // Iterate through the sorted list and merge intervals as necessary
    for (ArrayList<Integer> interval : arr) {
      // If the result list is empty or the current interval does not overlap with the last one in the result list
      if (ans.isEmpty() || interval.get(0) > ans.get(ans.size() - 1).get(1)) {
        // Add the current interval to the result list
        ans.add(new ArrayList<>(interval));
      } else {
        // Merge the current interval with the last interval in the result list
        ans
          .get(ans.size() - 1)
          .set(1, Math.max(ans.get(ans.size() - 1).get(1), interval.get(1)));
      }
    }

    // Return the merged list of intervals
    return ans;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt(); // Number of test cases

    while (T-- > 0) {
      int N = sc.nextInt(); // Number of intervals
      ArrayList<ArrayList<Integer>> intervals = new ArrayList<>();

      for (int i = 0; i < N; i++) {
        ArrayList<Integer> interval = new ArrayList<>();
        interval.add(sc.nextInt());
        interval.add(sc.nextInt());
        intervals.add(interval);
      }

      ArrayList<Integer> newInterval = new ArrayList<>();
      newInterval.add(sc.nextInt());
      newInterval.add(sc.nextInt());

      ArrayList<ArrayList<Integer>> result = insertInterval(
        intervals,
        newInterval
      );

      for (ArrayList<Integer> interval : result) {
        System.out.println(interval.get(0) + " " + interval.get(1));
      }
    }

    sc.close();
  }
}
