# Segment Tree Overview

## What is a Segment Tree?

A Segment Tree is a binary tree used for storing intervals or segments. It allows querying and updating operations on an array in logarithmic time. It's particularly useful for problems involving range queries and updates, such as sum, minimum, maximum, or greatest common divisor (GCD) over a range of elements.

## Key Operations

1. **Building the Segment Tree**: Construct the tree from the input array.
2. **Updating the Segment Tree**: Modify the value of a specific element and update the tree accordingly.
3. **Range Query**: Retrieve information (e.g., sum, minimum) over a range of elements.
4. **Lazy Propagation**: Optimize range updates to avoid unnecessary updates.

## Code Examples

### 1. Building the Segment Tree

```java
class SegmentTree {
    private int[] segmentTree;
    private int n;

    public SegmentTree(int[] nums) {
        n = nums.length;
        segmentTree = new int[4 * n];
        buildSegmentTree(0, 0, n - 1, nums);
    }

    private void buildSegmentTree(int root, int l, int r, int[] nums) {
        if (l == r) {
            segmentTree[root] = nums[l];
            return;
        }
        int mid = l + (r - l) / 2;
        buildSegmentTree(2 * root + 1, l, mid, nums);
        buildSegmentTree(2 * root + 2, mid + 1, r, nums);
        segmentTree[root] = segmentTree[2 * root + 1] + segmentTree[2 * root + 2];
    }
}
```

### 2. Updating the Segment Tree with Value

```java
class SegmentTree {
    private int[] segmentTree;
    private int n;

    public SegmentTree(int[] nums) {
        n = nums.length;
        segmentTree = new int[4 * n];
        buildSegmentTree(0, 0, n - 1, nums);
    }

    private void buildSegmentTree(int root, int l, int r, int[] nums) {
        if (l == r) {
            segmentTree[root] = nums[l];
            return;
        }
        int mid = l + (r - l) / 2;
        buildSegmentTree(2 * root + 1, l, mid, nums);
        buildSegmentTree(2 * root + 2, mid + 1, r, nums);
        segmentTree[root] = segmentTree[2 * root + 1] + segmentTree[2 * root + 2];
    }

    public void update(int index, int val) {
        updateSegmentTree(index, val, 0, 0, n - 1);
    }

    private void updateSegmentTree(int idx, int val, int root, int l, int r) {
        if (l == r) {
            segmentTree[root] = val;
            return;
        }
        int mid = l + (r - l) / 2;
        if (idx <= mid) {
            updateSegmentTree(idx, val, 2 * root + 1, l, mid);
        } else {
            updateSegmentTree(idx, val, 2 * root + 2, mid + 1, r);
        }
        segmentTree[root] = segmentTree[2 * root + 1] + segmentTree[2 * root + 2];
    }
}
```

### 3. Range Query

```java
class SegmentTree {
    private int[] segmentTree;
    private int n;

    public SegmentTree(int[] nums) {
        n = nums.length;
        segmentTree = new int[4 * n];
        buildSegmentTree(0, 0, n - 1, nums);
    }

    private void buildSegmentTree(int root, int l, int r, int[] nums) {
        if (l == r) {
            segmentTree[root] = nums[l];
            return;
        }
        int mid = l + (r - l) / 2;
        buildSegmentTree(2 * root + 1, l, mid, nums);
        buildSegmentTree(2 * root + 2, mid + 1, r, nums);
        segmentTree[root] = segmentTree[2 * root + 1] + segmentTree[2 * root + 2];
    }

    public int sumRange(int left, int right) {
        return querySegmentTree(left, right, 0, 0, n - 1);
    }

    private int querySegmentTree(int start, int end, int root, int l, int r) {
        if (l > end || r < start) {
            return 0;
        }
        if (l >= start && r <= end) {
            return segmentTree[root];
        }
        int mid = l + (r - l) / 2;
        return querySegmentTree(start, end, 2 * root + 1, l, mid) +
               querySegmentTree(start, end, 2 * root + 2, mid + 1, r);
    }
}
```

### 4. Lazy Propagation

```java
class SegmentTreeLazy {
    private int[] segmentTree;
    private int[] lazy;
    private int n;

    public SegmentTreeLazy(int[] nums) {
        n = nums.length;
        segmentTree = new int[4 * n];
        lazy = new int[4 * n];
        Arrays.fill(lazy, 0);
        buildSegmentTree(0, 0, n - 1, nums);
    }

    private void buildSegmentTree(int root, int l, int r, int[] nums) {
        if (l == r) {
            segmentTree[root] = nums[l];
            return;
        }
        int mid = l + (r - l) / 2;
        buildSegmentTree(2 * root + 1, l, mid, nums);
        buildSegmentTree(2 * root + 2, mid + 1, r, nums);
        segmentTree[root] = segmentTree[2 * root + 1] + segmentTree[2 * root + 2];
    }

    public void updateRange(int start, int end, int val) {
        updateSegmentTree(start, end, val, 0, 0, n - 1);
    }

    private void updateSegmentTree(int start, int end, int val, int root, int l, int r) {
        if (lazy[root] != 0) {
            segmentTree[root] += (r - l + 1) * lazy[root];
            if (l != r) {
                lazy[2 * root + 1] += lazy[root];
                lazy[2 * root + 2] += lazy[root];
            }
            lazy[root] = 0;
        }

        if (l > end || r < start || l > r) {
            return;
        }

        if (l >= start && r <= end) {
            segmentTree[root] += (r - l + 1) * val;
            if (l != r) {
                lazy[2 * root + 1] += val;
                lazy[2 * root + 2] += val;
            }
            return;
        }

        int mid = l + (r - l) / 2;
        updateSegmentTree(start, end, val, 2 * root + 1, l, mid);
        updateSegmentTree(start, end, val, 2 * root + 2, mid + 1, r);
        segmentTree[root] = segmentTree[2 * root + 1] + segmentTree[2 * root + 2];
    }

    private int querySegmentTree(int start, int end, int root, int l, int r) {
        if (lazy[root] != 0) {
            segmentTree[root] += (r - l + 1) * lazy[root];
            if (l != r) {
                lazy[2 * root + 1] += lazy[root];
                lazy[2 * root + 2] += lazy[root];
            }
            lazy[root] = 0;
        }

        if (l > end || r < start) {
            return 0;
        }
        if (l >= start && r <= end) {
            return segmentTree[root];
        }
        int mid = l + (r - l) / 2;
        return querySegmentTree(start, end, 2 * root + 1, l, mid) +
               querySegmentTree(start, end, 2 * root + 2, mid + 1, r);
    }

    public int sumRange(int left, int right) {
        return querySegmentTree(left, right, 0, 0, n - 1);
    }
}
```

---

This document covers the basics of Segment Trees and provides Java code for building a Segment Tree, updating it with a value, performing range queries, and using lazy propagation to optimize range updates.
