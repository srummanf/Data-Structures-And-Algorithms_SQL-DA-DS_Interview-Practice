class Solution {
    void buildSegmentTree(int i, int l, int r, int[] st, int[] arr) {
        if (l == r) {
            st[i] = arr[l];
            return;
        }
        int mid = l + (r - l) / 2;
        buildSegmentTree(2 * i + 1, l, mid, st, arr);
        buildSegmentTree(2 * i + 2, mid + 1, r, st, arr);
        st[i] = st[2 * i + 1] ^ st[2 * i + 2];
    }

    int querySegmentTree(int start, int end, int i, int l, int r, int[] st){
        if (l > end || r < start) return 0; // Should return 0 for out-of-range

        if (l >= start && r <= end) return st[i];

        int mid = l + (r - l) / 2;

        return querySegmentTree(start, end, 2 * i + 1, l, mid, st) ^ querySegmentTree(start, end, 2 * i + 2, mid + 1, r, st);
    }

    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int n_q = queries.length;
        int st[] = new int[4 * n];
        int[] ans = new int[n_q];
        buildSegmentTree(0, 0, n - 1, st, arr);
        for (int i = 0; i < n_q; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            ans[i] = querySegmentTree(left, right, 0, 0, n - 1, st);
        }

        return ans;
    }
}


// class Solution {
//     void buildSegmentTree(int i, int l, int r, int[] st, int[] arr) {
//         if (l == r) {
//             st[i] = arr[l];
//             return;
//         }
//         int mid = l + (r - l) / 2;
//         buildSegmentTree(2 * i + 1, l, mid, st, arr);
//         buildSegmentTree(2 * i + 2, mid + 1, r, st, arr);
//         st[i] = st[2 * i + 1] ^ st[2 * i + 2];

//     }

//     int querySegmentTree(int start, int end, int i, int l, int r, int[] st){
//         if(l>end || r<start) return 1;

//         if(l>= start && r<= end) return st[i];

//         int mid = l + (r-l)/2;

//         return querySegmentTree(start, end, 2*i+1, l, mid, st) ^ querySegmentTree(start, end, 2*i+2, mid+1, r, st);
//     }

//     public int[] xorQueries(int[] arr, int[][] queries) {
//         int n = arr.length;
//         int n_q = queries.length;
//         int st[] = new int[4 * n];
//         int[] ans = new int[n_q];
//         buildSegmentTree(0, 0, n - 1, st, arr);
//         for (int i = 0; i < n_q; i++) {
//             ans[i] = querySegmentTree(0, n - 1, 0, queries[i][0], queries[i][1], st);
//         }

//         return ans;

//     }
// }