class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) ->
            a[0] != b[0] ? Integer.compare(a[0], b[0])
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
}