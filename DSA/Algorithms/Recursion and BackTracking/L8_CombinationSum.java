import java.util.ArrayList;
import java.util.List;

class Solution {
    void f(int idx, int target, List<List<Integer>> ans, int[] candidates, List<Integer> temp) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        if (idx == candidates.length || target < 0) {
            return;
        }

        if (candidates[idx] <= target) {
            temp.add(candidates[idx]);
            f(idx, target - candidates[idx], ans, candidates, temp);
            temp.remove(temp.size() - 1); // Backtrack
        }
        
        f(idx + 1, target, ans, candidates, temp);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        f(0, target, ans, candidates, new ArrayList<>());
        return ans;
    }
}
