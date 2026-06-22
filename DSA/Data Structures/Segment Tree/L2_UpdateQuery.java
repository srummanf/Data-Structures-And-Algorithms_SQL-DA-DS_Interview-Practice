/* Range Sum Query with Point Update using Segment Tree */

import java.util.ArrayList;
import java.util.List;

public class L2_UpdateQuery {

    // Build Segment Tree
    void buildSegmentTree(int idx, int l, int r, int[] segmentTree, int[] arr) {
        if (l == r) {
            segmentTree[idx] = arr[l];
            return;
        }

        int mid = l + (r - l) / 2;

        buildSegmentTree(2 * idx + 1, l, mid, segmentTree, arr);
        buildSegmentTree(2 * idx + 2, mid + 1, r, segmentTree, arr);

        segmentTree[idx] = segmentTree[2 * idx + 1] + segmentTree[2 * idx + 2];
    }

    // Range Sum Query
    int rangeSumQuery(int start, int end, int idx, int l, int r, int[] segmentTree) {

        // Case 1: No Overlap
        if (l > end || r < start) {
            return 0;
        }

        // Case 2: Complete Overlap
        if (l >= start && r <= end) {
            return segmentTree[idx];
        }

        // Case 3: Partial Overlap
        int mid = l + (r - l) / 2;

        return rangeSumQuery(start, end, 2 * idx + 1, l, mid, segmentTree)
                + rangeSumQuery(start, end, 2 * idx + 2, mid + 1, r, segmentTree);
    }

    // Point Update
    void updateQuery(int index, int value, int idx, int l, int r, int[] segmentTree) {

        // Leaf Node
        if (l == r) {
            segmentTree[idx] = value;
            return;
        }

        int mid = l + (r - l) / 2;

        if (index <= mid) {
            updateQuery(index, value, 2 * idx + 1, l, mid, segmentTree);
        } else {
            updateQuery(index, value, 2 * idx + 2, mid + 1, r, segmentTree);
        }

        // Update current node
        segmentTree[idx] = segmentTree[2 * idx + 1] + segmentTree[2 * idx + 2];
    }

    // Process Queries
    List<Integer> querySum(int n, int arr[], int q, int queries[]) {

        int[] segmentTree = new int[4 * n];

        buildSegmentTree(0, 0, n - 1, segmentTree, arr);

        List<Integer> ans = new ArrayList<>();

        // Queries before update
        for (int i = 0; i < queries.length; i += 2) {
            int start = queries[i] - 1;
            int end = queries[i + 1] - 1;

            ans.add(rangeSumQuery(start, end, 0, 0, n - 1, segmentTree));
        }

        // Update Example
        System.out.println("Before Update: " + ans);

        // Update arr[2] = 10 (3rd element)
        arr[2] = 10;
        updateQuery(2, 10, 0, 0, n - 1, segmentTree);

        ans.clear();

        // Queries after update
        for (int i = 0; i < queries.length; i += 2) {
            int start = queries[i] - 1;
            int end = queries[i + 1] - 1;

            ans.add(rangeSumQuery(start, end, 0, 0, n - 1, segmentTree));
        }

        return ans;
    }

    public static void main(String[] args) {

        L2_UpdateQuery obj = new L2_UpdateQuery();

        int n = 5;
        int arr[] = {1, 2, 3, 4, 5};

        int q = 2;
        int queries[] = {1, 3, 2, 5};

        List<Integer> ans = obj.querySum(n, arr, q, queries);

        System.out.println("After Update : " + ans);
    }
}