/** You want to choose 2 non intersecting square subgrids from the matrix such that they have no common row or columns. The objective is to maximise the sum of the difference between maximum and minimum elements of the both subgrids */

import java.util.Scanner;

public class MaximiseSumInSubGrids {

    // Method to calculate the max sum of differences for a given subgrid size
    public static int maxSumOfDifferences(int[][] matrix, int subgridSize) {
        int n = matrix.length;
        int maxSum = Integer.MIN_VALUE;

        // Iterate over all possible starting positions for the first subgrid
        for (int i1 = 0; i1 <= n - subgridSize; i1++) {
            for (int j1 = 0; j1 <= n - subgridSize; j1++) {
                int max1 = Integer.MIN_VALUE;
                int min1 = Integer.MAX_VALUE;

                // Calculate max and min for the first subgrid
                for (int x1 = i1; x1 < i1 + subgridSize; x1++) {
                    for (int y1 = j1; y1 < j1 + subgridSize; y1++) {
                        max1 = Math.max(max1, matrix[x1][y1]);
                        min1 = Math.min(min1, matrix[x1][y1]);
                    }
                }

                // Iterate over all possible starting positions for the second subgrid
                for (int i2 = 0; i2 <= n - subgridSize; i2++) {
                    for (int j2 = 0; j2 <= n - subgridSize; j2++) {
                        if ((i1 + subgridSize <= i2 || i2 + subgridSize <= i1) && (j1 + subgridSize <= j2 || j2 + subgridSize <= j1)) {
                            int max2 = Integer.MIN_VALUE;
                            int min2 = Integer.MAX_VALUE;

                            // Calculate max and min for the second subgrid
                            for (int x2 = i2; x2 < i2 + subgridSize; x2++) {
                                for (int y2 = j2; y2 < j2 + subgridSize; y2++) {
                                    max2 = Math.max(max2, matrix[x2][y2]);
                                    min2 = Math.min(min2, matrix[x2][y2]);
                                }
                            }

                            // Calculate the sum of differences
                            int diff1 = max1 - min1;
                            int diff2 = max2 - min2;
                            maxSum = Math.max(maxSum, diff1 + diff2);
                        }
                    }
                }
            }
        }

        return maxSum;
    }

    // Method to find the overall maximum sum of differences for all subgrid sizes
    public static int overallMaxSumOfDifferences(int[][] matrix) {
        int n = matrix.length;
        int overallMaxSum = Integer.MIN_VALUE;

        // Iterate over all possible subgrid sizes
        for (int subgridSize = 1; subgridSize <= n; subgridSize++) {
            int maxSum = maxSumOfDifferences(matrix, subgridSize);
            overallMaxSum = Math.max(overallMaxSum, maxSum);
        }

        return overallMaxSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of the matrix (n):");
        int n = scanner.nextInt();

        int[][] matrix = new int[n][n];

        System.out.println("Enter the matrix elements:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int result = overallMaxSumOfDifferences(matrix);
        System.out.println("The maximum sum of differences is: " + result);
    }
}
