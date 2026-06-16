import java.util.*;

public class PairWithGivenSumInUnsortedArrays {
    boolean check(int arr[], int sum) {
        HashSet<Integer> h = new HashSet<>();
        for (int x : arr) {
            if (h.contains(sum - x)) {
                return true;
            } else {
                h.add(x);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 2, 8, 15, -8, -3 };
        int sum = 17;
        PairWithGivenSumInUnsortedArrays p = new PairWithGivenSumInUnsortedArrays();
        System.out.println(p.check(arr, sum));
    }
}
