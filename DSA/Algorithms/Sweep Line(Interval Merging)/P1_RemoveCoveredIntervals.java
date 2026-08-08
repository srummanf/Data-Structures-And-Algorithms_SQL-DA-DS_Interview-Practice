
/** Given an array intervals where intervals[i] = [li, ri] represent the interval [li, ri), remove all intervals that are covered by another interval in the list.
 *
 *  *The interval [a, b) is covered by the interval [c, d) if and only if c <= a and b <= d.
 *
 *  *Return the number of remaining intervals.
 *
 *
 *  *Input: intervals = [[1,4],[3,6],[2,8]]
 * Output: 2
 * Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.
 *
 */
// Amazon
import java.util.Arrays;

class P1_RemoveCoveredIntervals {

    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b)
                -> a[0] != b[0] ? Integer.compare(a[0], b[0])
                        : Integer.compare(b[1], a[1]));
        int count = 0;

        int maxEnd = 0;   // constraints guarantee ends >= 1

        for (int[] in : intervals) {
            if (in[1] > maxEnd) {   // extends beyond everything seen -> not covered
                count++;
                maxEnd = in[1];
            }
            // else: in[1] <= maxEnd and in[0] >= some earlier start -> covered, skip
        }
        return count;

    }

    public static void main(String[] args) {
        P1_RemoveCoveredIntervals obj = new P1_RemoveCoveredIntervals();
        int[][] intervals = {{1, 4}, {3, 6}, {2, 8}};
        System.out.println(obj.removeCoveredIntervals(intervals));
    }
}
