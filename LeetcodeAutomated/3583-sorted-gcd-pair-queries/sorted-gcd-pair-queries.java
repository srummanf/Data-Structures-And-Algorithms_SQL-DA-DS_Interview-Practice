class Solution {

    public int[] gcdValues(int[] nums, long[] queries) {

        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        int[] freq = new int[max + 1];
        for (int x : nums) freq[x]++;

        long[] gcdCount = new long[max + 1];

        // Count pairs having exact gcd = g
        for (int g = max; g >= 1; g--) {

            int divisible = 0;

            for (int multiple = g; multiple <= max; multiple += g) {
                divisible += freq[multiple];
                gcdCount[g] -= gcdCount[multiple];
            }

            gcdCount[g] += 1L * divisible * (divisible - 1) / 2;
        }

        // Prefix sum
        for (int i = 2; i <= max; i++)
            gcdCount[i] += gcdCount[i - 1];

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = 1, r = max;

            while (l < r) {
                int mid = (l + r) / 2;

                if (gcdCount[mid] > queries[i])
                    r = mid;
                else
                    l = mid + 1;
            }

            ans[i] = l;
        }

        return ans;
    }
}