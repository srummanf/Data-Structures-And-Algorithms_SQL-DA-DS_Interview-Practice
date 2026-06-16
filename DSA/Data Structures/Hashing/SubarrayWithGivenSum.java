import java.util.*;

class SubarrayWithGivenSum {
    boolean isSum(int arr[], int sum){
        HashSet<Integer> h = new HashSet<>();
        int prefix_sum = 0;
        for(int x: arr){
            prefix_sum += x; // This is the extra line that is added to the PairWithGivenSumInUnsortedArrays.java
            if(h.contains(prefix_sum - sum)){
                return true;
            }else{
                h.add(prefix_sum);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[] = { 3, 2, 8, 15, -8, -3 };
        int sum = 17;
        SubarrayWithGivenSum s = new SubarrayWithGivenSum();
        System.out.println(s.isSum(arr, sum));
    }
}
