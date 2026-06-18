# Segment Tree

---

# 1. What is a Segment Tree?

A **Segment Tree** is a tree-based data structure used for efficiently performing:

* Range Queries
* Range Updates
* Point Updates

on an array.

Instead of recomputing answers over a range repeatedly, a segment tree stores precomputed information for segments (intervals) of the array.

---

## Problem Example

Array:

```text
Index:  0 1 2 3 4 5 6 7
Value: [2 1 5 3 4 7 6 8]
```

Query:

```text
Sum(2,6)
```

Naive:

```java
5 + 3 + 4 + 7 + 6 = 25
```

Time:

```text
O(N)
```

If there are:

```text
100,000 queries
```

Naive becomes expensive.

Segment Tree:

```text
Build once: O(N)
Query:      O(log N)
Update:     O(log N)
```

---

# 2. Core Idea

Store answers for segments.

Example:

```text
[0..7]
```

contains

```text
sum(0,7)
```

Split into:

```text
[0..3]
[4..7]
```

Each stores its own sum.

Further split:

```text
[0..1] [2..3] [4..5] [6..7]
```

Continue until individual elements.

---

# 3. Visualization

Array:

```text
[2,1,5,3,4,7,6,8]
```

Segment Tree (Sum):

```text
                    [0,7]=36
                   /        \
            [0,3]=11       [4,7]=25
            /     \        /      \
       [0,1]=3 [2,3]=8 [4,5]=11 [6,7]=14
        / \      / \      / \      / \
      2   1    5   3    4   7    6   8
```

Each node stores:

```text
sum of its interval
```

---

# 4. Why Logarithmic Complexity?

Suppose:

```text
Query sum(2,6)
```

Instead of visiting all elements:

```text
5,3,4,7,6
```

Tree visits only relevant segments.

```text
[2,3]
[4,5]
[6,6]
```

Number of visited nodes:

```text
O(log N)
```

---

# 5. Segment Representation

Every node stores:

| Field | Meaning          |
| ----- | ---------------- |
| left  | left boundary    |
| right | right boundary   |
| value | aggregate answer |

Example:

```text
Node
Range: [2,3]
Value: 8
```

---

# 6. Tree Stored as Array

We usually don't create node objects.

Instead:

```java
int[] tree;
```

Root:

```text
index 1
```

Children:

```text
left  = 2*i
right = 2*i+1
```

Example:

```text
          1
       /     \
      2       3
    /  \    /   \
   4   5   6    7
```

---

# 7. Memory Requirement

Maximum nodes:

```text
2*N - 1
```

For simplicity:

```java
tree = new int[4 * n];
```

Industry standard.

---

# 8. Building Segment Tree

---

## Recursive Formula

Leaf:

```text
tree[node] = arr[index]
```

Internal Node:

```text
tree[node]
=
tree[leftChild]
+
tree[rightChild]
```

---

## Build Algorithm

```java
private void build(
        int node,
        int start,
        int end,
        int[] arr) {

    if (start == end) {
        tree[node] = arr[start];
        return;
    }

    int mid = (start + end) / 2;

    build(node * 2, start, mid, arr);

    build(node * 2 + 1, mid + 1, end, arr);

    tree[node]
        = tree[node * 2]
        + tree[node * 2 + 1];
}
```

---

## Complexity

| Operation | Complexity |
| --------- | ---------- |
| Build     | O(N)       |

Not O(N log N).

Each node computed once.

---

# 9. Range Sum Query

Query:

```text
sum(2,6)
```

---

## Three Cases

### Case 1: Complete Overlap

```text
Node Range:
[2,3]

Query:
[2,6]
```

Fully inside.

Return node value directly.

---

### Case 2: No Overlap

```text
Node Range:
[0,1]

Query:
[2,6]
```

Return:

```text
0
```

---

### Case 3: Partial Overlap

Need recursion.

---

## Visualization

```text
Query [2,6]

                    [0,7]
                   /     \
              [0,3]     [4,7]
                 \       /  \
               [2,3] [4,5] [6,7]
                             /
                          [6,6]
```

Only relevant nodes contribute.

---

## Java Code

