/** Problem Statement
 * You are given an integer array nums consisting of 3n elements. You are allowed to remove any n elements from nums, and the remaining 2n elements will be divided into two equal parts:
 * The first n elements will be the first part, and the next n elements will be the
 * second part.
 * The difference in sums of the two parts is the sum of the first part minus the sum
 * of the second part.
 * Return the minimum difference among all possible ways of removing n elements.
 * 
 * The video explains the intuition for solving the **Minimum Difference in Sums After Removal of Elements** problem (Leetcode 2163) by focusing on how to minimize the difference between two parts of an array after removing $n$ elements (3:35).

### Core Intuition
* **Goal:** Given an array of size $3n$, you must remove $n$ elements so that the remaining $2n$ elements are split into two halves of size $n$. You want to minimize the expression: `(Sum of first n elements) - (Sum of last n elements)`.
* **Strategy:** To make this difference as small as possible, you need to make the **left sum as small as possible** and the **right sum as large as possible** (5:30-6:40).

### Implementation Strategy
1. **Precomputing Left Minimums:** You iterate through the array from left to right, maintaining a **Max-Heap** of size $n$ (15:04). If you encounter a new element that exceeds the current heap size, you remove the largest element from the heap (since you want to keep the smallest values) and update the running sum. This allows you to store the minimum possible sum of $n$ elements for every valid prefix (18:40).
2. **Precomputing Right Maximums:** Similarly, you iterate from right to left using a **Min-Heap** of size $n$ (19:08). By removing the smallest elements when the heap exceeds size $n$, you ensure that the remaining sum represents the maximum possible sum of $n$ elements for every valid suffix (20:12).
3. **Finding the Optimal Partition:** Once you have these two precomputed arrays, you simply iterate through all possible split points $i$ (where $n-1 \le i \le 2n-1$) and calculate the difference: `LeftMinSum[i] - RightMaxSum[i+1]` (34:49). The minimum value found during this iteration is your final answer (35:24).

### Key Concepts
* **Heap Data Structures:** The use of Max-Heaps and Min-Heaps is essential to efficiently track the smallest and largest elements in $O(n \log n)$ time (31:42).
* **Sliding Window/Prefix Sums:** Precomputing these values eliminates the need for expensive nested iterations, making the algorithm highly efficient (17:33).
 */


import java.util.*;


class PQ5_MinimumDifferenceinSumsAfterRemovalofElements{
    public long minimumDifference(int[] nums) {

        long ans = Long.MAX_VALUE;

        int N = nums.length;
        int n = N / 3;

        /*
            We need to remove exactly n elements from 3n elements.

            After removal:
                - First n elements contribute to the LEFT sum
                - Last n elements contribute to the RIGHT sum

            We want to minimize:

                LEFT SUM - RIGHT SUM

            So for every possible split, we want:
                1. Minimum possible sum of n elements on the left
                2. Maximum possible sum of n elements on the right
        */

        // leftMinSum[i] = minimum sum of n elements
        //                that can be selected from nums[0...i]
        long[] leftMinSum = new long[N];

        // rightMaxSum[i] = maximum sum of n elements
        //                 that can be selected from nums[i...N-1]
        long[] rightMaxSum = new long[N];


        // ---------------------------------------------------------
        // 1. LEFT SIDE
        // ---------------------------------------------------------

        /*
            We need the MINIMUM possible sum of n elements.

            We iterate from left to right.

            We maintain a MAX HEAP so that the largest element
            is always at the top.

            Why?

            Suppose we currently have n + 1 elements.

            We only want to keep n elements with the smallest sum.

            Therefore, we remove the LARGEST element.

            Example:

                elements = [1, 2, 5]

                n = 2

                Remove 5

                Remaining = [1, 2]

            A max heap lets us remove 5 in O(log n).
        */

        // MAX HEAP
        // peek/poll gives the largest element
        PriorityQueue<Integer> minHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        long leftSum = 0;

        for (int i = 0; i < 2 * n; i++) {

            // Add current element to our candidate set
            minHeap.add(nums[i]);
            leftSum += nums[i];

            /*
                We only want exactly n elements.

                If we have more than n elements,
                remove the largest one.

                This guarantees that the heap always
                contains the n SMALLEST elements seen so far.
            */
            if (minHeap.size() > n) {
                leftSum -= minHeap.poll();
            }

            /*
                Store the minimum sum of n elements
                that can be formed using nums[0...i].
            */
            leftMinSum[i] = leftSum;
        }


        // ---------------------------------------------------------
        // 2. RIGHT SIDE
        // ---------------------------------------------------------

        /*
            Now we need the MAXIMUM possible sum of n elements.

            We iterate from right to left.

            We maintain a MIN HEAP so that the smallest
            element is always at the top.

            Why?

            Suppose we have n + 1 elements.

            We only want n elements with the largest sum.

            Therefore, we remove the SMALLEST element.

            Example:

                elements = [1, 5, 7]

                n = 2

                Remove 1

                Remaining = [5, 7]

            A min heap lets us remove 1 in O(log n).
        */

        // MIN HEAP
        // peek/poll gives the smallest element
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>();

        long rightSum = 0;

        for (int i = N - 1; i >= n; i--) {

            // Add current element to our candidate set
            maxHeap.add(nums[i]);
            rightSum += nums[i];

            /*
                We only want exactly n elements.

                If we have more than n elements,
                remove the smallest one.

                This guarantees that the heap always
                contains the n LARGEST elements seen so far.
            */
            if (maxHeap.size() > n) {
                rightSum -= maxHeap.poll();
            }

            /*
                Store the maximum sum of n elements
                that can be formed using nums[i...N-1].
            */
            rightMaxSum[i] = rightSum;
        }


        // ---------------------------------------------------------
        // 3. FIND THE BEST SPLIT
        // ---------------------------------------------------------

        /*
            Now we have two arrays:

            leftMinSum[i]
                -> minimum sum of n elements from nums[0...i]

            rightMaxSum[i]
                -> maximum sum of n elements from nums[i...N-1]

            We try every valid split.

            Example:

                nums:
                [ x x x | x x x ]
                    i     i+1

                LEFT  = nums[0...i]
                RIGHT = nums[i+1...N-1]

            We calculate:

                leftMinSum[i] - rightMaxSum[i + 1]

            and take the minimum.

            Why does this work?

            For every possible boundary, we independently choose:
                - the cheapest n elements on the left
                - the most expensive n elements on the right

            Therefore, for that boundary, we get the smallest
            possible value of:

                LEFT SUM - RIGHT SUM
        */

        for (int i = n - 1; i < 2 * n; i++) {

            ans = Math.min(
                ans,
                leftMinSum[i] - rightMaxSum[i + 1]
            );
        }

        return ans;
    }

}