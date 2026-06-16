import java.util.HashMap;

public class CountDistinctElementsInEachWindow {

  void printDistinctElements(int arr[], int n, int k) {
    HashMap<Integer, Integer> m = new HashMap<>();
    for (int i = 0; i < k; i++) {
      m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
    }
    System.out.print(m.size() + " ");
    System.out.println(m);
    for (int i = k; i < n; i++) {
      m.put(arr[i - k], m.get(arr[i - k]) - 1);

      if (m.get(arr[i - k]) == 0) {
        m.remove(arr[i - k]);
      }
      m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
      System.out.print(m.size() + " ");
    }
  }

  public static void main(String[] args) {
    CountDistinctElementsInEachWindow c = new CountDistinctElementsInEachWindow();
    int arr[] = { 1, 2, 1, 3, 4, 2, 3 };
    int k = 4;
    int n = arr.length;
    c.printDistinctElements(arr, n, k);
  }
}
