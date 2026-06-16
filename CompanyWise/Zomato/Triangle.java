/** Problem Statement
You are given the coordinates of 5 points: the first three are vertices of a triangle, and the remaining two are arbitrary points. Your task is to:

Determine if the three given vertices form a valid triangle (i.e., they are not collinear).
Check whether the two given points lie inside or outside the triangle.
Return an integer based on the results of the checks:

1 if both points lie inside the triangle.
2 if the first point is inside and the second point is outside the triangle.
3 if the first point is outside and the second point is inside the triangle.
4 if both points lie outside the triangle.
0 if the vertices do not form a valid triangle.

Input Format
The first three lines contain the coordinates of the triangle vertices.
The fourth and fifth lines contain the coordinates of the two additional points.
Each coordinate is an integer, and the coordinates are space-separated on each line.

Output Format
Return an integer based on the conditions described.

Sample Input 1
0 0
4 0
2 3
2 1
4 2
Sample Output 1
2
Explanation: The vertices form a valid triangle. The point (2, 1) lies inside the triangle, while the point (4, 2) lies outside.

Sample Input 2
0 0
4 0
4 4
2 2
5 5
Sample Output 2
3
Explanation: The vertices form a valid triangle. The point (2, 2) lies inside the triangle, while the point (5, 5) lies outside.

Sample Input 3
0 0
1 1
2 2
3 3
4 4
Sample Output 3
0
Explanation: The vertices do not form a valid triangle (they are collinear). Both points are outside the non-existent triangle.

Sample Input 4
0 0
5 0
0 5
2 2
1 1
Sample Output 4
1
Explanation: The vertices form a valid triangle. Both points (2, 2) and (1, 1) lie inside the triangle.*/

class Triangle {

  public static boolean isCollinear(
    int x1,
    int y1,
    int x2,
    int y2,
    int x3,
    int y3
  ) {
    // Calculate the area of the triangle formed by the three points
    // If the area is zero, the points are collinear
    return (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) == 0;
  }

  public static boolean isTriangle(int a, int b, int c, int d, int e, int f) {
    return !isCollinear(a, b, c, d, e, f);
  }

  public static double area(int x1, int y1, int x2, int y2, int x3, int y3) {
    return Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
  }

  public static boolean insideTriangle(
    int a,
    int b,
    int c,
    int d,
    int e,
    int f,
    int x,
    int y
  ) {
    double A = area(a, b, c, d, e, f);
    double A1 = area(x, y, c, d, e, f);
    double A2 = area(a, b, x, y, e, f);
    double A3 = area(a, b, c, d, x, y);

    return A == (A1 + A2 + A3);
  }

  public static int checkValue(
    int a,
    int b,
    int c,
    int d,
    int e,
    int f,
    int p,
    int q,
    int x,
    int y
  ) {
    if (!isTriangle(a, b, c, d, e, f)) return 0;

    boolean first = insideTriangle(a, b, c, d, e, f, p, q);
    System.out.println(first);
    boolean second = insideTriangle(a, b, c, d, e, f, x, y);
    System.out.println(second);

    if (first && second) return 1;
    if (first && !second) return 2;
    if (!first && second) return 3;
    return 4; // The last case where both points are outside
  }

  public static void main(String[] args) {
    int a = 0, b = 0;
    int c = 4, d = 0;
    int e = 4, f = 4;
    int p = 2, q = 2;
    int x = 5, y = 5;
    System.out.println(checkValue(a, b, c, d, e, f, p, q, x, y)); // Expected output: 3
  }
}
