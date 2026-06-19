class Solution {
    public int largestAltitude(int[] gain) {
        int ans = 0;
        int diff = 0;
        for(int i : gain){
            diff = diff + i;
            ans = Math.max(ans, diff);
        }


        return ans;
    }
}