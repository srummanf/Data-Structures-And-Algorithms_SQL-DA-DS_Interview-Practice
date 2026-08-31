public class GetEqualSubStringWithinBudget {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int maxAns = 0;
        int curr = 0;
        int l = 0;
        for (int r = 0; r < n; r++) {
            curr += Math.abs(s.charAt(r) - t.charAt(r));
            while (curr > maxCost) {
                curr -= Math.abs(s.charAt(l) - t.charAt(l));
                l++;
            }
            maxAns = Math.max(maxAns, (r - l + 1));
        }
        return maxAns;
    }

    public static void main(String[] args) {
        GetEqualSubStringWithinBudget solution = new GetEqualSubStringWithinBudget();
        String s = "abcd";
        String t = "bcdf";
        int maxCost = 3;
        int result = solution.equalSubstring(s, t, maxCost);
        System.out.println("Maximum length of substring: " + result); // Output: 3
    }
}
