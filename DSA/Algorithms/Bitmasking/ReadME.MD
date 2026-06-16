
### Bitmasking Explanation

Bitmasking is a technique used to manipulate individual bits of integers. Each bit in a binary number represents whether a certain condition is met (1) or not (0). This is particularly useful when working with subsets, states, or combinations.

#### Key Concepts:

- **Bit**: Each bit can be either 0 or 1.
- **Mask**: A mask is an integer where each bit represents whether an item is included in a subset (1) or excluded (0).
- **Bitwise Operations**:
  - **AND (`&`)**: Compares bits from two numbers and returns `1` if both bits are `1`, otherwise `0`.
  - **OR (`|`)**: Compares bits from two numbers and returns `1` if at least one bit is `1`, otherwise `0`.
  - **XOR (`^`)**: Compares bits and returns `1` if the bits are different, otherwise `0`.
  - **NOT (`~`)**: Flips all bits (`1` becomes `0` and `0` becomes `1`).
  - **Left Shift (`<<`)**: Shifts bits to the left, effectively multiplying the number by powers of 2.
  - **Right Shift (`>>`)**: Shifts bits to the right, effectively dividing the number by powers of 2.

### Bitmasking Example

Consider a set of 3 elements: `A, B, C`. You want to generate all possible subsets. Using bitmasking:

- If the bit is `1`, include the corresponding element; otherwise, exclude it.

The possible bitmasks for a set of size 3 are:

- `000` → `{}`
- `001` → `{C}`
- `010` → `{B}`
- `011` → `{B, C}`
- `100` → `{A}`
- `101` → `{A, C}`
- `110` → `{A, B}`
- `111` → `{A, B, C}`

Each bitmask corresponds to a unique subset of the set.

### Standard Template for Bitmasking

This template helps in iterating over all subsets or combinations using bitmasking:

```java
class Solution {

    public void bitmaskExample(int[] arr) {
        int n = arr.length;

        // Iterate over all possible subsets using bitmask
        for (int mask = 0; mask < (1 << n); mask++) {
            List<Integer> subset = new ArrayList<>();
          
            // For each bit position in the mask, check if it's set (1)
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    // If the ith bit is set, include arr[i] in the subset
                    subset.add(arr[i]);
                }
            }
          
            // Print the current subset
            System.out.println(subset);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1, 2, 3};
        sol.bitmaskExample(arr);
    }
}
```

### Explanation:

- **Outer Loop**: `mask` ranges from `0` to `2^n - 1`, generating all possible subsets.
- **Inner Loop**: For each `i`, we check if the `i-th` bit in the current `mask` is set. If it is, we include the corresponding element in the subset.
  - `1 << i` creates a number with only the `i-th` bit set.
  - `mask & (1 << i)` checks if the `i-th` bit of the mask is set.

### Time Complexity:

- **Outer Loop**: Runs `2^n` times for all subsets.
- **Inner Loop**: Runs `n` times to check each bit of the current mask.

This template can be used for various problems where subsets or combinations are required, especially in problems involving **combinatorics**, **dynamic programming**, or **optimization**.
