/**Given the coordinates of four points in 2D space p1, p2, p3 and p4, return true if the four points construct a square.

The coordinate of a point pi is represented as [xi, yi]. The input is not given in any order.

A valid square has four equal sides with positive length and four equal angles (90-degree angles). */

public class ValidSquare {

  // Method to determine if four points form a valid square.
  public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
    // Check all combinations of three points to see if they form right triangles.
    return (
      checkRightTriangle(p1, p2, p3) &&
      checkRightTriangle(p1, p3, p4) &&
      checkRightTriangle(p1, p2, p4) &&
      checkRightTriangle(p2, p3, p4)
    );
  }

  // Helper method to check if three points form a right-angled triangle.
  private boolean checkRightTriangle(int[] pointA, int[] pointB, int[] pointC) {
    // Extract x and y coordinates of points.
    int xA = pointA[0], yA = pointA[1];
    int xB = pointB[0], yB = pointB[1];
    int xC = pointC[0], yC = pointC[1];

    // Compute squared distances between the points.
    int distanceAB = squaredDistance(xA, yA, xB, yB);
    int distanceAC = squaredDistance(xA, yA, xC, yC);
    int distanceBC = squaredDistance(xB, yB, xC, yC);

    // Check the conditions for forming a right-angled triangle (Pythagorean theorem):
    // two distances must be equal (the sides of the square) and the sum of their squares
    // must equal the square of the third distance (the diagonal of the square).
    // Ensure that no distance is zero to prevent degenerate triangles.
    return (
      (
        distanceAB == distanceAC &&
        distanceAB + distanceAC == distanceBC &&
        distanceAB > 0
      ) ||
      (
        distanceAB == distanceBC &&
        distanceAB + distanceBC == distanceAC &&
        distanceAB > 0
      ) ||
      (
        distanceAC == distanceBC &&
        distanceAC + distanceBC == distanceAB &&
        distanceAC > 0
      )
    );
  }

  // Helper method to calculate the squared distance between two points to avoid floating point errors.
  private int squaredDistance(int x1, int y1, int x2, int y2) {
    return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
  }
}
