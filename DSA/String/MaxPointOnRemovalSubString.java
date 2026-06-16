/**You are given a string s and two integers x and y. You can perform two types of operations any number of times.

Remove substring "ab" and gain x points.
For example, when removing "ab" from "cabxbae" it becomes "cxbae".
Remove substring "ba" and gain y points.
For example, when removing "ba" from "cabxbae" it becomes "cabxe".
Return the maximum points you can gain after applying the above operations on s.

 

Example 1:

Input: s = "cdbcbbaaabab", x = 4, y = 5
Output: 19
Explanation:
- Remove the "ba" underlined in "cdbcbbaaabab". Now, s = "cdbcbbaaab" and 5 points are added to the score.
- Remove the "ab" underlined in "cdbcbbaaab". Now, s = "cdbcbbaa" and 4 points are added to the score.
- Remove the "ba" underlined in "cdbcbbaa". Now, s = "cdbcba" and 5 points are added to the score.
- Remove the "ba" underlined in "cdbcba". Now, s = "cdbc" and 5 points are added to the score.
Total score = 5 + 4 + 5 + 5 = 19.
Example 2:

Input: s = "aabbaaxybbaabb", x = 5, y = 4
Output: 20
 

Constraints:

1 <= s.length <= 105
1 <= x, y <= 104
s consists of lowercase English letters. */


class Solution {
    int points = 0;

    public int maximumGain(String s, int x, int y) {
        if (x >= y) {
            s = remove1(s, x);
            s = remove2(s, y);
        } else {
            s = remove2(s, y);
            s = remove1(s, x);
        }
        return points;
    }

    public String remove1(String s, int x) {
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        int index = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (index > 0 && c == 'b' && sb.charAt(index - 1) == 'a') {
                points += x;
                sb.deleteCharAt(index - 1);
                index--;
            } else {
                sb.append(c);
                index++;
            }
        }
        return sb.toString();
    }

    public String remove2(String s, int y) {
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        int index = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (index > 0 && c == 'a' && sb.charAt(index - 1) == 'b') {
                points += y;
                sb.deleteCharAt(index - 1);
                index--;
            } else {
                sb.append(c);
                index++;
            }
        }
        return sb.toString();
    }
}


/**
 * Here's the markdown (MD) version of the solution:

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
To maximize the points, we should prioritize removing the substrings that yield higher points. By strategically removing either "ab" or "ba" first, we can ensure that the total score is maximized.

# Approach
<!-- Describe your approach to solving the problem. -->
1. **Determine the Order of Operations**:
   - If the points for removing "ab" (`x`) are greater than or equal to the points for removing "ba" (`y`), prioritize removing "ab" first.
   - Otherwise, prioritize removing "ba" first.
2. **Helper Functions**:
   - `remove1`: Removes all possible "ab" substrings and adds `x` points for each removal.
   - `remove2`: Removes all possible "ba" substrings and adds `y` points for each removal.
3. **Execution**:
   - Use the helper functions in the determined order to maximize the points.

# Complexity
- Time complexity:
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
  - The time complexity is $$O(n)$$ because each character in the string is processed once in each helper function.

- Space complexity:
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
  - The space complexity is $$O(n)$$ due to the use of the `StringBuffer` to construct the modified string.


 */