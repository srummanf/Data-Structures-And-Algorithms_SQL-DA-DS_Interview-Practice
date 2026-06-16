/** An Easy Variation of Aggressive cows was asked -- Can be done using 2 pointers */



/** You are given an array 'arr' consisting of 'n' integers which denote the position of a stall.



You are also given an integer 'k' which denotes the number of aggressive cows.



You are given the task of assigning stalls to 'k' cows such that the minimum distance between any two of them is the maximum possible.



Print the maximum possible minimum distance.



Example:
Input: 'n' = 3, 'k' = 2 and 'arr' = {1, 2, 3}

Output: 2

Explanation: The maximum possible minimum distance will be 2 when 2 cows are placed at positions {1, 3}. Here distance between cows is 2. */
import java.util.*;

public class Solution {
    public static boolean isPossible(int diff, int cows, int []stalls, int n){
        int ctr = 1;
        int lastPos = stalls[0];
        for(int i=1; i<n, i++){
            if(stalls[i]-lastPos>=diff){
                ctr++;
                lastPos = stalls[i];
                if(ctr==cows) return true;
            }
        }
        return false;
    }
    public static int aggressiveCows(int []stalls, int k) {
        //    Write your code here.
        Arrays.sort(stalls);
        int ans = Integer.MIN_VALUE;
        int n = stalls.length;
        int maxRange = stalls[n-1]-stalls[0];
        int l = 0;
        int r =  maxRange;
        while(l<=r){
            int diff = (l+r)/2;
            if(isPossible(diff, k, stalls, n)){
                ans = diff;
                l = diff+1;
            } else {
                r = diff-1;
            }
        }

        return ans;
    }
    public static int aggressiveCows_BinarySearch(int []stalls, int k) {
        //    Write your code here.
        Arrays.sort(stalls);
        int ans = Integer.MIN_VALUE;
        int n = stalls.length;
        int maxRange = stalls[n-1]-stalls[0];
        for(int diff=1; diff<=maxRange; diff++) {
            if(isPossible(diff, k, stalls, n)){
                ans = Math.max(ans, diff);
            }
        }
        return ans;
    }
}