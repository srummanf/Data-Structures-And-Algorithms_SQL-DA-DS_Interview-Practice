import java.util.*;

public class PrintingSubSequencesWhoseSumIsK {

  void printSum(
    ArrayList<Integer> al,
    int n,
    int k,
    ArrayList<Integer> length
  ) {
    ArrayList<Integer> al2 = new ArrayList<>();

    int ind = 0;

    printSumUtil(al, n, k, al2, ind, length);
  }

  void printSumUtil(
    ArrayList<Integer> al,
    int n,
    int k,
    ArrayList<Integer> al2,
    int ind,
    ArrayList<Integer> length
  ) {
    if (ind == n) {
      int sum = 0;
      for (int i : al2) {
        sum += i;
      }
      if (sum == k) {
        for (int i : al2) {
          length.add(al2.size());
          System.out.print(i + " ");
        }
        System.out.println();
      }
      return;
    }
    al2.add(al.get(ind));
    printSumUtil(al, n, k, al2, ind + 1, length);
    al2.remove(al2.size() - 1);
    printSumUtil(al, n, k, al2, ind + 1, length);
  }

  public static void main(String[] args) {
    PrintingSubSequencesWhoseSumIsK p = new PrintingSubSequencesWhoseSumIsK();

    ArrayList<Integer> al = new ArrayList<>();
    ArrayList<Integer> length = new ArrayList<>();
    al.add(2);
    al.add(3);
    al.add(3);
    al.add(4);
    al.add(6);
    al.add(7);

    p.printSum(al, al.size(), 12, length);
    System.out.println(length);
  }
}
