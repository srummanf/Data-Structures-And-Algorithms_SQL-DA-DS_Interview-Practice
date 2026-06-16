### Digit Dynamic Programming (Digit DP)

#### **What is Digit DP?**

Digit DP is a specialized dynamic programming technique used to solve problems where you need to count numbers or find a specific number-related result within a certain range that satisfy certain conditions. The "digit" aspect of the technique involves breaking down the problem into the digits of the numbers involved, and "DP" refers to storing intermediate results to avoid redundant calculations.

#### Study Material :[ Digit DP Youtube Playlist by Aman Babu](https://www.youtube.com/playlist?list=PLps5s7uQvz8kSh36EwW4_o1Qqjfm2vA1r)

#### **Key Concepts of Digit DP:**

1. **State Representation:**

   - **Index (`pos`)**: Represents the current digit position in the number.
   - **Tight (`tight`)**: Indicates whether the current number being formed is still tightly bound by the upper limit (or lower limit).
   - **Other States**: Additional states might be required based on the problem. For example, `sum` to keep track of the sum of digits, `leadingZero` to handle leading zeros, or `evenCount` to track the count of even digits.
2. **Transition:**

   - The transition involves choosing the digit at the current position (`pos`) and updating the DP states accordingly.
3. **Base Case:**

   - Usually when `pos` reaches the end of the number, a valid number is formed, and the function returns a value (often `1` for counting or `0` for no valid numbers).
4. **Memoization:**

   - To avoid recalculating results for the same state, results are stored in a memoization table (often a 3D array, but this depends on the number of states).

#### **Steps to Solve a Digit DP Problem:**

1. **Define the States**: Identify the states required to describe the problem (e.g., current position, tight constraint, sum of digits).
2. **Recursive Function**: Write a recursive function that transitions through the states by choosing digits.
3. **Handle Tight Constraint**: Manage the tight condition that restricts digit selection based on the current digit of the number.
4. **Memoization**: Store results of subproblems to reuse them in future calculations.
5. **Base Case**: Define what happens when you reach the last digit.
6. **Final Answer**: Consider all the possibilities and sum them up for the final answer.

#### **Pseudo Code for Digit DP**

```pseudo
function digitDP(pos, tight, other_states):
    if pos == length_of_number:
        return base_case_value
  
    if memo[pos][tight][other_states] is not -1:
        return memo[pos][tight][other_states]
  
    limit = 9 if tight == 0 else digit_at_pos(pos)
  
    result = 0
  
    for digit in range(0, limit + 1):
        new_tight = tight & (digit == digit_at_pos(pos))
        new_other_states = update_based_on_digit(other_states, digit)
      
        result += digitDP(pos + 1, new_tight, new_other_states)
  
    memo[pos][tight][other_states] = result
    return result
```

#### **Template Code in Java**

Here's a Java template for a basic Digit DP problem (e.g., counting numbers with certain properties in a range):

```java
import java.util.Arrays;

public class DigitDP {
  
    int[][][] memo; // Memoization table

    // Helper function to initialize memoization and start DP
    public int solve(String num) {
        int n = num.length();
        memo = new int[n][2][/* other states dimensions */];
        for (int[][] rows : memo)
            for (int[] row : rows)
                Arrays.fill(row, -1);
      
        return dp(0, 1, /* initial other states */, num);
    }

    // Digit DP function
    public int dp(int pos, int tight, /* other states */, String num) {
        if (pos == num.length()) {
            return /* base case value */;
        }

        if (memo[pos][tight][/* other states indices */] != -1) {
            return memo[pos][tight][/* other states indices */];
        }

        int limit = tight == 1 ? num.charAt(pos) - '0' : 9;
        int result = 0;

        for (int digit = 0; digit <= limit; digit++) {
            int newTight = tight == 1 && digit == limit ? 1 : 0;
            // Update other states based on the digit
            int newOtherStates = /* update other states */;
          
            result += dp(pos + 1, newTight, newOtherStates, num);
        }

        return memo[pos][tight][/* other states indices */] = result;
    }

    public static void main(String[] args) {
        DigitDP digitDP = new DigitDP();
        String number = "123"; // Example number
        int result = digitDP.solve(number);
        System.out.println("Result: " + result);
    }
}
```

#### **Suggested LeetCode Problems on Digit DP:**

