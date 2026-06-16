import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseOfVowel {
    Set<Character> vowels = new HashSet<>(Arrays.asList(
            'a', 'e', 'i', 'o', 'u',
            'A', 'E', 'I', 'O', 'U'));

    // Swap helper for char array
    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public String reverseVowels(String s) {
        char[] charArray = s.toCharArray();
        int l = 0, r = charArray.length - 1;

        while (l < r) {
            if (!vowels.contains(charArray[l])) {
                l++;
            } else if (!vowels.contains(charArray[r])) {
                r--;
            } else {
                swap(charArray, l, r);
                l++;
                r--;
            }
        }

        return new String(charArray);
    }

    public static void main(String[] args) {
        ReverseOfVowel solution = new ReverseOfVowel();
        String s = "hello";
        System.out.println(solution.reverseVowels(s)); // Output: "holle"

        s = "leetcode";
        System.out.println(solution.reverseVowels(s)); // Output: "leotcede"
    }
}
