import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    void f(int idx, int target, List<List<Integer>> ans, int[] candidates, List<Integer> temp) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) continue;

            if (candidates[i] <= target) {
                temp.add(candidates[i]);
                f(i + 1, target - candidates[i], ans, candidates, temp);
                temp.remove(temp.size() - 1); // Backtrack
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates); // Sort to handle duplicates easily
        f(0, target, ans, candidates, new ArrayList<>());
        return ans;
    }
}
