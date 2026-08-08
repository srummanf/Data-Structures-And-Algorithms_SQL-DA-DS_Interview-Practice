
import java.util.*;
class L6_GenerateAllSubSets {
    void backtrack(int idx, List<Integer> temp, List<List<Integer>> ans, int[] nums) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[idx]);
        backtrack(idx + 1, temp, ans, nums);
        temp.remove(temp.size() - 1);
        backtrack(idx + 1, temp, ans, nums);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, new ArrayList<>(), ans, nums);
        return ans;
    }

    public static void main(String[] args) {
        L6_GenerateAllSubSets obj = new L6_GenerateAllSubSets();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = obj.subsets(nums);
        System.out.println(result);
    }
}