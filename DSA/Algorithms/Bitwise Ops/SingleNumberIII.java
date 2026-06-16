import java.util.ArrayList;
import java.util.HashMap;

public class SingleNumberIII {

  static int[] check2(int[] nums) {
    HashMap<Integer, Integer> hm = new HashMap<>();
    for (int i : nums) {
      hm.put(i, hm.getOrDefault(i, 0) + 1);
    }
    ArrayList<Integer> al = new ArrayList<>();
    for (int i : hm.keySet()) {
      if (hm.get(i) == 1) {
        al.add(i);
      }
    }
    int ans[] = new int[2];
    int x = 0;
    for (int i : al) {
      ans[x++] = i;
    }
    return ans;
  }

  static int[] check(int arr[]) {
    int xor = 0;
    for (int i = 0; i < arr.length; i++) {
      xor ^= arr[i];
    }
    int rightmostsetbit = (xor & (xor - 1)) ^ xor;
    // Concept of bucket
    int b1 = 0, b2 = 0;
    for (int i = 0; i < arr.length; i++) {
      if ((arr[i] & rightmostsetbit) != 0) {
        b1 ^= arr[i];
      } else {
        b2 ^= arr[i];
      }
    }
    return new int[] { b1, b2 };
  }

  public static void main(String[] args) {
    int arr[] = { 1, 2, 1, 3, 2, 5 };
    int res[] = check(arr);
    System.out.println(res[0] + " " + res[1]);
    int res2[] = check2(arr);
    System.out.println(res2[0] + " " + res2[1]);
  }
}