```java
public int query(
        int node,
        int start,
        int end,
        int left,
        int right) {

    if (right < start || left > end) {
        return 0;
    }

    if (left <= start && end <= right) {
        return tree[node];
    }

    int mid = (start + end) / 2;

    int p1 = query(
            node * 2,
            start,
            mid,
            left,
            right);

    int p2 = query(
            node * 2 + 1,
            mid + 1,
            end,
            left,
            right);

    return p1 + p2;
}
```

---

## Complexity

```text
O(log N)
```

---

# 10. Point Update

Update:

```text
arr[3] = 10
```

Old:

```text
3
```

New:

```text
10
```

---

## Affected Path

```text
[3,3]
[2,3]
[0,3]
[0,7]
```

Only one root-to-leaf path.

---

## Visualization

```text
                    Root
                     |
                 [0,3]
                     |
                 [2,3]
                     |
                 [3,3]
```

---

## Java

```java
public void update(
        int node,
        int start,
        int end,
        int index,
        int value) {

    if (start == end) {
        tree[node] = value;
        return;
    }

    int mid = (start + end) / 2;

    if (index <= mid) {
        update(
            node * 2,
            start,
            mid,
            index,
            value);
    } else {
        update(
            node * 2 + 1,
            mid + 1,
            end,
            index,
            value);
    }

    tree[node]
        = tree[node * 2]
        + tree[node * 2 + 1];
}
```

---

## Complexity

```text
O(log N)
```

---

# 11. Complete Java Implementation

```java
class SegmentTree {

    private int[] tree;
    private int n;

    public SegmentTree(int[] arr) {

        n = arr.length;

        tree = new int[4 * n];

        build(1, 0, n - 1, arr);
    }

    private void build(
            int node,
            int start,
            int end,
            int[] arr) {

        if (start == end) {
            tree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;

        build(node * 2,
                start,
                mid,
                arr);

        build(node * 2 + 1,
                mid + 1,
                end,
                arr);

        tree[node]
            = tree[node * 2]
            + tree[node * 2 + 1];
    }

    public int query(int left, int right) {

        return query(
                1,
                0,
                n - 1,
                left,
                right);
    }

    private int query(
            int node,
            int start,
            int end,
            int left,
            int right) {

        if (right < start ||
            left > end) {
            return 0;
        }

        if (left <= start &&
            end <= right) {
            return tree[node];
        }

        int mid =
            (start + end) / 2;

        return query(
                node * 2,
                start,
                mid,
                left,
                right)
            +
            query(
                node * 2 + 1,
                mid + 1,
                end,
                left,
                right);
    }

    public void update(
            int index,
            int value) {

        update(
            1,
            0,
            n - 1,
            index,
            value);
    }

    private void update(
            int node,
            int start,
            int end,
            int index,
            int value) {

        if (start == end) {
            tree[node] = value;
            return;
        }

        int mid =
            (start + end) / 2;

        if (index <= mid) {

            update(
                node * 2,
                start,
                mid,
                index,
                value);

        } else {

            update(
                node * 2 + 1,
                mid + 1,
                end,
                index,
                value);
        }

        tree[node]
            =
            tree[node * 2]
            +
            tree[node * 2 + 1];
    }
}
```

---

# 12. Time Complexity Table

| Operation    | Complexity |
| ------------ | ---------- |
| Build        | O(N)       |
| Point Update | O(log N)   |
| Range Query  | O(log N)   |
| Space        | O(N)       |

---

# 13. Different Types of Segment Trees

Segment Tree is not restricted to sums.

---

## Sum Segment Tree

```text
merge(a,b)=a+b
```

---

## Minimum Segment Tree

```java
tree[node]
=
Math.min(left,right);
```

Query:

```text
Minimum in range
```

---

## Maximum Segment Tree

```java
Math.max(left,right)
```

---

## GCD Segment Tree

```java
gcd(left,right)
```

---

## XOR Segment Tree

```java
left ^ right
```

---

## Product Segment Tree

```java
left * right
```

---

# 14. Generic Segment Tree Concept

Think of:

```text
merge()
```

as the only thing that changes.

```java
answer =
merge(leftAnswer,rightAnswer);
```

