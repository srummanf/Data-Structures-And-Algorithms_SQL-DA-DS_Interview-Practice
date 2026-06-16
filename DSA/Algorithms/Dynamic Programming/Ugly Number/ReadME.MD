### What is an Ugly Number?

An **Ugly Number** is a positive integer whose prime factors are limited to `2`, `3`, and `5`. In other words, any ugly number can be expressed in the form:

```
Ugly Number = 2^a * 3^b * 5^c
```

Where `a`, `b`, and `c` are non-negative integers.

The first few ugly numbers are: `1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, 16...`

The number `1` is often considered an ugly number by convention.

### Use Case of Ugly Numbers

Ugly numbers are primarily used in:

1. **Optimization problems**: They help solve problems where combinations of specific factors (2, 3, 5) are involved, ensuring that only valid numbers are generated.
2. **Game theory and mathematics**: They are useful in combinatorics and dynamic programming where factorization and prime decomposition problems arise.
3. **Computer graphics and procedural generation**: In certain algorithms that deal with large sequences of numbers that follow specific patterns.

### 10 LeetCode Problems Related to Ugly Numbers (Direct or Indirect)

1. **[LeetCode 263 - Ugly Number](https://leetcode.com/problems/ugly-number/)**

   - _Determine whether a given number is an ugly number or not._
   - **Concepts**: Prime factorization, math.
2. **[LeetCode 264 - Ugly Number II](https://leetcode.com/problems/ugly-number-ii/)**

   - _Find the `nth` ugly number, which has prime factors limited to 2, 3, and 5._
   - **Concepts**: Dynamic programming, heap.
3. **[LeetCode 313 - Super Ugly Number](https://leetcode.com/problems/super-ugly-number/)**

   - _Find the `nth` super ugly number, where the prime factors are from a given list of primes._
   - **Concepts**: Dynamic programming, multiple pointers.
4. **[LeetCode 1201 - Ugly Number III](https://leetcode.com/problems/ugly-number-iii/)**

   - _Find the `nth` ugly number that is divisible by at least one of the integers `a`, `b`, or `c`._
   - **Concepts**: Number theory, binary search, LCM (least common multiple).
5. **[LeetCode 264 (Variant) - Generalized Ugly Number](https://leetcode.com/problems/ugly-number-ii/)**

   - _Given a number `n`, find the nth ugly number where the prime factors can include more than 2, 3, and 5._
   - **Concepts**: Dynamic programming, general factorization.
6. **[LeetCode 878 - Nth Magical Number](https://leetcode.com/problems/nth-magical-number/)**

   - _Find the `nth` magical number divisible by `a` or `b`._
   - **Concepts**: Binary search, number theory, LCM.
7. **[LeetCode 1405 - Longest Happy String](https://leetcode.com/problems/longest-happy-string/)**

   - _Generate the longest string that can be made using `a`, `b`, and `c`, such that no adjacent characters are the same._
   - **Concepts**: Greedy + DP, optimal sequence generation.
8. **[LeetCode 517 - Super Washing Machines](https://leetcode.com/problems/super-washing-machines/)**

   - _Distribute clothes evenly across multiple washing machines._
   - **Concepts**: Greedy, DP (indirect relation via combinatorics).
9. **[LeetCode 949 - Largest Time for Given Digits](https://leetcode.com/problems/largest-time-for-given-digits/)**

   - _Find the largest possible time (HH:MM) that can be formed from four given digits._
   - **Concepts**: Permutation, factor combination (inspired by subset generation).
10. **[LeetCode 667 - Beautiful Arrangement II](https://leetcode.com/problems/beautiful-arrangement-ii/)**

    - _Construct an array where differences between adjacent elements are distinct._
    - **Concepts**: Greedy, combinatorics (related to patterns).

These problems cover various applications of dynamic programming, prime factorization, combinatorics, and number theory. The ugly number concept can extend to problems where specific factors or constraints must be respected, making it a valuable tool in algorithm design.
