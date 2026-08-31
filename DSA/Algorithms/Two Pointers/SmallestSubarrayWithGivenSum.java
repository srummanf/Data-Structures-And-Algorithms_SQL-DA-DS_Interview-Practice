import java.util.*;

public class SmallestSubarrayWithGivenSum {

  public static int[] smallestSubarraySize(int arr[], int targetSum) {
    int windowStart = 0;
    int minWindowSize = Integer.MAX_VALUE;
    int sum = 0;
    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
      sum += arr[windowEnd];
      System.out.println(
        "Sum at windowStart " +
        windowStart +
        " and windowEnd " +
        windowEnd +
        " --- > " +
        sum
      );
      while (sum >= targetSum) {
        minWindowSize = Math.min(minWindowSize, windowEnd - windowStart + 1);
        
        sum -= arr[windowStart];
        windowStart++;
      }
    }
    return new int[] { minWindowSize, sum };
  }

  public static void main(String[] args) {
    int[] target = new int[] { 4, 2, 2, 7, 1, 2, 10 };
    int sum = 8;
    System.out.println(Arrays.toString(smallestSubarraySize(target, sum)));
  }
}
