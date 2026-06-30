class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0;
        int len = s.length();
        int l = 0;
        int r = 0;
        while (r < len) {

            String ss = s.substring(l, r + 1);

            if (ss.contains("a") && ss.contains("b") && ss.contains("c")) {

                // Every longer substring will also be valid
                count += (len - r);

                l++;
            } else {
                r++;
            }

            // Prevent l from crossing r
            if (l > r) {
                r = l;
            }
        }

        // for (int i = 0; i < len; i++) {
        //     for (int j = i; j < len + 1; j++) {
        //         String ss = s.substring(i, j);

        //         if (ss.contains(String.valueOf('a')) && ss.contains(String.valueOf('b'))
        //                 && ss.contains(String.valueOf('c'))) {
        //             //System.out.println(ss);
        //             count++;
        //         }
        //     }
        // }
        return count;
    }
}