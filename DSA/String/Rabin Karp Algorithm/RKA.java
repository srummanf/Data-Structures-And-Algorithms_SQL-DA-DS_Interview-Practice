public class RKA {

    // Function to calculate the hash value of a string
    private static int hash(String s, int prime, int modulus) {
        int hashValue = 0;
        for (int i = 0; i < s.length(); i++) {
            hashValue = (hashValue * prime + s.charAt(i)) % modulus;
        }
        return hashValue;
    }

    // Rabin-Karp algorithm to find all occurrences of the pattern in the text
    public static void search(String text, String pattern, int prime, int modulus) {
        int m = pattern.length();
        int n = text.length();

        int patternHash = hash(pattern, prime, modulus);
        int textHash = hash(text.substring(0, m), prime, modulus);

        for (int i = 0; i <= n - m; i++) {
            if (patternHash == textHash && text.substring(i, i + m).equals(pattern)) {
                System.out.println("Pattern found at index " + i);
            }

            if (i < n - m) {
                textHash = (prime * (textHash - text.charAt(i) * (int) Math.pow(prime, m - 1)) + text.charAt(i + m)) % modulus;

                if (textHash < 0) {
                    textHash += modulus;
                }
            }
        }
    }

    public static void main(String[] args) {
        String text = "abracadabra";
        String pattern = "abr";
        int prime = 101;  // A prime number
        int modulus = 1000000007;  // A large modulus to avoid overflow

        search(text, pattern, prime, modulus);
    }
}
