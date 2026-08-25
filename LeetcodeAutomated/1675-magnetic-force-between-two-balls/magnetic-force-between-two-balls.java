class Solution {
    public boolean canWePlace(int[] position, int m, int dist) {
        int count = 1;
        int last_placed = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - last_placed >= dist) {
                count++;
                last_placed = position[i];
                if (count == m)
                    return true;
            }
        }
        return false;

    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int l = 0;
        int r = position[position.length-1] - position[0];
        int ans = -1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(canWePlace(position, m, mid)){
                ans = mid;
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }

        return ans;
        
    }
}