class Solution {
    public String processStr(String s) {
        String res = "";

        for (char ch : s.toCharArray()) {
            if (ch != '*' && ch != '#' && ch != '%') {
                res += ch;
            }

            if (ch == '*' && res.length() > 0) {
                res = res.substring(0, res.length() - 1);
            }

            if (ch == '#') {
                res = res + res;
            }

            if (ch == '%') {
                StringBuilder st = new StringBuilder(res);
                res = st.reverse().toString();
            }
        }

        return res;
    }
}