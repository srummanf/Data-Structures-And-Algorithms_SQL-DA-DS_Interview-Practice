// Asked in OA

// You are given a schedule array of size n, where each entry is a binary string of length m. Each entry represents whether you have a course at a particular hour on a specific day. A 1 means you have a course at the i-th hour, and a 0 means no course at that hour. The hour spent to complete the course on the n-th day is calculated as 4 * (j - i + 1), where i is the start hour and j is the end hour. You are allowed to skip k classes. Your task is to find the minimum number of hours needed to complete the course.

// Example:

// Schedule: {"1001", "0011", "1010", "0001"}
// k = 3
// Here we can bunk 3 classes, resulting in the following modified schedule: {"0001", "0011", "1000", "0000"}. The minimum hours to complete the course would be 2 (since 0011 has a course at 2nd and 3rd hour, the time required is 3 - 2 + 1 = 2).

import java.util.*;

public class MinHoursToCompleteCourses {

  public static int minDaysToCompleteCourses(String[] schedule, int k) {
    int n = schedule.length;
    int m = schedule[0].length();

    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    for (String day : schedule) {
      int first = day.indexOf('1');
      int last = day.lastIndexOf('1');
      if (first != -1 && last != -1) {
        pq.add(last - first + 1);
      }
    }

    while (k > 0 && !pq.isEmpty()) {
      k--;
      pq.poll();
    }

    return pq.isEmpty() ? 0 : pq.peek();
  }

  public static void main(String[] args) {
    String[] schedule = { "1001", "0011", "1010", "0001" };
    int k = 3;

    int result = minDaysToCompleteCourses(schedule, k);
    System.out.println("Minimum hours to complete the courses: " + result);
  }
}
