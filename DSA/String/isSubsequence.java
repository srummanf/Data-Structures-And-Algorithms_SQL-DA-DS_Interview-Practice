// https://leetcode.com/problems/is-subsequence/
class isSubsequence
{
    public boolean ss(String s, String t) {
        int c = 0;
        int l1=s.length();
        int l2=t.length();



        if(l1 == 1){
            for(int i=0;i<l2;i++){
                if(s.charAt(0)==t.charAt(i)){
                    return true;
                }
            }
            return false;
        }




        for(int i=0;i<l1;i++){
            for(int j=i;j<l2;j++){
                char a = s.charAt(i);
                char b = t.charAt(j);
                System.out.println(b);
                if(a==b){
                    c++;
                    i++;
                }
            }
        }
        System.out.println(c);
        if(c>=l1){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        isSubsequence obj = new isSubsequence();
        String s = "b";
        String t = "abc";
        System.out.println(obj.ss(s,t));
    }
}