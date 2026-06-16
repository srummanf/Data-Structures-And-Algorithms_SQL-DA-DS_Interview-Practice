import java.util.*;

class SubsetSum {

  void recsum(
    int ind,
    int sum,
    ArrayList<Integer> val,
    int n,
    ArrayList<Integer> ans
  ) {
    if (ind == n) {
      ans.add(sum);
      return;
    }
    recsum(ind + 1, sum + val.get(ind), val, n, ans);
    recsum(ind + 1, sum, val, n, ans);
  }

  ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
    ArrayList<Integer> ans = new ArrayList<>();

    recsum(0, 0, arr, N, ans);

    return ans;
  }

  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(2);
    arr.add(3);
    arr.add(4);
    int N = 3;
    SubsetSum obj = new SubsetSum();
    ArrayList<Integer> ans = obj.subsetSums(arr, N);
    Collections.sort(ans);
    for (int i = 0; i < ans.size(); i++) {
      System.out.print(ans.get(i) + " ");
      System.out.println();
    }
  }
}
