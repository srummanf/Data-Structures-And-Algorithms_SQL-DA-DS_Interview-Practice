import java.sql.Array;
import java.util.*;

public class SortingInOneLine {

  public static void main(String[] args) {
    int arr2[] = { 1, 5, 2, 7, 4, 1, 2, 6 };
    ArrayList<Integer> al = new ArrayList<>();
    for (int i : arr2) {
      al.add(i);
    }
    Collections.sort(al);

    System.out.println(al);
    System.out.println(Arrays.toString(arr2));

    Arrays.sort(arr2);
    System.out.println(Arrays.toString(arr2));
  }
}
