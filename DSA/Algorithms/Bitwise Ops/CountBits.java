// Brian Kerningham Algorithm

import java.util.*;

public class CountBits {
    int count(int n){
        int c=0;
        while(n>0){
            n=n&(n-1);
            c++;
        }
        return c;
    }
    public static void main(String[] args){
        CountBits obj = new CountBits();
        System.out.println(obj.count(5));
    }
}
