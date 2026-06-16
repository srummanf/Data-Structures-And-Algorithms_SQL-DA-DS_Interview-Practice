import java.util.Arrays;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String pre = "";
        int n = strs.length;
        int mini = Integer.MAX_VALUE;
        Arrays.sort(strs);
        mini = (strs[0].length());
        int i = 0;
        while(i<mini){
            if(strs[0].charAt(i) == strs[n-1].charAt(i)){
                pre+=strs[0].charAt(i);
                i++;
            } else {
                break;
            }
        }


        return pre;

    }
}