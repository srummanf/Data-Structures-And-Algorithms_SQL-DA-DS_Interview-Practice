import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

  List<Integer> generateRow(int numRows) {
    long ans = 1;
    List<Integer> ansRow = new ArrayList<>();
    ansRow.add(1);

    for (int i = 1; i < numRows; i++) {
      ans = ans * (numRows - i);
      ans = ans / i;
      ansRow.add((int) ans);
    }
    return ansRow;
  }

  List<List<Integer>> generate(int n) {
    List<List<Integer>> ans = new ArrayList<>();

    for (int row = 1; row <= n; row++) {
      ans.add(generateRow(row));
    }
    return ans;
  }

  public static void main(String[] args) {
    PascalTriangle p = new PascalTriangle();
    System.out.println(p.generate(5));
  }
}
