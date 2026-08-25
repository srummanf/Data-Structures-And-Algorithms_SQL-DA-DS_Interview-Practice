class Solution {

    class Pair {
        int freq;
        char ch;

        Pair(int freq, char ch) {
            this.freq = freq;
            this.ch = ch;
        }
    }

    public String reorganizeString(String s) {

        int n = s.length();

        // Count frequency of each character
        int[] count = new int[26];

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;

            // Impossible to reorganize
            if (count[ch - 'a'] > (n + 1) / 2) {
                return "";
            }
        }

        // Max Heap
        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> b.freq - a.freq);

        // Add characters to heap
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (count[ch - 'a'] > 0) {
                pq.add(new Pair(count[ch - 'a'], ch));
            }
        }

        StringBuilder result = new StringBuilder();

        // Take two most frequent characters
        while (pq.size() >= 2) {

            Pair p1 = pq.poll();
            Pair p2 = pq.poll();

            result.append(p1.ch);
            result.append(p2.ch);

            p1.freq--;
            p2.freq--;

            if (p1.freq > 0) {
                pq.add(p1);
            }

            if (p2.freq > 0) {
                pq.add(p2);
            }
        }

        // If one character remains
        if (!pq.isEmpty()) {
            result.append(pq.poll().ch);
        }

        return result.toString();
    }
}