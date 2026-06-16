import java.util.*;

public class Encryption {

  String ceaserCipherEncrypt(String word, int key) {
    String ans = "";
    int n = word.length();
    int i = 0;
    while (i <= n - 1) {
      char ch = word.charAt(i);
      int k = (int) ch + key;
      if (k > 122) {
        k = k - 26;
      }
      ans = ans + (char) k;
      i++;
    }
    return ans;
  }

  char vignereCipherEncrypt(char ch, int key) {
    int k = (int) ch + key;
    if (k > 122) {
      k = k - 26;
    }
    return (char) k;
  }

  String vernamCipherEncrypt(String word, String key, int n) {
    String ans = "";
    for (int i = 0; i < n; i++) {
      char ch = word.charAt(i);
      char ch2 = key.charAt(i);
      int a = (int) ch;
      int b = (int) ch2;
      int val = a ^ b;
      if (val >= 26) {
        val = val - 26;
      }
      val = val + 65;
      ans = ans + (char) val;
    }
    return ans;
  }

  public static void main(String[] args) {
    Encryption ob = new Encryption();

    Scanner sc1 = new Scanner(System.in);
    Scanner sc2 = new Scanner(System.in);

    System.out.println("Enter the sentence to be encrypted: ");
    String word = sc1.next();

    StringTokenizer st = new StringTokenizer(word);
    StringTokenizer st2 = new StringTokenizer(word);

    int tokens = st.countTokens();
    int len = word.length();

    System.out.println("Enter the key for Ceaser Cipher: ");
    int key = sc2.nextInt();
    String answer = "";
    for (int i = 1; i <= tokens; i++) {
      String wordst = st.nextToken();
      String ecr = ob.ceaserCipherEncrypt(wordst, key);
      answer = answer + ecr + " ";
    }
    System.out.println(answer.trim());

    System.out.println("Enter the key for Vignere Cipher: ");
    String key2 = sc1.next();
    int lk2 = key2.length();
    String answer2 = "";
    int z = 0;
    for (int i = 0; i < len; i++) {
      char ch = word.charAt(i);
      char ch2 = key2.charAt(z);
      z++;
      int tk2 = (int) ch2 - 97;
      if (z == lk2) {
        z = 0;
      }
      char upd = ob.vignereCipherEncrypt(ch, tk2);
      answer2 = answer2 + upd;
    }
    System.out.println(answer2.trim());

    System.out.println("Enter the key for Vernam Cipher: ");
    String key3 = sc1.next();
    System.out.println(ob.vernamCipherEncrypt(word, key3, len));

    int a = 10;
    int b = 13;
    int val = a ^ b;
    System.out.println(val);
    // 		char ch = 'a';
    // 		System.out.println((int)ch);
  }
}
