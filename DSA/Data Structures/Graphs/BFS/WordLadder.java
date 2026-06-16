/** A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long. */

class Solution {
    class Pair {
        String s;
        int val;

        Pair(String s, int val) {
            this.s = s;
            this.val = val;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        Queue<Pair> q = new LinkedList<>();
        HashSet<String> hash = new HashSet<>(wordList); // Use a set for quick lookup
        
        if (!hash.contains(endWord)) {
            return 0; // If endWord is not in the wordList, return 0
        }
        
        q.add(new Pair(beginWord, 1)); // Start with the first word with a count of 1
        hash.remove(beginWord); // Remove the beginWord from the set to avoid revisiting
        
        while (!q.isEmpty()) {
            Pair p = q.poll();
            String word = p.s;
            int count = p.val;
            
            // Generate all possible transformations
            for (int i = 0; i < word.length(); i++) {
                char[] wordArray = word.toCharArray(); // Convert to char array to modify specific index
                
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (wordArray[i] == ch) continue; // Skip if the character is the same
                    
                    wordArray[i] = ch; // Change one character at index i
                    String newword = new String(wordArray);
                    
                    // Check if the transformed word is in the set
                    if (hash.contains(newword)) {
                        if (newword.equals(endWord)) {
                            return count + 1; // Return the count + 1 if we reach the endWord
                        }
                        
                        q.offer(new Pair(newword, count + 1)); // Add the new word to the queue
                        hash.remove(newword); // Remove it from the set to avoid revisiting
                    }
                }
            }
        }

        return 0; // If there's no valid transformation sequence
    }
}
