import java.util.*;

public class MissingRepeating {

  public static int[] findMissingRepeatingNumbers(int[] a) {
    int n = a.length; // size of the array
    int repeating = -1, missing = -1;

    //Find the repeating and missing number:
    for (int i = 1; i <= n; i++) {
      //Count the occurrences: 
      int cnt = 0;
      for (int j = 0; j < n; j++) {
        if (a[j] == i) cnt++;
      }

      if (cnt == 2) repeating = i; else if (cnt == 0) missing = i;

      if (repeating != -1 && missing != -1) break;
    }
    int[] ans = { repeating, missing };
    return ans;
  }

  public static void main(String[] args) {
    int[] a = { 3, 1, 2, 5, 4, 6, 7, 5 };
    int[] ans = findMissingRepeatingNumbers(a);
    System.out.println(
      "The repeating and missing numbers are: {" + ans[0] + ", " + ans[1] + "}"
    );
  }
}
