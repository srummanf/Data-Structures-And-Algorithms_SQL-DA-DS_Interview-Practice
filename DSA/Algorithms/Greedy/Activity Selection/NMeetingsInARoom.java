class Solution {
    public int maxNumberOfMeets(int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[1], b[1]));
        int cnt = 0;
        int n = meetings.length;
        int prev_end_time = meetings[0][1];
        for (int i = 1; i < n; i++) {
            int curr_start_time = meetings[i][0];
             if (curr_start_time > prev_end_time) {
                cnt++; 
                prev_end_time = meetings[i][1];
            } else {
                continue;
            }
        }
        return cnt;

    }
}