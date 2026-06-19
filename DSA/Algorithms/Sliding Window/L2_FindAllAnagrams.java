import java.util.*;

public class L2_FindAllAnagrams {
    boolean checkFreqZero(int[] freq) {
        for (int x : freq) {
            if (x != 0)
                return false;
        }
        return true;
    }

    public List<Integer> findAnagrams(String txt, String pat) {
        int[] freq = new int[26];

        for (char ch : pat.toCharArray()) {
            freq[ch - 'a']++;
        }

        List<Integer> ans = new ArrayList<>();
        int l = 0, r = 0;
        int k = pat.length();

        while (r < txt.length()) {

            freq[txt.charAt(r) - 'a']--;

            if ((r - l + 1) == k) {

                if (checkFreqZero(freq))
                    ans.add(l);

                freq[txt.charAt(l) - 'a']++;
                l++;
            }

            r++;
        }

        return ans;
    }

    public static void main(String[] args) {
        L2_FindAllAnagrams obj = new L2_FindAllAnagrams();
        String txt = "cbaebabacd";
        String pat = "abc";
        System.out.println(obj.findAnagrams(txt, pat));
    }
}
