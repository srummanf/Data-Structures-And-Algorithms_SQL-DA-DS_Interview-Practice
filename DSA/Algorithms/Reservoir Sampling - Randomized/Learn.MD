# Reservoir Sampling - Randomly Selecting K values from total N values

```
import java.util.Random;

public class ReservoirSampling {
    private int[] nums;
    private Random rand;

    public ReservoirSampling(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }

    public int[] sample(int k) {
        int[] reservoir = new int[k];
        int n = nums.length;

        // Fill the reservoir array
        for (int i = 0; i < k; i++) {
            reservoir[i] = nums[i];
        }

        // Replace elements with gradually decreasing probability
        for (int i = k; i < n; i++) {
            int j = rand.nextInt(i + 1);
            if (j < k) {
                reservoir[j] = nums[i];
            }
        }

        return reservoir;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ReservoirSampling rs = new ReservoirSampling(nums);
        int[] sample = rs.sample(5);
        for (int num : sample) {
            System.out.print(num + " ");
        }
    }
}

```


# Concept of Reservoir Sampling

Reservoir sampling is a technique to randomly select `k` items from a list of `n` items, where `n` might be very large or unknown. In our specific problem, we need to randomly select one index from a list of indices where the target value occurs.

### Simplified Explanation

Imagine you have a bag and you want to pick one random number out of several numbers that you read one by one:

1. **Start with an empty bag**: At the beginning, the bag is empty.
2. **First Item**: When you see the first item (index of the target number), you put it in the bag.
3. **Next Items**: For every subsequent item:

   - You decide whether to replace the item in the bag with the new item.
   - The probability of replacing the item decreases as you see more items.

### Step-by-Step Example

Let's say you have an array `[1, 2, 3, 3, 3]` and you want to randomly pick an index of the number `3`.

1. **Initialization**: Start with a count of `0` and a result of `-1` (representing no index found yet).
2. **First 3 (at index 2)**:

   - Count is `1`.
   - The probability of picking this is `1/1 = 100%`.
   - So, you set `result` to `2`.
3. **Second 3 (at index 3)**:

   - Count is `2`.
   - The probability of picking this is `1/2 = 50%`.
   - Randomly decide whether to pick this index. If yes, set `result` to `3`.
4. **Third 3 (at index 4)**:

   - Count is `3`.
   - The probability of picking this is `1/3 ≈ 33.3%`.
   - Randomly decide whether to pick this index. If yes, set `result` to `4`.

By the end of the process, each index where `3` occurs has an equal probability of being selected.

### Implementing This in Code

Here's how you can implement this:

```java
import java.util.Random;

class Solution {
    private int[] nums;
    private Random rand;

    public Solution(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }

    public int pick(int target) {
        int count = 0;  // To count occurrences of target
        int result = -1;  // To store the index of the chosen occurrence
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;  // Increment count for each occurrence of target
                // Randomly replace the result with the current index
                if (rand.nextInt(count) == 0) {
                    result = i;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1, 2, 3, 3, 3});
        System.out.println(solution.pick(3)); // Should return 2, 3, or 4 randomly
        System.out.println(solution.pick(1)); // Should return 0
        System.out.println(solution.pick(3)); // Should return 2, 3, or 4 randomly
    }
}
```

### Summary

- **Count the occurrences**: As you go through the array, keep track of how many times the target has been seen.
- **Replace with decreasing probability**: Each time you see the target, decide whether to replace the previously picked index with the current one, based on a probability that ensures all indices are equally likely to be picked.

Reservoir sampling is an efficient way to ensure each index where the target occurs is equally likely to be picked.

# Purpose of `(rand.nextInt(count) == 0)`

The line `if (rand.nextInt(count) == 0)` is a crucial part of the reservoir sampling algorithm. Here’s what it does:

### Purpose

This line decides whether to update the `result` variable with the current index. It ensures that each index where the target value occurs has an equal probability of being selected.

### How It Works

1. **Generate a Random Integer**:

   - `rand.nextInt(count)` generates a random integer between `0` and `count-1` (inclusive).
   - `count` is the number of occurrences of the target value seen so far.
2. **Check Probability**:

   - By checking if `rand.nextInt(count) == 0`, you are essentially asking, "What is the probability of this specific condition being true?"
   - Since `rand.nextInt(count)` produces a uniform random integer, each number from `0` to `count-1` has an equal chance of being chosen.
   - The probability of getting `0` from `rand.nextInt(count)` is `1 / count`.
3. **Update Result**:

   - If `rand.nextInt(count) == 0` evaluates to true, it means that the current index should replace the previously stored index in `result`.
   - This ensures that each index seen so far has an equal probability of being the final picked index, as the probability of replacing the result decreases with each new occurrence.

### Why It Works

- **Reservoir Sampling Principle**: The algorithm works by maintaining a "reservoir" of the current best choice, updated with a decreasing probability as more items are processed.
- **Equal Probability**: By updating the result based on a random choice where each previous item had a `1 / count` chance of being picked, we ensure that each index has an equal probability of being selected.

### Example

Suppose you have 3 occurrences of the target and are processing the third one:

- `count` is `3`.
- `rand.nextInt(3)` generates a random number between `0` and `2`.
- The probability of getting `0` is `1 / 3` (about 33.3%).
- If the generated number is `0`, the current index replaces the previous `result`.

This line ensures that, after processing all occurrences of the target, each index where the target appears is equally likely to be the result, fulfilling the requirement of reservoir sampling.