1. [Numbers With Same Consecutive Differences (LeetCode 967)](https://leetcode.com/problems/numbers-with-same-consecutive-differences/)
2. [Count Stepping Numbers in Range (LeetCode 1216)](https://leetcode.com/problems/count-stepping-numbers-in-range/)
3. [Maximum Number of Non-Overlapping Subarrays with Sum Equals Target (LeetCode 1546)](https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/)
4. [Digit Count in Range (LeetCode 1067)](https://leetcode.com/problems/digit-count-in-range/)
5. [Strobogrammatic Number II (LeetCode 247)](https://leetcode.com/problems/strobogrammatic-number-ii/)
6. [Strobogrammatic Number III (LeetCode 248)](https://leetcode.com/problems/strobogrammatic-number-iii/)
7. [Number of Valid Words in Sentence (LeetCode 2047)](https://leetcode.com/problems/number-of-valid-words-in-a-sentence/)
8. [Sum of Digits in Base K (LeetCode 1837)](https://leetcode.com/problems/sum-of-digits-in-base-k/)
9. [Count Numbers with Unique Digits (LeetCode 357)](https://leetcode.com/problems/count-numbers-with-unique-digits/)
10. [Confusing Number II (LeetCode 1088)](https://leetcode.com/problems/confusing-number-ii/)

These problems provide a range of challenges that help solidify your understanding of Digit DP by applying it to different constraints and scenarios.


# The concept of `solve(r) - solve(l-1)`

The technique of using `solve(r) - solve(l-1)` is common in Digit DP problems when you need to count or evaluate properties of numbers within a specific range \([l, r]\). Here's a detailed explanation:

### **Understanding `solve(r) - solve(l-1)` in Digit DP**

#### **1. The Problem Context:**

In many problems, you're asked to count or compute something over all numbers between two bounds, \(l\) and \(r\). For example, you might be asked to count how many numbers in the range \([l, r]\) satisfy a certain property (e.g., sum of digits equals a particular value, or the number contains a specific digit).

#### **2. Why Use `solve(r) - solve(l-1)`?**

- **`solve(r)`**: This function calculates the desired property (like counting the valid numbers) from \(0\) to \(r\).
- **`solve(l-1)`**: This function calculates the same property from \(0\) to \(l-1\).

The difference `solve(r) - solve(l-1)` gives you the result for the range \([l, r]\) because:

- `solve(r)` gives you the total count or value from \(0\) to \(r\).
- `solve(l-1)` gives you the total count or value from \(0\) to \(l-1\).

Subtracting these two results removes the part that falls below \(l\), effectively isolating the result for the range \([l, r]\).

### **How `solve` Works in Digit DP:**

The `solve` function typically uses Digit DP to compute the result from \(0\) to the given number. The Digit DP approach will:

1. Break down the problem into smaller subproblems based on the digits of the number.
2. Utilize states to represent the progress, such as the current digit position, whether the number is still "tight" (i.e., matches the prefix of the original number), and other properties.
3. Aggregate results across all digits to compute the final count or value.

### **Example Problem: Counting Numbers with a Specific Digit Sum**

Let's assume a problem where you want to count how many numbers between \(l\) and \(r\) have a digit sum of exactly \(S\).

#### **Steps:**

1. **Define the `solve(n)` function:**

   - This function will count how many numbers from \(0\) to \(n\) have a digit sum of exactly \(S\) using Digit DP.
2. **Use `solve(r) - solve(l-1)`:**

   - This will give you the count of numbers in the range \([l, r]\) with the required property.

#### **Pseudo Code for `solve(n)`**

```pseudo
function solve(n):
    digits = extract_digits(n)
    return digitDP(pos=0, tight=1, current_sum=0, digits)
```

```pseudo
function digitDP(pos, tight, current_sum, digits):
    if pos == length_of_digits:
        return 1 if current_sum == target_sum else 0
  
    if memo[pos][tight][current_sum] is not -1:
        return memo[pos][tight][current_sum]
  
    limit = digits[pos] if tight else 9
    result = 0
  
    for digit in range(0, limit + 1):
        new_tight = tight & (digit == limit)
        new_sum = current_sum + digit
      
        result += digitDP(pos + 1, new_tight, new_sum, digits)
  
    memo[pos][tight][current_sum] = result
    return result
```

### **Example in Java: Counting Numbers with Digit Sum Equal to S**

```java
public class DigitDPExample {
    int[][][] memo;
    int targetSum;

    public int solve(String num, int targetSum) {
        this.targetSum = targetSum;
        int n = num.length();
        memo = new int[n][2][targetSum + 1];
        for (int[][] rows : memo)
            for (int[] row : rows)
                Arrays.fill(row, -1);
    
        return dp(0, 1, 0, num);
    }

    public int dp(int pos, int tight, int
```
