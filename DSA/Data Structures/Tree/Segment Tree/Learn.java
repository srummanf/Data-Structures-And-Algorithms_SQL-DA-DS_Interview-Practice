/*     Scroll below to see JAVA code also    */
/*
    MY YOUTUBE VIDEO ON THIS Qn : https://www.youtube.com/watch?v=VJ67kQHYbv8
    Company Tags                : AMAZON
    GfG Link                    : https://www.geeksforgeeks.org/problems/sum-of-query-ii5310/1
*/

/************************************************************************ JAVA ************************************************************************/
//NOTE - Since this is Range Sum Query, you can simply solve it using Prefix Sum Array as well. But this is segment tree repo, so I have mentioned Segment tree approach
//Using Segment Tree
//T.C : O(q*log(n))
//S.C : O(4*n)

// Build Segment Tree , Update Segment Tree, Query Segment Tree
class Learn {

    // 1. Insertion
  void buildSegmentTree(int i, int l, int r, int[] segmentTree, int[] arr) {
    if (l == r) {
      segmentTree[i] = arr[l];
      return;
    }
    int mid = l + (r - l) / 2;
    buildSegmentTree(2 * i + 1, l, mid, segmentTree, arr);
    buildSegmentTree(2 * i + 2, mid + 1, r, segmentTree, arr);
    segmentTree[i] = segmentTree[2 * i + 1] + segmentTree[2 * i + 2];
  }


  // 2. Updation
  void updateSegmentTree(
    int idx,
    int val,
    int i,
    int l,
    int r,
    int[] segmentTree,
    int[] arr
  ) {
    if (l == r) {
      segmentTree[i] = val;
      arr[idx] = val;
      return;
    }

    int mid = l + (r - l) / 2;

    // start
    if (idx <= mid) {
      updateSegmentTree(idx, val, 2 * i + 1, l, mid, segmentTree, arr);
    } else {
      updateSegmentTree(idx, val, 2 * i + 2, mid + 1, r, segmentTree, arr);
    }
    // end

    buildSegmentTree(2 * i + 1, l, mid, segmentTree, arr);
    buildSegmentTree(2 * i + 2, mid + 1, r, segmentTree, arr);
    segmentTree[i] = segmentTree[2 * i + 1] + segmentTree[2 * i + 2];
  }

  // 3. Query
  int querySegmentTree(
    int start,
    int end,
    int i,
    int l,
    int r,
    int[] segmentTree
  ) {
    // Case 1 : Out of Bound
    if (l > end || r < start) {
      return 0;
    }

    // Case 2 : Completely within the range
    if (l >= start && r <= end) {
      return segmentTree[i];
    }

    // Case 3 : Overlapping 
    int mid = l + (r - l) / 2;
    return (
      querySegmentTree(start, end, 2 * i + 1, l, mid, segmentTree) +
      querySegmentTree(start, end, 2 * i + 2, mid + 1, r, segmentTree)
    );
  }

  List<Integer> querySum(int n, int[] arr, int q, int[] queries) {
    int[] segmentTree = new int[4 * n];

    buildSegmentTree(0, 0, n - 1, segmentTree, arr);

    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < 2 * q; i += 2) {
      int start = queries[i] - 1; // Input is in 1-based indexing
      int end = queries[i + 1] - 1; // Input is in 1-based indexing

      result.add(querySegmentTree(start, end, 0, 0, n - 1, segmentTree));
    }

    return result;
  }
}
