The problem you're working on, LeetCode 1155 ("Number of Dice Rolls With Target Sum"), is about finding the number of ways to roll `n` dice, each with `k` faces, so that the sum of the dice equals a given `target`. Your current approach is recursively exploring every possible dice combination, but this approach isn't efficient for large inputs.

To optimize this, we should use **dynamic programming (DP)** to avoid redundant calculations.

### Approach:

1. **State Representation**:

   - Let `dp[i][j]` represent the number of ways to get a sum of `j` using `i` dice.
2. **Recurrence Relation**:

   - For each dice `i`, we can add a value `x` (from `1` to `k`, the number of faces) to the previous state `dp[i-1][j-x]`, where `j-x` is the remaining target after rolling `x` on the current dice.
   - Formula: `dp[i][j] = dp[i][j] + dp[i-1][j-x]` for all `x` in `[1, k]`.
3. **Base Case**:

   - There's exactly one way to get a sum of `0` with `0` dice: `dp[0][0] = 1`.
4. **Modulo Operation**:

   - Since the result might be large, we'll return the answer modulo `1e9 + 7`.

Here is the optimized DP solution in Java:

### Optimized Solution:

```java
import java.util.*;

class Solution {
    private static final int MOD = 1000000007;

    public int numRollsToTarget(int n, int k, int target) {
        // dp[i][j] will store the number of ways to get sum j using i dice.
        int[][] dp = new int[n + 1][target + 1];
      
        // Base case: One way to get sum 0 with 0 dice.
        dp[0][0] = 1;

        // Iterate over each dice
        for (int i = 1; i <= n; i++) {
            // Iterate over each target sum from 1 to target
            for (int j = 1; j <= target; j++) {
                // Calculate the number of ways to reach sum j using i dice
                for (int x = 1; x <= k; x++) {
                    if (j - x >= 0) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - x]) % MOD;
                    }
                }
            }
        }
      
        return dp[n][target];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.numRollsToTarget(2, 6, 7)); // Example output: 6
    }
}
```

### Explanation:

1. **DP Table Setup**:

   - `dp[i][j]` holds the number of ways to roll `i` dice to get the sum `j`.
2. **Filling the Table**:

   - For each dice (`i`), and each possible target sum (`j`), iterate through all faces (`x` from 1 to `k`). If `j - x >= 0`, update `dp[i][j]` by adding the result from `dp[i-1][j-x]` (previous dice).
3. **Final Answer**:

   - The answer will be stored in `dp[n][target]`, representing the number of ways to roll `n` dice and achieve the sum `target`.

### Time Complexity:

- **Time**: `O(n * target * k)` where:

  - `n` is the number of dice.
  - `target` is the target sum.
  - `k` is the number of faces on each dice.
- **Space**: `O(n * target)` for the DP table.

This approach efficiently calculates the number of ways to reach the target using dynamic programming, avoiding the overhead of recursion.



To better understand the dynamic programming solution for the problem, let's break down the bottom-up DP table filling process.

### Example:

- **n** (number of dice) = 2
- **k** (number of faces on each dice) = 6
- **target** (desired sum) = 7

We'll construct a DP table step by step.

### DP Table:

- `dp[i][j]`: Number of ways to achieve sum `j` using `i` dice.
- **Base Case**: `dp[0][0] = 1` (1 way to get sum 0 with 0 dice).

Now, we need to calculate `dp[i][j]` for each `i` from `1` to `n` and `j` from `1` to `target`.

### Initialize the DP Table (n = 2, target = 7):

| i \ j       | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 |
| ----------- | - | - | - | - | - | - | - | - |
| **0** | 1 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |
| **1** | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |
| **2** | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |

### Step-by-Step Table Construction:

#### For i = 1 (1 dice):

We want to find out how to achieve sums from 1 to 7 using one dice (`k = 6` faces).

- For `j = 1`: We can only roll a `1`, so `dp[1][1] = 1`.
- For `j = 2`: We can roll a `2`, so `dp[1][2] = 1`.
- For `j = 3`: We can roll a `3`, so `dp[1][3] = 1`.
- ...
- For `j = 6`: We can roll a `6`, so `dp[1][6] = 1`.
- For `j = 7`: Impossible to roll a 7 with one dice, so `dp[1][7] = 0`.

**Updated Table after i = 1**:

| i \ j       | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 |
| ----------- | - | - | - | - | - | - | - | - |
| **0** | 1 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |
| **1** | 0 | 1 | 1 | 1 | 1 | 1 | 1 | 0 |
| **2** | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |

#### For i = 2 (2 dice):

Now, we calculate how to achieve sums from 1 to 7 using 2 dice.

