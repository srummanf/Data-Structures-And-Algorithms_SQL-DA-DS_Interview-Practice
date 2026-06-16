import java.util.ArrayList;
import java.util.Collections;

public class PrintingSubSequencesWhoseSumIsLessEqualK {

  public int numSubseq(int[] nums, int target) {
    int diff = 0, len = nums.length;
    long mod = 1000000007, ans = 0;
    ArrayList<Long> al = new ArrayList<>();
    for (int i : nums) {
      long val = i;
      al.add(val);
    }
    Collections.sort(al);

    ArrayList<Long> precompute = new ArrayList<>();
    precompute.add((long) 1);
    for (int i = 1; i <= len; i++) {
      precompute.add(((precompute.get(i - 1) * 2) % mod));
    }

    // long precompute[] = new long[len];
    // precompute[0]=1;
    // for(int i=1;i<len;i++){
    //     precompute[i] = (precompute[i-1]*2)%mod;
    // }

    int l = 0, r = len - 1;
    while (l <= r) {
      if (al.get(l) + al.get(r) <= target) {
        diff = r - l;
        ans = ((ans % mod) + precompute.get(diff)) % mod;
        //ans = ((ans%mod) + precompute[diff])%mod;
        l++;
      } else {
        r--;
      }
    }
    return (int) ans;
  }

  public static void main(String[] args) {
    PrintingSubSequencesWhoseSumIsLessEqualK p = new PrintingSubSequencesWhoseSumIsLessEqualK();
    int nums[] = { 3, 5, 6, 7 };
    int target = 9;
    System.out.println(p.numSubseq(nums, target));
  }
}
