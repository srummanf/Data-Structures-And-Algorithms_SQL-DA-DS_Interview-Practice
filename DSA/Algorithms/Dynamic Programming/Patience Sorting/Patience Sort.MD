**Patience Sorting**

Patience sorting is a sorting algorithm inspired by the card game "Patience" (also known as Solitaire). The algorithm sorts a sequence of numbers by distributing them into piles using specific rules, and then merges the piles to produce a sorted sequence. The main steps of patience sorting are:

1. **Piling:** Distribute the numbers into piles such that each pile remains sorted. A number can either start a new pile or be placed on top of an existing pile where it is greater than or equal to the top card of that pile.
2. **Merging:** Merge the piles into a single sorted sequence.

```
private static int patienceSorting(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
    
        List<Integer> piles = new ArrayList<>();
    
        for (int num : nums) {
            int position = Collections.binarySearch(piles, num);
            if (position < 0) {
                position = -(position + 1);
            }
            if (position == piles.size()) {
                piles.add(num);
            } else {
                piles.set(position, num);
            }
        }
    
        return piles.size();
    }
```

The algorithm is useful for finding the Longest Increasing Subsequence (LIS) in O(n log n) time.

### 20 LeetCode Problems Related to Patience Sorting

1. [#300 Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/)
2. [#354 Russian Doll Envelopes](https://leetcode.com/problems/russian-doll-envelopes/)
3. [#1671 Minimum Number of Removals to Make Mountain Array](https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array/)
4. [#1713 Minimum Operations to Make a Subsequence](https://leetcode.com/problems/minimum-operations-to-make-a-subsequence/)
5. [#1626 Best Team With No Conflicts](https://leetcode.com/problems/best-team-with-no-conflicts/)
6. [#673 Number of Longest Increasing Subsequence](https://leetcode.com/problems/number-of-longest-increasing-subsequence/)
7. [#764 Largest Plus Sign](https://leetcode.com/problems/largest-plus-sign/)
8. [#1964 Find the Longest Valid Obstacle Course at Each Position](https://leetcode.com/problems/find-the-longest-valid-obstacle-course-at-each-position/)
9. [#1340 Jump Game V](https://leetcode.com/problems/jump-game-v/)
10. [#630 Course Schedule III](https://leetcode.com/problems/course-schedule-iii/)
11. [#1906 Minimum Absolute Difference Queries](https://leetcode.com/problems/minimum-absolute-difference-queries/)
12. [#1125 Smallest Sufficient Team](https://leetcode.com/problems/smallest-sufficient-team/)
13. [#940 Distinct Subsequences II](https://leetcode.com/problems/distinct-subsequences-ii/)
14. [#1765 Map of Highest Peak](https://leetcode.com/problems/map-of-highest-peak/)
15. [#1712 Ways to Split Array Into Three Subarrays](https://leetcode.com/problems/ways-to-split-array-into-three-subarrays/)
16. [#1473 Paint House III](https://leetcode.com/problems/paint-house-iii/)
17. [#1312 Minimum Insertion Steps to Make a String Palindrome](https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/)
18. [#1192 Critical Connections in a Network](https://leetcode.com/problems/critical-connections-in-a-network/)
19. [#1658 Minimum Operations to Reduce X to Zero](https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/)
20. [#354 Russian Doll Envelopes](https://leetcode.com/problems/russian-doll-envelopes/)

These problems often utilize the principles of patience sorting, especially for finding subsequences or dealing with interval-based problems.


# What does ` Collections.binarySearch` return

The `Collections.binarySearch` method in Java searches for a target element (`num`) within a sorted list (`piles`) and returns the index of the target if it exists. Here's what happens in both scenarios:

### 1. **When `num` is present in the list**:

- **Return Value**: If the target element (`num`) is found in the list, the method returns the **index** of the target element. If there are multiple occurrences of the element, it may return the index of any one of them (not guaranteed which).

### 2. **When `num` is **not** present in the list**:

- **Return Value**: If the target element is not found, `Collections.binarySearch` returns a **negative value**. This negative value is computed as `-(insertionPoint) - 1`, where the `insertionPoint` is the index where the target element could be inserted to maintain the list's sorted order.
  - The insertion point is the index where the element would be inserted if it were added to the list.
  - The formula `-(insertionPoint) - 1` helps distinguish between a valid index (non-negative) and an insertion point (negative).

### Example:

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> piles = new ArrayList<>();
        piles.add(1);
        piles.add(3);
        piles.add(5);
        piles.add(7);

        int num1 = 5;
        int num2 = 6;

        // Case 1: num1 is present
        int position1 = Collections.binarySearch(piles, num1);
        System.out.println("Position of " + num1 + " : " + position1);

        // Case 2: num2 is not present
        int position2 = Collections.binarySearch(piles, num2);
        System.out.println("Position of " + num2 + " : " + position2);
    }
}
```

### Output:

```
Position of 5 : 2
Position of 6 : -4
```

- For `num1 = 5`, the output is `2`, which is the index where `5` is found.
- For `num2 = 6`, the output is `-4`, which means that `6` is not present in the list, and the insertion point would be index `3` (before `7`). The result is `-(3) - 1 = -4`.
