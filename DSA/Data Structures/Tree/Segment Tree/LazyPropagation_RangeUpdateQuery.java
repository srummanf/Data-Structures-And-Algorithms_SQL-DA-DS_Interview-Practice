import java.util.*;

class LazyPropagation_RangeUpdateQuery {

  private int[] segmentTree;
  private int[] lazy;
  private int n;

  public LazyPropagation_RangeUpdateQuery(int[] nums) {
    n = nums.length;
    segmentTree = new int[4 * n];
    lazy = new int[4 * n];
    Arrays.fill(lazy, 0);
    buildSegmentTree(0, 0, n - 1, nums);
  }

  void buildSegmentTree(int i, int l, int r, int[] arr) {
    if (l == r) {
      segmentTree[i] = arr[l];
      return;
    }
    int mid = l + (r - l) / 2;
    buildSegmentTree(2 * i + 1, l, mid, arr);
    buildSegmentTree(2 * i + 2, mid + 1, r, arr);
    segmentTree[i] = segmentTree[2 * i + 1] + segmentTree[2 * i + 2];
  }

  public void updateRange(int start, int end, int val) {
    updateSegmentTree(start, end, val, 0, 0, n - 1);
  }

  void updateSegmentTree(int start, int end, int val, int i, int l, int r) {
    if (lazy[i] != 0) {
      segmentTree[i] += (r - l + 1) * lazy[i];
      if (l != r) {
        lazy[2 * i + 1] += lazy[i];
        lazy[2 * i + 2] += lazy[i];
      }
      lazy[i] = 0;
    }

    if (l > end || r < start || l > r) {
      return;
    }

    if (l >= start && r <= end) {
      segmentTree[i] += (r - l + 1) * val;
      if (l != r) {
        lazy[2 * i + 1] += val;
        lazy[2 * i + 2] += val;
      }
      return;
    }

    int mid = (l + r) / 2;
    updateSegmentTree(start, end, val, 2 * i + 1, l, mid);
    updateSegmentTree(start, end, val, 2 * i + 2, mid + 1, r);
    segmentTree[i] = segmentTree[2 * i + 1] + segmentTree[2 * i + 2];
  }

  void propagate(int i, int l, int r) {
    if (lazy[i] != 0) {
      segmentTree[i] += lazy[i];
      if (l != r) {
        lazy[2 * i + 1] += lazy[i];
        lazy[2 * i + 2] += lazy[i];
      }
      lazy[i] = 0;
    }
  }

  public static void main(String[] args) {
    int[] arr = { 1, 3, 2, 7, 9, 11 };
    LazyPropagation_RangeUpdateQuery rmq = new LazyPropagation_RangeUpdateQuery(
      arr
    );
    System.out.println(rmq.minRange(1, 3)); // Output should be 2
    System.out.println(rmq.minRange(0, 5)); // Output should be 1
    rmq.updateRange(1, 3, -1); // Update range [1, 3] by -1
    System.out.println(rmq.minRange(1, 3)); // Output should be 1
    System.out.println(rmq.minRange(0, 5)); // Output should be 0
  }
}