- For `j = 1`: Impossible to get a sum of 1 with 2 dice, so `dp[2][1] = 0`.
- For `j = 2`: You can get 2 by rolling `1 + 1`, so `dp[2][2] = dp[1][1] = 1`.
- For `j = 3`: You can get 3 by `1 + 2` or `2 + 1`, so `dp[2][3] = dp[1][2] + dp[1][1] = 1 + 1 = 2`.
- For `j = 4`: You can get 4 by `1 + 3`, `2 + 2`, or `3 + 1`, so `dp[2][4] = dp[1][3] + dp[1][2] + dp[1][1] = 1 + 1 + 1 = 3`.
- For `j = 5`: You can get 5 by `1 + 4`, `2 + 3`, `3 + 2`, or `4 + 1`, so `dp[2][5] = dp[1][4] + dp[1][3] + dp[1][2] + dp[1][1] = 1 + 1 + 1 + 1 = 4`.
- For `j = 6`: You can get 6 by `1 + 5`, `2 + 4`, `3 + 3`, `4 + 2`, `5 + 1`, so `dp[2][6] = dp[1][5] + dp[1][4] + dp[1][3] + dp[1][2] + dp[1][1] = 1 + 1 + 1 + 1 + 1 = 5`.
- For `j = 7`: You can get 7 by `1 + 6`, `2 + 5`, `3 + 4`, `4 + 3`, `5 + 2`, `6 + 1`, so `dp[2][7] = dp[1][6] + dp[1][5] + dp[1][4] + dp[1][3] + dp[1][2] + dp[1][1] = 1 + 1 + 1 + 1 + 1 + 1 = 6`.

**Updated Table after i = 2**:

| i \ j       | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 |
| ----------- | - | - | - | - | - | - | - | - |
| **0** | 1 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |
| **1** | 0 | 1 | 1 | 1 | 1 | 1 | 1 | 0 |
| **2** | 0 | 0 | 1 | 2 | 3 | 4 | 5 | 6 |

### Explanation:

- **i = 0** row represents the base case: 1 way to get a sum of `0` with `0` dice.
- **i = 1** row represents the number of ways to get each sum from 1 to 7 with 1 dice.
- **i = 2** row represents the number of ways to get each sum from 1 to 7 with 2 dice.

### Conclusion:

For `n = 2`, `k = 6`, and `target = 7`, there are **6 ways** to achieve a sum of 7. These combinations are:

- `(1 + 6)`
- `(2 + 5)`
- `(3 + 4)`
- `(4 + 3)`
- `(5 + 2)`
- `(6 + 1)`

Thus, the final answer is `dp[2][7] = 6`.

This step-by-step process fills the DP table to find the number of ways to achieve any target sum using `n` dice.



The intuition behind the dynamic programming relation:

```
dp[i][j] = (dp[i][j] + dp[i - 1][j - x]) % MOD;
```

comes from breaking down the problem in terms of how we can roll dice to reach a target sum.

### Let's explain the intuition in steps:

### Problem Statement:

- You have `n` dice.
- Each dice has `k` faces numbered from 1 to `k`.
- You want to find the number of ways to roll the dice so that the sum of their face-up numbers equals a given target.

### Define `dp[i][j]`:

- `dp[i][j]` represents the number of ways to roll `i` dice to achieve a sum of `j`.

### Recurrence Relation:

#### Base Case:

- `dp[0][0] = 1`: There is exactly one way to get a sum of 0 with 0 dice (by rolling nothing).

#### Transition/Recursive Case:

- Now, to calculate `dp[i][j]`, which is the number of ways to get a sum of `j` using `i` dice, we think about how we can build this sum based on previous states.
- **Key Idea**: To get a sum of `j` with `i` dice, you could have rolled one of the dice to show some number `x` (where `x` is between `1` and `k`), and the remaining `i - 1` dice must give a sum of `j - x`.

### Why `dp[i][j] = dp[i - 1][j - x]`?

- `dp[i - 1][j - x]` tells us how many ways there are to achieve the sum `j - x` using `i - 1` dice.
- If we roll the `i`-th dice to show a value `x`, then we only need to ensure that the sum of the first `i - 1` dice equals `j - x`.
- Hence, for each value of `x` (ranging from `1` to `k`), we can add `dp[i - 1][j - x]` to `dp[i][j]`.

#### Example Walkthrough:

Consider a simple example where you have:

- `i = 2` dice,
- `k = 6` faces (1 to 6),
- Target `j = 7`.

To compute `dp[2][7]`:

- You want to know how many ways you can roll two dice such that their sum equals 7.
- Now, think of the last dice:
  - If the last dice rolls a 1, the first dice must sum to `7 - 1 = 6`. The number of ways to get a sum of 6 with one dice is `dp[1][6]`.
  - If the last dice rolls a 2, the first dice must sum to `7 - 2 = 5`. The number of ways to get a sum of 5 with one dice is `dp[1][5]`.
  - If the last dice rolls a 3, the first dice must sum to `7 - 3 = 4`. The number of ways to get a sum of 4 with one dice is `dp[1][4]`.
  - And so on, until the last dice rolls a 6.

So, we sum up all the possible ways:

```
dp[2][7] = dp[1][6] + dp[1][5] + dp[1][4] + dp[1][3] + dp[1][2] + dp[1][1].
```

This leads to the relation:

```
dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j - 2] + ... + dp[i - 1][j - k].
```

### Why the MOD Operation?

- Since the number of ways can become large, we take the result modulo `MOD` (usually `MOD = 10^9 + 7`) to avoid overflow and to comply with the problem's constraints.

Hence, we get the relation:

```
dp[i][j] = (dp[i][j] + dp[i - 1][j - x]) % MOD
```

where `x` ranges from `1` to `k` and `j - x >= 0`.
