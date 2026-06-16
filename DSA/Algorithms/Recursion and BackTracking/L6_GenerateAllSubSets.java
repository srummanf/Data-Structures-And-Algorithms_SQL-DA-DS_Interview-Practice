class Solution {
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
}