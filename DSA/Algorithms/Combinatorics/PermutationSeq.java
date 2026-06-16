
import java.util.*;

class PermutationSeq {
    public String getPermutation(int n, int k) {
        String ans = "";
        List<Integer> numbers = new ArrayList<>();
        int fact = 1;
        for(int i=1;i<n;i++){
            fact = fact * i;
            numbers.add(i);
            // System.out.println(fact);
        }
        
        numbers.add(n);
        // System.out.println(numbers);
        k = k - 1;
        // System.out.println(k);
        while(true){
            ans = ans + numbers.get(k / fact);
            numbers.remove(k/fact);
            if(numbers.size() == 0){
                break;
            }
            k =  k % fact;
            fact = fact / numbers.size();
        }
        return ans;
        
    }
}