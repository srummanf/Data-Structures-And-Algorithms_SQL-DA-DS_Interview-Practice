import java.util.Arrays;

public class DPMATRIX {
    public static void main(String[] args) {
        int m = 3; // Replace with your desired row size
        int n = 4; // Replace with your desired column size

        int[][] matrix = new int[m][n];

        // Fill the matrix with -1 using Arrays.fill
        for (int i = 0; i < m; i++) {
            Arrays.fill(matrix[i], -1);
        }

        // Print the matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
