class Knuth_Morris_Pratt_Algo_PatternMatching {

  public static void Patternsearch(String str, String pat) {
    int M = pat.length();
    int N = str.length();

    for (int i = 0; i <= N - M; i++) {
      int j;    
      for (j = 0; j < M; j++) if (str.charAt(i + j) != pat.charAt(j)) break;

      if (j == M) System.out.println("Pattern found at index " + i);
    }
  }

  public static void main(String[] args) {
    Patternsearch("abcabcabc", "abc");
  }
}
