// Amazon, Intuit, Microsoft, Flipkart

public class L1_CountOccurancesOfAnagram {

    boolean checkFreqZero(int[] freq){
        for(int x : freq){
            if(x != 0)
                return false;
        }
        return true;
    }

    int search(String pat, String txt) {

        int[] freq = new int[26];

        for(char ch : pat.toCharArray()){
            freq[ch-'a']++;
        }

        int count = 0;
        int l = 0, r = 0;
        int k = pat.length();

        while(r < txt.length()){

            freq[txt.charAt(r)-'a']--;

            if((r-l+1) == k){

                if(checkFreqZero(freq))
                    count++;

                freq[txt.charAt(l)-'a']++;
                l++;
            }

            r++;
        }

        return count;
    }

    public static void main(String[] args) {
        L1_CountOccurancesOfAnagram obj = new L1_CountOccurancesOfAnagram();
        String txt = "forxxorfxdofr";
        String pat = "for";
        System.out.println(obj.search(pat, txt));
    }

}

//Visualization: https://www.youtube.com/watch?v=mrUBUWb23hk&list=PLpIkg8OmuX-J2Ivo9YdY7bRDstPPTVGvN&index=1