/** Problem: Top K Frequent Words
 * Statement: Given an array of strings words and an integer k, return the k most frequent strings. 
 * Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.
 */

import java.util.*;

class PQ3{
    public class Pair {
        String word;
        int freq;

        Pair(String w, int f) {
            word = w;
            freq = f;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {

        List<String> ans = new ArrayList<>();

        HashMap<String, Integer> hm = new HashMap<>();

        // Frequency count
        for (String w : words) {
            hm.put(w, hm.getOrDefault(w, 0) + 1);
        }

        // Min Heap
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {

            if (a.freq != b.freq) {
                return a.freq - b.freq;
            }

            return b.word.compareTo(a.word);
        });

        // Put every word into heap
        for (String word : hm.keySet()) {

            Pair p = new Pair(word, hm.get(word));

            pq.add(p);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Get answer
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            ans.add(p.word);
        }

        Collections.reverse(ans);

        return ans;
    }

    public static void main(String[] args) {
        PQ3 obj = new PQ3();
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        List<String> result = obj.topKFrequent(words, k);
        System.out.print("Top " + k + " frequent words: ");
        for (String word : result) {
            System.out.print(word + " ");
        }
    }
}