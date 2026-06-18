/**
 * Luke, a naughty kid, went to a museum one day. He sees an ancient grid 'A' consisting of 'N' rows and 'N' columns. Each cell of a grid is coloured with either black or white.

Luke performs two sequential operations on the grid ‘A’. First, he twists the grid vertically around the center. After that, as the second operation, he changes the colours of all the cells. If the cell is white, it is changed to black and vice-versa.

The following drawings show the twist operation and the colour change operation, respectively :



The black colour is represented by '1' and white colour is represented by '0' here. You have to print the final grid.


VERTICAL ROTATE OPERATION : MIRROR IMAGE
COLOR CHANGE : NOT OPERATION
Example :
'N' = 2, 'A' = { {0, 1}, {0, 0} }.

After twisting, the grid looks like :
'A' =  { {1, 0}, {0, 0} }.

After changing the colours, the grid looks like :
'A' =  { {0, 1}, {1, 1} }.
 */

public class VerticalRotateColorChange {
    public static int[][] getFinalGrid(int a[][], int n) {
        // Write your code here.
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (a[i][j] == 1)
                    ans[i][n - 1 - j] = 0;
                else
                    ans[i][n - 1 - j] = 1;

            }
        }

        return ans;

    }
}
