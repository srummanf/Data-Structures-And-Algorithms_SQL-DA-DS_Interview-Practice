/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return construct(nums, 0, nums.length-1);
    }

    public TreeNode construct(int[] nums, int l , int r){
        if(l>r) return null;
        int mid = l + (r-l)/2;
        TreeNode left = construct(nums, l, mid-1);
        TreeNode right = construct(nums, mid+1, r);
        TreeNode root = new TreeNode(nums[mid], left, right);

        return root;
    }
}