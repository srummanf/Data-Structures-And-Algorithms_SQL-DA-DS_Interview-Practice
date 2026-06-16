import java.util.ArrayList;

public class SubsequenceSumK {

    public static void subSequenceSum(
        ArrayList<ArrayList<Integer>> ans, 
        int[] a, ArrayList<Integer> temp, 
        int k, int start) {
        
        if (start > a.length || k < 0)
            return;

        if (k == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < a.length; i++) {
            temp.add(a[i]);
            subSequenceSum(ans, a, temp, k - a[i], i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 12, 3, 17, 1, 18, 15, 3, 17};
        int k = 6;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        subSequenceSum(ans, arr, new ArrayList<>(), k, 0);
        
        for (ArrayList<Integer> subSeq : ans) {
            for (int num : subSeq) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
