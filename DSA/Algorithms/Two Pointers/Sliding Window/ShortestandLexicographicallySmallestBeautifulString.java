/** Problem: Find the shortest and lexicographically smallest beautiful substring of a binary string with exactly k ones. */


class ShortestandLexicographicallySmallestBeautifulString{
    public String shortestBeautifulSubstring(String s, int k) {

        int i = 0;
        int j = 0;
        int n = s.length();

        int countOnes = 0;
        String res = "";

        while (j < n) {

            // Add s[j] to the window
            if (s.charAt(j) == '1') {
                countOnes++;
            }

            // Too many ones -> shrink from left
            while (countOnes > k) {
                if (s.charAt(i) == '1') {
                    countOnes--;
                }
                i++;
            }

            // We have exactly k ones
            if (countOnes == k) {

                // Remove unnecessary leading zeroes
                while (s.charAt(i) == '0') {
                    i++;
                }

                String temp = s.substring(i, j + 1);

                // Update answer
                if (res.isEmpty()
                        || temp.length() < res.length()
                        || (temp.length() == res.length()
                            && temp.compareTo(res) < 0)) {

                    res = temp;
                }
            }

            j++;
        }

        return res;

    }

    public static void main(String[] args) {
        ShortestandLexicographicallySmallestBeautifulString solution = new ShortestandLexicographicallySmallestBeautifulString();
        String s = "1001010";
        int k = 2;
        String result = solution.shortestBeautifulSubstring(s, k);
        System.out.println("Shortest and lexicographically smallest beautiful substring: " + result);
    }
}