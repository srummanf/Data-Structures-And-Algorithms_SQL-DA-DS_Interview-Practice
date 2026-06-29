class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count =0;
        for(String w: patterns){
            if(word.contains(w)){
                count++;

            }

        }
        return count;
    }
}


// Brute Force : O(n^2)

//  boolean doesContain(String pat, String word){
//         int len = word.length();
//         for(int i= 0; i<len; i++){
//             for(int j=i; j<len+1; j++){
//                 String ss = word.substring(i, j);
//                 if(ss.equals(pat))return true;
//             }
//         }
//         return false;
//     }
//     public int numOfStrings(String[] patterns, String word) {
//         int count = 0;
//         for(String w: patterns){
//             if(doesContain(w, word)) count++;
//         }
//         return count;
//     }