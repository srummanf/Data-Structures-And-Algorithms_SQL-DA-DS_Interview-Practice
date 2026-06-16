import java.util.HashMap;

public class AnagramPalindromeChecker {

    public static boolean canFormPalindrome(String input) {
        // Map to store frequency of characters
        HashMap<Character, Integer> charCount = new HashMap<>();

        // Count the frequency of each character
        for (char c : input.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Count how many characters have odd occurrences
        int oddCount = 0;
        for (int count : charCount.values()) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }

        // At most one character with an odd frequency is allowed for a palindrome
        return oddCount <= 1;
    }

    public static void main(String[] args) {
        String input = "civic";
        if (canFormPalindrome(input)) {
            System.out.println("Yes, an anagram can be a palindrome.");
        } else {
            System.out.println("No, an anagram cannot be a palindrome.");
        }
    }
}
