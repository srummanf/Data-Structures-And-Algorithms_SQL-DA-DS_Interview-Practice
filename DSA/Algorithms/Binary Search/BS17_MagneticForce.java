
/** You are given an array 'position' of integers representing the positions of baskets and an integer 'balls' representing the number of balls to be placed in the baskets.
 *
 * You are also given an integer 'dist' representing the minimum distance between any two balls.
 *
 * You are required to place the balls in such a way that the minimum distance between any two balls is maximized.
 *
 * Return the maximum possible minimum distance. */
import java.util.Arrays;

class BS17_MagneticForce{
    public boolean canWePlace(int[] position, int balls, int dist) {
        int count = 1;
        int last_placed = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - last_placed >= dist) {
                count++;
                last_placed = position[i];
                if (count == balls)
                    return true;
            }
        }
        return false;

    }

    public int maxDistance(int[] position, int balls) {
        Arrays.sort(position);
        int l = 0;
        int r = position[position.length-1] - position[0];
        int ans = -1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(canWePlace(position, balls, mid)){
                ans = mid;
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }

        return ans;
        
    }

    public static void main(String[] args) {
        BS17_MagneticForce obj = new BS17_MagneticForce();
        int[] position = {1, 2, 3, 4, 7};
        int balls = 3;
        System.out.println("Maximum distance between balls: " + obj.maxDistance(position, balls));
    }
}