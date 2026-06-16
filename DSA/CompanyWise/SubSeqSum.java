import java.util.*;

public class SubsequenceSumK {

  public static void subSequenceSum(
    ArrayList<ArrayList<Integer>> ans,
    int a[],
    ArrayList<Integer> temp,
    int k,
    int start
  ) {
    if (start > a.length || k < 0) return;

    if (k == 0) {
      ans.add(new ArrayList<Integer>(temp));
      return;
    } else {
      for (int i = start; i < a.length; i++) {
        temp.add(a[i]);

        subSequenceSum(ans, a, temp, k - a[i], i + 1);

        temp.remove(temp.size() - 1);
      }
    }
  }

  public static void main(String args[]) {
    int arr[] = { 5, 12, 3, 17, 1, 18, 15, 3, 17 };
    int k = 6;
    ArrayList<ArrayList<Integer>> ans;
    ans = new ArrayList<ArrayList<Integer>>();
    subSequenceSum(ans, arr, new ArrayList<Integer>(), k, 0);

    for (int i = 0; i < ans.size(); i++) {
      for (int j = 0; j < ans.get(i).size(); j++) {
        System.out.print(ans.get(i).get(j));
        System.out.print(" ");
      }
      System.out.println();
    }
  }
}
