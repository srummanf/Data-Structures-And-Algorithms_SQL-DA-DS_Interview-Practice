/** Given an array of numbers, you can select a number x to be replaced with another number y in the array. In one operation, all the instances of x have to replaced with y. Find the minimum number of operations needed to make the array palindrome. */

import java.util.*;

class MakeArrayPalindrome {

  public static int MakethegivenArrayPalindrome(int[] arr) {
    int count = 0;
    int i = 0;
    int j = arr.length - 1;

    while (i < j) {
      if (arr[i] != arr[j]) {
        // Increase the count of operations
        count++;

        // Make all arr[i] values equal to arr[j]
        int target = arr[j];
        int replace = arr[i];

        // Perform the replacement in the array
        for (int k = 0; k < arr.length; k++) {
          if (arr[k] == replace) {
            arr[k] = target;
          }
        }
      }
      i++;
      j--;
    }

    return count;
  }

  public static void main(String args[]) {
    // int[] arr = { 1, 2, 1, 2, 3, 1, 7 };
       int[] arr = { 1, 2, 1};

    System.out.println(MakethegivenArrayPalindrome(arr));
  }
}
