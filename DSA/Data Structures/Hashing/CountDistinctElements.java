import java.util.HashSet;

 class CountDistinctElements {
    int countDistinct(int arr[], int n) {
        HashSet<Integer> s = new HashSet<Integer>();
        for(int i = 0; i < n; i++) {
            s.add(arr[i]);
        }
        for(int x : s) {
            System.out.print(x + " ");
        }
        return s.size();
    }
    public static void main(String args[]) {
        CountDistinctElements c = new CountDistinctElements();
        int arr[] = {15, 12, 13, 12, 13, 13, 18};
        int n = arr.length;
        System.out.println(c.countDistinct(arr, n));
    }
}

