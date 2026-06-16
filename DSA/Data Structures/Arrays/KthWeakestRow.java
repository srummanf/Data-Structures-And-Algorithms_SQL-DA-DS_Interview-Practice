// Day 3

// https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/

import java.util.*;

class KthWeakestRow {
    public int[] kWeakestRows(int[][] mat, int k) {
        int rows = mat.length;
        int cols = mat[0].length;
        int n = rows;

        int counts[] = new int[rows];
        int pos[] = new int[rows];

        for(int i=0;i<rows;i++){
            pos[i] = i;
        }
        
        int c = 0;
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(mat[i][j] == 1)
                {
                    c++;
                }
            }
            counts[i] = c;
            c = 0;
        }

        for(int i=0; i<rows-1; i++)
        {
            for(int j=0; j<rows-1-i; j++)
            {
                if(counts[j]>counts[j+1]){
                    int temp = counts[j];
                    counts[j] = counts[j+1];
                    counts[j+1] = temp;

                    int temp2 = pos[j];
                    pos[j] = pos[j+1];
                    pos[j+1] = temp2;

                }
            }
        } 

        int ans[] = new int[k];
        for(int i=0;i<k;i++)
        {
            ans[i] = pos[i];
        }
        return ans;
    }

    public static void main(String[] args){}
}