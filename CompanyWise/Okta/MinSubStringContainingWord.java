/** Problem Statement

Have the function MinWindowSubstring(strArr) take the array of strings stored in strArr, which will contain only two strings, the first parameter being the string N and the second parameter being a string K of some characters, and your goal is to determine the smallest substring of N that contains all the characters in K.


For example: if strArr is ["aaabaaddae", "aed"] then the smallest substring of N that contains the characters a, e, and d is "dae" located at the end of the string. So for this example, your program should return the string dae.


Another example: if strArr is ["aabdccdbcacd", "aad"] then the smallest substring of N that contains all of the characters in K is "aabd" which is located at the beginning of the string. Both parameters will be strings ranging in length from 1 to 100 characters and all of K's characters will exist somewhere in the string N. Both strings will only contain lowercase alphabetic characters.
Input format :

The first line contains the string N.

The second line contains the string K.
Output format :

The output prints the minimum window substring of N containing all characters of K.


Refer to the sample output for the formatting specifications.
Code constraints :

The length of strings N and K does not exceed 100 characters.

Strings N and K may contain lowercase letters.
Sample test cases :
Input 1 :

ahffaksfajeeubsne
jefaa

Output 1 :

aksfaje

Input 2 :

aaabaaddae
aed

Output 2 :

dae */

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {

    public static String minWindowSubstring(String[] strArr) {
        String N = strArr[0];
        String K = strArr[1];
        
        if (K.length() > N.length()) {
            return "";
        }

        Map<Character, Integer> dictK = new HashMap<>();
        for (char c : K.toCharArray()) {
            dictK.put(c, dictK.getOrDefault(c, 0) + 1);
        }

        int required = dictK.size();
        int formed = 0;

        Map<Character, Integer> windowCounts = new HashMap<>();
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int[] ans = {-1, 0, 0};

        while (right < N.length()) {
            char c = N.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            if (dictK.containsKey(c) && windowCounts.get(c).intValue() == dictK.get(c).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {
                c = N.charAt(left);

                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    ans[0] = left;
                    ans[1] = right;
                }

                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictK.containsKey(c) && windowCounts.get(c).intValue() < dictK.get(c).intValue()) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return ans[0] == -1 ? "" : N.substring(ans[0], ans[1] + 1);
    }

    public static void main(String[] args) {
        String[] strArr1 = {"ahffaksfajeeubsne", "jefaa"};
        String[] strArr2 = {"aaabaaddae", "aed"};

        System.out.println(minWindowSubstring(strArr1)); // Output: aksfaje
        System.out.println(minWindowSubstring(strArr2)); // Output: dae
    }
}


/** To solve the problem of finding the smallest substring in \( N \) that contains all characters from \( K \), we can use a sliding window approach with two pointers. Here is a step-by-step breakdown of the solution:

1. **Initialize Data Structures**: 
   - Use a dictionary to count characters in \( K \).
   - Use another dictionary to count characters in the current window of \( N \).

2. **Expand and Contract the Window**:
   - Expand the window by moving the right pointer to the right.
   - If the window contains all characters of \( K \) (with at least the same frequency), attempt to contract it from the left to find the minimum length.

3. **Track the Minimum Window**:
   - Keep track of the minimum window size and its position.

4. **Output the Result**:
   - Extract and return the substring corresponding to the minimum window size found.

Here is the Java code implementing the solution:

```java
import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {

    public static String minWindowSubstring(String[] strArr) {
        String N = strArr[0];
        String K = strArr[1];
        
        if (K.length() > N.length()) {
            return "";
        }

        Map<Character, Integer> dictK = new HashMap<>();
        for (char c : K.toCharArray()) {
            dictK.put(c, dictK.getOrDefault(c, 0) + 1);
        }

        int required = dictK.size();
        int formed = 0;

        Map<Character, Integer> windowCounts = new HashMap<>();
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int[] ans = {-1, 0, 0};

        while (right < N.length()) {
            char c = N.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            if (dictK.containsKey(c) && windowCounts.get(c).intValue() == dictK.get(c).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {
                c = N.charAt(left);

                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    ans[0] = left;
                    ans[1] = right;
                }

                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictK.containsKey(c) && windowCounts.get(c).intValue() < dictK.get(c).intValue()) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return ans[0] == -1 ? "" : N.substring(ans[0], ans[1] + 1);
    }

    public static void main(String[] args) {
        String[] strArr1 = {"ahffaksfajeeubsne", "jefaa"};
        String[] strArr2 = {"aaabaaddae", "aed"};

        System.out.println(minWindowSubstring(strArr1)); // Output: aksfaje
        System.out.println(minWindowSubstring(strArr2)); // Output: dae
    }
}
```

### Explanation of the Code

1. **Input Reading**:
   - Read the input strings \( N \) and \( K \) from the `strArr` array.

2. **Character Frequency Dictionary**:
   - Create a dictionary to store the frequency of each character in \( K \).

3. **Sliding Window**:
   - Use two pointers, `left` and `right`, to define the window in \( N \).
   - Expand the window by moving `right` and update character counts in the window.
   - When the window contains all characters of \( K \), try to minimize it by moving `left`.

4. **Update Minimum Window**:
   - Track the smallest window that satisfies the condition.

5. **Return Result**:
   - Extract the substring from \( N \) corresponding to the minimum window and return it.

This solution efficiently finds the minimum window substring using the sliding window technique and hashmaps to keep track of character frequencies, ensuring that the algorithm runs in linear time relative to the size of the input. */