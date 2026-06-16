class Solution {

  public int[][] merge(int[][] arr) {
    int n = arr.length; // size of the array
    // sort the given intervals:
    Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

    List<List<Integer>> ans = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      // if the current interval does not
      // lie in the last interval:
      if (ans.isEmpty() || arr[i][0] > ans.get(ans.size() - 1).get(1)) {
        ans.add(Arrays.asList(arr[i][0], arr[i][1]));
      }
      // if the current interval
      // lies in the last interval:
      else {
        ans
          .get(ans.size() - 1)
          .set(1, Math.max(ans.get(ans.size() - 1).get(1), arr[i][1]));
      }
    }
    int s = ans.size();
    int[][] res = new int[s][2];
    for (int i = 0; i < s; i++) {
      int st = ans.get(i).get(0);
      int ed = ans.get(i).get(1);
      res[i] = new int[] { st, ed };
    }
    return res;
  }
}
