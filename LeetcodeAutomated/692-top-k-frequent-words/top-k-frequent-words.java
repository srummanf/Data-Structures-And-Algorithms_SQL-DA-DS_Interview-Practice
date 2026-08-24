class Solution {

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
}