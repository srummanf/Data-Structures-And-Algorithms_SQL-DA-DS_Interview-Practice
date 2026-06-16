/** Given 
n points on a circle, you need to count the number of ways to connect these points with non-crossing chords. A chord is a line segment connecting two points on the circle. Non-crossing means that no two chords intersect inside the circle.

Input
An integer 
n (1 ≤ n ≤ 20), representing the number of points on the circle.

Output
An integer, representing the number of ways to connect the points with non-crossing chords. */

/** The problem can be solved using the Catalan number sequence. The number of ways to connect n points on a circle with non-crossing chords is given by the Catalan number 
n must be even then answer is n/2th catalan number. If n is odd, the result is 0 because you cannot pair up all points.*/

class NonCrossingChord {

  public int numberOfCatalanNumbers(int n) {
    if (n <= 1) return 1;

    int ans = 0;
    for (int i = 1; i <= n; i++) {
      ans += f(i - 1) * f(n - i);
    }
    return ans;
  }

  public int missingChord(int n) {
    return n % 2 == 1 ? 0 : numberOfCatalanNumbers(n / 2);
  }
}
