/** Problem Statement: Flood Fill Algorithm
 * Statement: An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535). Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image. To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.
 * 
 */

class G_9_Flood_Fill_Algo {

  private void dfs(
    int row,
    int col,
    int[][] ans,
    int[][] image,
    int newColor,
    int delRow[],
    int delCol[],
    int iniColor
  ) {
    // color with new color
    ans[row][col] = newColor;
    int n = image.length;
    int m = image[0].length;
    // there are exactly 4 neighbours
    for (int i = 0; i < 4; i++) {
      int nrow = row + delRow[i];
      int ncol = col + delCol[i];
      // check for valid coordinate
      // then check for same initial color and unvisited pixel
      if (
        nrow >= 0 &&
        nrow < n &&
        ncol >= 0 &&
        ncol < m &&
        image[nrow][ncol] == iniColor &&
        ans[nrow][ncol] != newColor
      ) {
        dfs(nrow, ncol, ans, image, newColor, delRow, delCol, iniColor);
      }
    }
  }

  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    // get initial color
    int iniColor = image[sr][sc];
    int[][] ans = image;
    // delta row and delta column for neighbours
    int delRow[] = { -1, 0, +1, 0 };
    int delCol[] = { 0, +1, 0, -1 };
    dfs(sr, sc, ans, image, newColor, delRow, delCol, iniColor);
    return ans;
  }




  

  public static void main(String[] args) {
    int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };

    // sr = 1, sc = 1, newColor = 2
    G_9_Flood_Fill_Algo obj = new G_9_Flood_Fill_Algo();
    int[][] ans = obj.floodFill(image, 1, 1, 2);
    for (int i = 0; i < ans.length; i++) {
      for (int j = 0; j < ans[i].length; j++) System.out.print(ans[i][j] + " ");
      System.out.println();
    }
  }
}
