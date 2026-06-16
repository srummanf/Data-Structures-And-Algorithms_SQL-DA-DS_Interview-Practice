class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] rightA = new int[n + 1];
        
        // Calculate number of 'a's to the right of each position
        for (int i = n - 1; i >= 0; i--) {
            rightA[i] = rightA[i + 1] + (s.charAt(i) == 'a' ? 1 : 0);
        }

        int ans = Integer.MAX_VALUE;
        int countB = 0;

        // Calculate minimum deletions required
        for (int i = 0; i <= n; i++) {
            if (i > 0 && s.charAt(i - 1) == 'b') {
                countB++;
            }
            ans = Math.min(ans, countB + rightA[i]);
        }

        return ans;
    }
}
