/** Given a string s, consider all duplicated substrings: (contiguous) substrings of s that occur 2 or more times. The occurrences may overlap.

Return any duplicated substring that has the longest possible length. If s does not have a duplicated substring, the answer is "".

 

Example 1:

Input: s = "banana"
Output: "ana"
Example 2:

Input: s = "abcd"
Output: ""
 

Constraints:

2 <= s.length <= 3 * 104
s consists of lowercase English letters. */


/** Using KMP Algo */
import java.util.HashSet;
import java.util.Set;

class Solution {
    // Provided pattern search function to find all occurrences of pat in str
    public static boolean Patternsearch(String str, String pat) {
        int M = pat.length();
        int N = str.length();
        int count = 0;

        for (int i = 0; i <= N - M; i++) {
            int j;
            for (j = 0; j < M; j++)
                if (str.charAt(i + j) != pat.charAt(j))
                    break;

            if (j == M) {
                count++;
                if (count > 1) {
                    return true;
                }
            }
        }

        return count > 1;
    }

    // Function to check if there is any duplicate substring of given length
    private int search(String s, int length) {
        int n = s.length();
        Set<String> set = new HashSet<>();

        for (int i = 0; i <= n - length; i++) {
            String substring = s.substring(i, i + length);
            if (set.contains(substring)) {
                return i;
            }
            set.add(substring);
        }

        return -1;
    }

    public String longestDupSubstring(String s) {
        int n = s.length();
        int left = 1, right = n - 1;
        int start = -1;
        int maxLength = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int pos = search(s, mid);
            if (pos != -1 && Patternsearch(s, s.substring(pos, pos + mid))) {
                start = pos;
                maxLength = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return start != -1 ? s.substring(start, start + maxLength) : "";
    }

}


/** Using RK Algo */
// import java.util.HashSet;
// import java.util.Set;

// public class Solution {
//     // Precomputed hashes and powers of the base
//     private long[] powers;
//     private long[] hashes;

//     // Finds the longest duplicate substring in a given string
//     public String longestDupSubstring(String s) {
//         int base = 131; // Base value for polynomial hash calculation
//         int n = s.length(); // Length of the input string
//         powers = new long[n + 10];
//         hashes = new long[n + 10];
//         powers[0] = 1;
      
//         // Precompute the powers and hashes
//         for (int i = 0; i < n; ++i) {
//             powers[i + 1] = powers[i] * base;
//             hashes[i + 1] = hashes[i] * base + s.charAt(i);
//         }
      
//         String longestDuplicate = ""; // Store the longest duplicate substring
//         int leftBound = 0, rightBound = n; // Define search bounds

//         // Perform binary search on substring length
//         while (leftBound < rightBound) {
//             int mid = (leftBound + rightBound + 1) >>> 1; // Middle point (length of substring)
//             String duplicate = checkForDuplicate(s, mid);
//             if (!duplicate.isEmpty()) {
//                 leftBound = mid; // If a duplicate is found, search in the upper half
//                 longestDuplicate = duplicate;
//             } else {
//                 rightBound = mid - 1; // Otherwise, search in the lower half
//             }
//         }
      
//         return longestDuplicate; // Return the longest duplicate substring found
//     }

//     // Checks for a duplicate substring of a given length
//     private String checkForDuplicate(String s, int len) {
//         int n = s.length();
//         Set<Long> seenHashes = new HashSet<>(); // Set to store previously encountered hashes

//         // Iterate over each possible substring of the given length
//         for (int i = 1; i + len - 1 <= n; ++i) {
//             int j = i + len - 1;
//             // Compute the hash for the current substring
//             long currentHash = hashes[j] - hashes[i - 1] * powers[j - i + 1];
//             if (seenHashes.contains(currentHash)) { 
//                 // If the hash is already in the set, we found a duplicate
//                 return s.substring(i - 1, j);
//             }
//             // Add the current hash to the set
//             seenHashes.add(currentHash);
//         }
//         // If no duplicate is found, return an empty string
//         return "";
//     }
// }

