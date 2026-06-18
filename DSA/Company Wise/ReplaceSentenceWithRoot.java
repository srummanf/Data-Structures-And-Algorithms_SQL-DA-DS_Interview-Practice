/**
 * In English, we have a concept called root, which can be followed by some other word to form another longer word - let's call this word derivative. For example, when the root "help" is followed by the word "ful", we can form a derivative "helpful".

Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces, replace all the derivatives in the sentence with the root forming it. If a derivative can be replaced by more than one root, replace it with the root that has the shortest length.

Return the sentence after the replacement.

 

Example 1:

Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"
 */


import java.util.*;  

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        HashSet<String> h = new HashSet<>();
        for (String w : dictionary) {
            h.add(w);
        }
        String ans = "";
        int flag = 0;
        StringTokenizer st = new StringTokenizer(sentence, " ");
        while (st.hasMoreTokens()) {
            String temp = "";
            String word = st.nextToken();
            
            for (int i = 0; i < word.length(); i++) {
                String sub = word.substring(0, i + 1);
                if (h.contains(sub)) {
                    ans = ans + sub;
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                ans = ans + word;
            }
            ans=ans+ " ";
            flag=0;
        }

        return ans.trim();

    }
}


/**
import java.util.*;

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        // Convert the dictionary list to a set for faster lookup
        Set<String> dictSet = new HashSet<>(dictionary);
        
        // Split the sentence into words
        String[] words = sentence.split(" ");
        
        // StringBuilder to construct the result sentence
        StringBuilder result = new StringBuilder();
        
        // Iterate over each word in the sentence
        for (String word : words) {
            String replacement = word; // Default to the word itself
            // Check each prefix of the word
            for (int i = 1; i <= word.length(); i++) {
                String prefix = word.substring(0, i);
                if (dictSet.contains(prefix)) {
                    replacement = prefix;
                    break;
                }
            }
            // Append the replacement to the result
            result.append(replacement).append(" ");
        }
        
        // Remove the trailing space and return the result
        return result.toString().trim();
    }
}
 */