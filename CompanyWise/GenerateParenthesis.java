public class GenerateParenthesis {

  static String s = "";

  public static boolean isValid(String str) {
    int openCount = 0;
    int n = str.length();
    for (int i = 0; i < n; i++) {
      if (str.charAt(i) == '(') openCount++; else {
        if (openCount == 0) return false;
        openCount--;
      }
    }
    return openCount == 0;
  }

  public static void solve(int n, int openCount, int closeCount) {
    if (s.length() == 2 * n) {
      if (isValid(s)) {
        System.out.println(s);
      }
      return;
    }

    if (openCount < n) {
      s += '(';
      solve(n, openCount + 1, closeCount);
      s = s.substring(0, s.length() - 1);
    }

    if (closeCount < openCount) {
      s += ')';
      solve(n, openCount, closeCount + 1);
      s = s.substring(0, s.length() - 1);
    }
  }

  public static void printWellFormedParanthesis(int n) {
    solve(n, 0, 0);
  }

  public static void main(String[] args) {
    printWellFormedParanthesis(3); // Change the parameter to the desired number of pairs
  }
}
