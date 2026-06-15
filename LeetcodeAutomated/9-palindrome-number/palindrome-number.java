class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        String original = String.valueOf(x);
        String reversed = new StringBuilder(original).reverse().toString();

        return original.equals(reversed);
    }
}