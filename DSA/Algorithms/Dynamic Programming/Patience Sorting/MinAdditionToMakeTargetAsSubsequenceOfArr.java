import java.util.*;

public class Solution {

    public int minOperations(int[] target, int[] arr) {
        // Step 1: Map elements of target to their indices
        Map<Integer, Integer> targetIndexMap = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            targetIndexMap.put(target[i], i);
        }

        // Step 2: Transform arr elements into target indices
        List<Integer> transformed = new ArrayList<>();
        for (int num : arr) {
            if (targetIndexMap.containsKey(num)) {
                transformed.add(targetIndexMap.get(num));
            }
        }

        // Step 3: Find the LIS in the transformed array
        int lisLength = patienceSort(transformed);

        // Step 4: Calculate the minimum number of operations
        return target.length - lisLength;
    }

    private int patienceSort(List<Integer> nums) {
        List<Integer> piles = new ArrayList<>();

        for (int num : nums) {
            int idx = Collections.binarySearch(piles, num);
            if (idx < 0) idx = -idx - 1;
            if (idx == piles.size()) {
                piles.add(num);
            } else {
                piles.set(idx, num);
            }
        }

        return piles.size();
    }
}

/** Certainly! Let's break down the intuition behind the code step-by-step.

### Problem Understanding

The problem requires transforming the `arr` so that `target` becomes a subsequence of `arr` using the minimum number of operations. This means we need to find the longest common subsequence (LCS) between `target` and `arr`, and the minimal operations would be the difference between the length of `target` and this LCS.

### Steps and Intuition

1. **Mapping Elements to Indices**:
   - **Why?**: By mapping elements of `target` to their indices, we can later replace elements of `arr` with these indices, turning the problem into finding the longest increasing subsequence (LIS).
   - **How?**: We create a `HashMap` where the keys are elements of `target` and the values are their respective indices.

2. **Transforming `arr` to Indices**:
   - **Why?**: The challenge is now to find which parts of `arr` correspond to the `target` in the same order. By replacing elements of `arr` with their corresponding indices from the `target`, we can work with a sequence of indices.
   - **How?**: Iterate through `arr` and for each element that exists in the `targetIndexMap`, replace it with the corresponding index from the map.

3. **Finding the Longest Increasing Subsequence (LIS)**:
   - **Why?**: The LIS in the transformed array represents the longest common subsequence of `target` and `arr` when both are aligned in the same order. This is because the indices in the `transformed` list that form the LIS correspond to elements in `target` that can be arranged in increasing order, preserving their original order in `target`.
   - **How?**: We use the patience sorting technique to find the LIS. This involves using binary search to maintain a sequence of "piles" where each pile represents an increasing subsequence.

4. **Calculating the Result**:
   - **Why?**: The minimum number of operations required to make `target` a subsequence of `arr` is the total number of elements in `target` minus the length of the LIS.
   - **How?**: The length of `target` minus the length of the LIS gives us the minimum number of deletions needed.

### Detailed Explanation of Patience Sorting

- **Patience Sorting**: This technique is inspired by the card game patience (or solitaire). We maintain a list of "piles" where each pile contains an increasing sequence.
- **Binary Search**: For each element in the transformed list, we use binary search to find the correct pile to place the element. If the element is greater than all existing piles' top cards, it starts a new pile. Otherwise, it replaces the top card of the appropriate pile.

### Code Walkthrough

1. **Mapping Elements**:
   ```java
   Map<Integer, Integer> targetIndexMap = new HashMap<>();
   for (int i = 0; i < target.length; i++) {
       targetIndexMap.put(target[i], i);
   }
   ```
   - We map each element of `target` to its index.

2. **Transforming `arr`**:
   ```java
   List<Integer> transformed = new ArrayList<>();
   for (int num : arr) {
       if (targetIndexMap.containsKey(num)) {
           transformed.add(targetIndexMap.get(num));
       }
   }
   ```
   - We create a new list `transformed` where each element of `arr` that exists in `target` is replaced by its index from `target`.

3. **Finding LIS**:
   ```java
   private int patienceSort(List<Integer> nums) {
       List<Integer> piles = new ArrayList<>();
       for (int num : nums) {
           int idx = Collections.binarySearch(piles, num);
           if (idx < 0) idx = -idx - 1;
           if (idx == piles.size()) {
               piles.add(num);
           } else {
               piles.set(idx, num);
           }
       }
       return piles.size();
   }
   ```
   - The `patienceSort` method finds the LIS in the `transformed` list. We maintain the `piles` where each pile's top card is the smallest possible end value of an increasing subsequence of a certain length.
   - `Collections.binarySearch(piles, num)` is used to find the position to insert or replace the current number.

4. **Calculating the Result**:
   ```java
   int lisLength = patienceSort(transformed);
   return target.length - lisLength;
   ```
   - Finally, the result is computed by subtracting the length of the LIS from the length of `target`.

### Conclusion

The key intuition here is transforming the problem into one that can be solved by finding the longest increasing subsequence in a transformed array. By mapping elements to indices, we leverage the LIS to effectively determine the minimal operations needed. The patience sorting technique with binary search efficiently computes the LIS, making the solution both elegant and efficient. */