Everything else remains identical.

---

# 15. Hidden Insight #1

Segment Tree is essentially:

```text
Divide and Conquer
+
Memoization
```

The tree stores answers for all subranges.

---

# 16. Hidden Insight #2

Height of Segment Tree

```text
Height = ceil(log₂N)
```

Example:

```text
N=8
Height=3
```

```text
N=16
Height=4
```

---

# 17. Hidden Insight #3

Why Queries Visit Only O(logN) Nodes?

A range intersects at most:

```text
2 nodes per level
```

Levels:

```text
logN
```

Thus:

```text
O(logN)
```

---

# 18. Hidden Insight #4

Fenwick Tree vs Segment Tree

| Feature          | Fenwick | Segment Tree |
| ---------------- | ------- | ------------ |
| Range Sum        | Yes     | Yes          |
| Point Update     | Yes     | Yes          |
| Range Min        | No      | Yes          |
| Range Max        | No      | Yes          |
| Lazy Propagation | No      | Yes          |
| Simpler          | Yes     | No           |

Fenwick Tree is a specialized version for cumulative operations.

---

# 19. Hidden Insight #5

Segment Tree Works Because Merge Is Associative

Must satisfy:

```text
(a • b) • c
=
a • (b • c)
```

Examples:

```text
+
min
max
xor
gcd
```

Associative.

---

# 20. Lazy Propagation (Advanced)

Without lazy propagation:

```text
Add 5 to range [1,100000]
```

Requires:

```text
100000 updates
```

---

With Lazy Propagation:

Store pending updates.

```text
lazy[node]
```

Apply later only when needed.

---

Complexities:

| Operation    | Complexity |
| ------------ | ---------- |
| Range Update | O(log N)   |
| Range Query  | O(log N)   |

This is one of the most important competitive programming optimizations.

---

# 21. Segment Tree Beats (Very Advanced)

Used for:

```text
Range ChMin
Range ChMax
Range Add
Range Sum
```

Operations impossible with standard lazy propagation.

Common in elite competitive programming.

---

# 22. Iterative Segment Tree

Avoid recursion.

Structure:

```java
int[] tree = new int[2 * n];
```

Visualization:

```text
Leaves:
[n ... 2n-1]

Parents:
[1 ... n-1]
```

Popular because:

```text
Faster
Less memory
No recursion overhead
```

---

# 23. Real Industry Uses

### Databases

Range aggregation.

### Analytics Systems

Window computations.

### Time Series Engines

Range statistics.

### Stock Systems

Price ranges.

### GIS Systems

Spatial interval queries.

### Search Engines

Frequency aggregations.

---

# 24. Common Interview Questions

### Q1

Why not use prefix sum?

Answer:

```text
Prefix Sum:
Query O(1)
Update O(N)

Segment Tree:
Query O(logN)
Update O(logN)
```

---

### Q2

Why allocate 4*N?

Because tree may not be complete when:

```text
N != power of 2
```

4N safely covers all cases.

---

### Q3

Can Segment Tree answer dynamic queries?

Yes.

That is exactly why it exists.

---

# 25. Master Mental Model

Imagine the array is continuously split:

```text
[0,15]
   |
----------------
|              |
[0,7]       [8,15]
 |             |
-----         -----
|   |         |   |
...
```

Each node stores:

```text
"The answer for my interval."
```

Queries:

```text
Collect answers from the fewest fully-covered intervals.
```

Updates:

```text
Modify one leaf and rebuild only its ancestors.
```

This single idea explains:

* Sum Segment Tree
* Min Segment Tree
* Max Segment Tree
* GCD Segment Tree
* XOR Segment Tree
* Lazy Propagation
* Segment Tree Beats

One correction is important:

A **Segment Tree is *not* a height-balanced binary tree in the AVL-tree sense.**

The statement:

> The absolute difference between the heights of the left subtree and right subtree cannot be greater than 1.

is the balancing condition of an  **AVL Tree** , not a Segment Tree.

---

# Is Segment Tree a Balanced Binary Tree?

Yes, but in a different sense.

A Segment Tree is a **nearly complete binary tree** whose height is always:

