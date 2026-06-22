class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int count = 0;

        while (true) {
            boolean possible = true;

            for (char ch : target.toCharArray()) {
                if (freq[ch - 'a'] == 0) {
                    possible = false;
                    break;
                }
                freq[ch - 'a']--;
            }

            if (!possible) {
                break;
            }

            count++;
        }

        return count;
    }
}