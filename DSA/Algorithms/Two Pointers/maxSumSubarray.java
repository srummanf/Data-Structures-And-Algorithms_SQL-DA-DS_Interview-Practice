/**
 * example : [1, 2, 3, 4, 5, 6, 7, 8, 9] w = 3
 *           [{1, 2, 3}, 4, 5, 6, 7, 8, 9]
 *           [1, {2, 3, 4}, 5, 6, 7, 8, 9]
 */


import java.util.*;

public class maxSumSubarray {
     public static int findMax(int arr[], int w){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < w; i++){
            sum += arr[i];
        }
        max = sum;
        for(int i = w; i < arr.length; i++){
            sum += arr[i] - arr[i - w];
            max = Math.max(max, sum);
        }
        return max;
     }

    public static void main(String[] args) {
        System.out.println(findMax(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 3));
    }
}
