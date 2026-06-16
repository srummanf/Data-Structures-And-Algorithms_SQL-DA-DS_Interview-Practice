import java.util.*;
public class kthBitSet {
    boolean check(int n, int k){
        if((n & (1<<(k-1))) != 0){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        kthBitSet obj = new kthBitSet();
        System.out.println(obj.check(5, 3));
    }
}
