// You are given an array arr of positive integers. You are also given the array queries where queries[i] = [lefti, righti].

// For each query i compute the XOR of elements from lefti to righti (that is, arr[lefti] XOR arr[lefti + 1] XOR ... XOR arr[righti] ).

// Return an array answer where answer[i] is the answer to the ith query.

 

// Example 1:

// Input: arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
// Output: [2,7,14,8] 
// Explanation: 
// The binary representation of the elements in the array are:
// 1 = 0001 
// 3 = 0011 
// 4 = 0100 
// 8 = 1000 
// The XOR values for queries are:
// [0,1] = 1 xor 3 = 2 
// [1,2] = 3 xor 4 = 7 
// [0,3] = 1 xor 3 xor 4 xor 8 = 14 
// [3,3] = 8
// Example 2:

// Input: arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
// Output: [8,0,4,4]
 

// Constraints:

// 1 <= arr.length, queries.length <= 3 * 104
// 1 <= arr[i] <= 109
// queries[i].length == 2
// 0 <= lefti <= righti < arr.length

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