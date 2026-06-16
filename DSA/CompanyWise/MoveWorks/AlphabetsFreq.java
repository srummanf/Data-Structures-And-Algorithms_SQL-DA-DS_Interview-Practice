/** 1. Decode Encoded String & Count Frequency

Problem Statement:
You are given a string that encodes alphabets using the following rules:

Numbers 1–9 represent letters a–i.

Numbers followed by # (e.g., 10# to 26#) represent letters j–z.

A pattern like X(Y) means the letter corresponding to digit X is repeated Y times.

After decoding the string, return the frequency of each character present in the decoded result.

Example:

Input: "12(3)420#2"  
Output:  
Decoded String: lllbd  
Character Frequency:  
l: 3  
b: 1  
d: 1


Intuition:
Work backwards from the string since patterns like 2(40) need look-ahead for repetition. Handle three cases:

Single digit → single character.

Two digits + # → alphabet 10–26.

(count) → expand repetition.

Finally, traverse decoded string to count frequencies.

Key Steps:

Parse from right to left to simplify handling # and () patterns.

Decode digits into letters accordingly.

Build the decoded string.

Traverse decoded string and count character frequencies using a map. */

import java.util.HashMap;
import java.util.Map;

public class AlphabetsFreq {
    // Function for decoding the string
    public static String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        int i = s.length() - 1;

        while (i >= 0) {
            if (s.charAt(i) == ')') {
                // Handle the pattern 2(40)
                int j = i - 1;
                while (s.charAt(j) != '(') j--;
                int repeatCount = Integer.parseInt(s.substring(j + 1, i));
                char ch = (char) ('a' + (s.charAt(j - 1) - '1'));
                result.append(String.valueOf(ch).repeat(Math.max(0, repeatCount)));
                i = j - 2;
            } else if (s.charAt(i) == '#') {
                // Handle the pattern 26#
                int num = Integer.parseInt(s.substring(i - 2, i));
                char ch = (char) ('a' + num - 1);
                result.append(ch);
                i -= 3;
            } else if (Character.isDigit(s.charAt(i))) {
                // Handle single digits
                char ch = (char) ('a' + (s.charAt(i) - '1'));
                result.append(ch);
                i--;
            } else {
                // Skip spaces or any other characters
                i--;
            }
        }

        // Reverse the result since we built it backwards
        return result.reverse().toString();
    }

    // Function for calculating the frequency
    public static Map<Character, Integer> countFrequency(String decoded) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : decoded.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        return freqMap;
    }

    public static void main(String[] args) {
        String input = "12(3)420#2";
        String decodedString = decodeString(input);
        System.out.println("Decoded String: " + decodedString);

        Map<Character, Integer> frequency = countFrequency(decodedString);

        System.out.println("Character Frequency:");
        for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
