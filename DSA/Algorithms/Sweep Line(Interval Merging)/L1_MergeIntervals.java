
/** Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 *
 *
 *  *Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6]. */
import java.util.ArrayList;
import java.util.Arrays;

class L1_MergeIntervals {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        ArrayList<ArrayList<Integer>> temp = new ArrayList<>();

        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current interval does not overlap with the previous, simply append it.
            if (temp.isEmpty()
                    || interval[0] > temp.get(temp.size() - 1).get(1)) {

                temp.add(new ArrayList<>(Arrays.asList(interval[0], interval[1])));

            } // otherwise, there is overlap, so we merge the current and previous intervals.
            else {

                ArrayList<Integer> last = temp.get(temp.size() - 1);

                last.set(1, Math.max(last.get(1), interval[1]));
            }
        }

        int[][] ans = new int[temp.size()][2];

        for (int i = 0; i < temp.size(); i++) {
            ans[i][0] = temp.get(i).get(0);
            ans[i][1] = temp.get(i).get(1);
        }

        return ans;
    }

    public static void main(String[] args) {
        L1_MergeIntervals obj = new L1_MergeIntervals();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] ans = obj.merge(intervals);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i][0] + " " + ans[i][1]);
        }
    }
}