```text
O(log N)
```

because every segment is split approximately in half.

---

## Segment Tree Splitting

For:

```text
N = 8
```

```text
                    [0,7]
                   /     \
              [0,3]     [4,7]
              /   \     /   \
          [0,1] [2,3] [4,5] [6,7]
          / \   / \   / \   / \
         0  1  2  3  4  5  6  7
```

Every split is almost equal.

Therefore:

```text
Height = O(log N)
```

---

## What Happens When N Is Not a Power of 2?

Example:

```text
N = 5
```

Array:

```text
[2,1,5,3,4]
```

Tree:

```text
                    [0,4]
                   /     \
               [0,2]     [3,4]
               /   \      /  \
           [0,1] [2,2] [3,3] [4,4]
           / \
       [0,0][1,1]
```

Notice:

```text
Left Height  = 3
Right Height = 2
```

Difference:

```text
1
```

Still logarithmic.

---

## More Accurate Statement

Instead of writing:

> |height(left) - height(right)| ≤ 1

Write:

### Segment Tree Balance Property

A Segment Tree remains approximately balanced because every interval is recursively divided into two nearly equal halves.

Consequences:

| Property | Value    |
| -------- | -------- |
| Height   | O(log N) |
| Query    | O(log N) |
| Update   | O(log N) |
| Build    | O(N)     |
| Space    | O(N)     |

---

# Hidden Note: Why Segment Tree Never Degenerates

Compare with BST.

Bad BST:

```text
1
 \
  2
   \
    3
     \
      4
```

Height:

```text
O(N)
```

---

Segment Tree:

```text
Always split at mid
```

```java
int mid = (start + end) / 2;
```

Therefore it can never become:

```text
Linked List Shape
```

which guarantees:

```text
Height = O(log N)
```

without requiring AVL rotations or Red-Black recoloring.

---

# Complete LeetCode Roadmap for Segment Trees

The following list covers nearly every Segment Tree pattern appearing in:

* FAANG interviews
* OA rounds
* Competitive Programming
* HFT interviews
* Advanced DSA rounds

---

## Level 1 — Basic Range Query Segment Tree

| LeetCode | Problem                    | Pattern                    |
| -------- | -------------------------- | -------------------------- |
| 303      | Range Sum Query Immutable  | Prefix Sum vs Segment Tree |
| 307      | Range Sum Query Mutable    | Classic Segment Tree       |
| 304      | Range Sum Query 2D         | 2D Extension               |
| 308      | Range Sum Query 2D Mutable | 2D Segment Tree            |

---

## Level 2 — Range Minimum / Maximum

| LeetCode | Problem                                  | Pattern                  |
| -------- | ---------------------------------------- | ------------------------ |
| 239      | Sliding Window Maximum                   | Segment Tree Alternative |
| 1649     | Create Sorted Array through Instructions | Range Count              |
| 699      | Falling Squares                          | Range Maximum Query      |
| 2286     | Booking Concert Tickets                  | Range Max Segment Tree   |

---

## Level 3 — Point Update + Range Query

| LeetCode | Problem                             | Pattern                               |
| -------- | ----------------------------------- | ------------------------------------- |
| 307      | Range Sum Query Mutable             | Foundation                            |
| 315      | Count of Smaller Numbers After Self | Frequency Segment Tree                |
| 493      | Reverse Pairs                       | Coordinate Compression + Segment Tree |
| 327      | Count of Range Sum                  | Prefix + Segment Tree                 |

---

## Level 4 — Frequency Segment Tree

These appear heavily in OAs.

| LeetCode | Problem                                  |
| -------- | ---------------------------------------- |
| 315      | Count Smaller After Self                 |
| 493      | Reverse Pairs                            |
| 1649     | Create Sorted Array Through Instructions |
| 327      | Count Range Sum                          |
| 2426     | Number of Pairs Satisfying Inequality    |

---

## Level 5 — Coordinate Compression + Segment Tree

Extremely common interview pattern.

| LeetCode | Problem                          |
| -------- | -------------------------------- |
| 315      | Count Smaller Numbers After Self |
| 493      | Reverse Pairs                    |
| 327      | Count Range Sum                  |
| 699      | Falling Squares                  |
| 850      | Rectangle Area II                |

