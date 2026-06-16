// Day 3

// https://leetcode.com/problems/candy/


import java.util.*;

class Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int left[] = new int [n];
        int right[] = new int [n];
        int ans = 0;
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for(int i = 1; i<n;i++)
        {
            if(ratings[i]>ratings[i-1]){
                left[i] = left[i-1]+1; 
            }
        }
        for(int i = n-2; i>=0;i--)
        {
            if(ratings[i]>ratings[i+1]){
                right[i] = right[i+1]+1;
            }
        }
        for(int i=0;i<n;i++)
        {
            ans = ans + Math.max(right[i], left[i]);
        }

        return ans;
    }
}