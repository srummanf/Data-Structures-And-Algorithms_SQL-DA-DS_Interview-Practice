/** amazon
apple
blend
bloomberg
google
linkedin
meta
microsoft
mongodb
oracle
paypal
phonepe
tesco
tiktok
uber
walmart-labs */

import java.util.*;

class L2_InsertInterval__using__MergeInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] arr = new int[intervals.length + 1][2];

        for (int i = 0; i < intervals.length; i++) {
            arr[i] = intervals[i];
        }

        arr[intervals.length] = newInterval;

        return merge(arr);
    }

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
        L2_InsertInterval__using__MergeInterval obj = new L2_InsertInterval__using__MergeInterval();
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] ans = obj.insert(intervals, newInterval);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i][0] + " " + ans[i][1]);
        }
    }
}
