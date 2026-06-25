/*
Intuition

A subarray is valid if the target appears more than half of its length.

Instead of counting the frequency of the target and non-target elements
separately for every subarray, transform the array as:

target     -> +1
non-target -> -1

Let:
T = number of target elements
Q = number of non-target elements

The majority condition is:

T > (T + Q) / 2

Multiplying both sides by 2:

2T > T + Q

Simplifying:

T > Q

After the transformation, the sum of a subarray becomes:

(+1 * T) + (-1 * Q)
= T - Q

Therefore,

T > Q
<=> T - Q > 0

Hence, a subarray is valid if and only if its transformed sum is positive.


Approach

1. Iterate over every possible starting index i.
2. Initialize a running variable count = 0.
3. Extend the subarray one element at a time using j.
4. For each element:
   - Add +1 if it equals target.
   - Otherwise add -1.
5. If count > 0, then the current subarray has more target elements
   than non-target elements, so increment the answer.
6. Return the final answer.

Since count always represents:

count = T - Q

checking count > 0 directly verifies whether the target is the majority
element in the current subarray.


Complexity

Time Complexity : O(n^2)
Space Complexity: O(1)
*/

class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = i; j < n; j++) {
                count += (nums[j] == target ? 1 : -1);

                if (count > 0)
                    ans++;
            }
        }

        return ans;
    }
}