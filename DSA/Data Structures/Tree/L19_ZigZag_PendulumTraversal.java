class Solution {

  private void traverse(TreeNode node, int level, List<List<Integer>> result) {
    if (node == null) return;

    if (result.size() <= level) {
      result.add(new ArrayList<>());
    }

    if (level % 2 == 0) {
      result.get(level).add(node.val);
    } else {
      result.get(level).add(0, node.val);
    }

    traverse(node.left, level + 1, result);
    traverse(node.right, level + 1, result);
  }

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    traverse(root, 0, result);
    return result;
  }
}
