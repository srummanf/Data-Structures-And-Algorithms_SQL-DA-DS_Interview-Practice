import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SetMatOne {

  public static void setMatrixOnes(
    ArrayList<ArrayList<Integer>> MAT,
    int n,
    int m
  ) {
    // Sets to store the indices of rows and columns to be marked
    Hash Set<Integer> hsr = new HashSet<>();
    Hash Set<Integer> hsc = new HashSet<>();

    // First pass: Identify the rows and columns to be marked
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (MAT.get(i).get(j) == 1) {
          hsr.add(i);
          hsc.add(j);
        }
      }
    }

    // Second pass: Update the matrix based on the identified rows and columns
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (hsr.contains(i) || hsc.contains(j)) {
          MAT.get(i).set(j, 1);
        }
      }
    }
  }

  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> MAT = new ArrayList<>();

    ArrayList<Integer> row1 = new ArrayList<>();
    row1.add(0);
    row1.add(0);
    row1.add(0);
    MAT.add(row1);

    ArrayList<Integer> row2 = new ArrayList<>();
    row2.add(0);
    row2.add(0);
    row2.add(1);
    MAT.add(row2);

    setMatrixOnes(MAT, 2, 3);

    // Print the modified matrix
    for (ArrayList<Integer> row : MAT) {
      System.out.println(row);
    }
  }
}