---

## Level 6 — Lazy Propagation

Most candidates stop before this level.

---

### Range Addition

| LeetCode | Problem                   |
| -------- | ------------------------- |
| 370      | Range Addition            |
| 1094     | Car Pooling               |
| 1109     | Corporate Flight Bookings |

These can be solved with Difference Arrays but are excellent lazy-propagation practice.

---

### True Lazy Propagation Problems

| LeetCode | Problem                     |
| -------- | --------------------------- |
| 699      | Falling Squares             |
| 715      | Range Module                |
| 732      | My Calendar III             |
| 218      | Skyline Problem             |
| 2276     | Count Integers in Intervals |

---

## Level 7 — Dynamic Segment Tree

Used when coordinate range is huge.

Example:

```text
0 → 10^9
```

Cannot allocate:

```java
int[4 * 10^9]
```

---

| LeetCode | Problem                     |
| -------- | --------------------------- |
| 715      | Range Module                |
| 732      | My Calendar III             |
| 2276     | Count Integers in Intervals |

---

## Level 8 — Merge Sort Tree

Segment Tree + Sorted Arrays.

| LeetCode | Problem                          |
| -------- | -------------------------------- |
| 315      | Count Smaller Numbers After Self |
| 327      | Count Range Sum                  |
| 493      | Reverse Pairs                    |

---

## Level 9 — Order Statistics Tree Using Segment Tree

Find:

```text
k-th smallest
k-th largest
median
rank
```

---

| LeetCode | Problem                                |
| -------- | -------------------------------------- |
| 440      | K-th Smallest in Lexicographical Order |
| 719      | K-th Smallest Pair Distance            |
| 1439     | Kth Smallest Sum                       |
| 378      | Kth Smallest Element in Sorted Matrix  |

---

## Level 10 — Sweep Line + Segment Tree

One of the hardest interview patterns.

---

### Pattern

```text
Geometry
+
Events
+
Segment Tree
```

---

| LeetCode | Problem           |
| -------- | ----------------- |
| 218      | Skyline Problem   |
| 850      | Rectangle Area II |
| 391      | Perfect Rectangle |
| 699      | Falling Squares   |

---

## Level 11 — Dynamic Interval Queries

Very common at Google.

| LeetCode | Problem                     |
| -------- | --------------------------- |
| 715      | Range Module                |
| 729      | My Calendar I               |
| 731      | My Calendar II              |
| 732      | My Calendar III             |
| 2276     | Count Integers in Intervals |

---

## Level 12 — Segment Tree on Bits

| LeetCode | Problem                       |
| -------- | ----------------------------- |
| 1310     | XOR Queries of a Subarray     |
| 1707     | Maximum XOR With Element      |
| 1803     | Count Pairs With XOR in Range |

---

## Level 13 — Segment Tree + DP

Appears in harder Google/Meta rounds.

| LeetCode | Problem                                               |
| -------- | ----------------------------------------------------- |
| 2407     | Longest Increasing Subsequence II                     |
| 2736     | Maximum Sum Queries                                   |
| 2926     | Maximum Balanced Subsequence Sum                      |
| 3165     | Maximum Sum of Subsequence With Non-adjacent Elements |

---

## Level 14 — Segment Tree Beats (Elite)

Very advanced.

| LeetCode | Problem                           |
| -------- | --------------------------------- |
| 2569     | Handling Sum Queries After Update |
| 699      | Falling Squares                   |
| 2736     | Maximum Sum Queries               |

---

# Recommended Learning Order

| Step | Problem |
| ---- | ------- |
| 1    | 303     |
| 2    | 307     |
| 3    | 315     |
| 4    | 493     |
| 5    | 327     |
| 6    | 699     |
| 7    | 715     |
| 8    | 732     |
| 9    | 218     |
| 10   | 850     |
| 11   | 2407    |
| 12   | 2736    |

If you can solve  **307 → 315 → 493 → 327 → 699 → 715 → 732 → 218** , you will have covered roughly **90% of Segment Tree patterns** that appear in software engineering interviews and online assessments.
