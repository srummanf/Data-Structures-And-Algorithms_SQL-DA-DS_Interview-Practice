/** Problem Statement


Given an array of string words, return all strings in words that are a substring of another word. You can return the answer in any order.


A substring is a contiguous sequence of characters within a string.

                                                                                  

Example 1:


Input: words = ["mass","as","hero","superhero"]

Output: ["as","hero"]

Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".

["hero","as"] is also a valid answer.


Example 2:


Input: words = ["leetcode","et","code"]

Output: ["et","code"]

Explanation: "et", "code" are substring of "leetcode".


Example 3:

Input: words = ["blue","green","bu"]

Output: []

Explanation: No string of words is substring of another string.                                                                                                                            */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public List<String> stringMatching(List<String> words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            for (String other : words) {
                if (other.contains(word) && !word.equals(other)) {
                    result.add(word);
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        scanner.close();

        // Split the input line into words
        List<String> words = Arrays.asList(inputLine.split("\\s+"));

        // Create Solution instance and get the result
        Solution solution = new Solution();
        List<String> result = solution.stringMatching(words);

        // Print the result in the specified format
        System.out.print("[");
        for (int i = 0; i < result.size(); i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print("'" + result.get(i) + "'");
        }
        System.out.println("]");
    }
}
