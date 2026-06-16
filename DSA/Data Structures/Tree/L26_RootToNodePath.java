import java.util.ArrayList;
import java.util.List;

class TreeNode {

  int val;
  TreeNode left, right;

  TreeNode() {}

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

public class L26_RootToNodePath {

  private static List<Integer> ans = new ArrayList<>();

  public static boolean path(TreeNode root, int val) {
    if (root == null) return false;
    ans.add(root.val);
    if (root.val == val) return true;
    if (path(root.left, val) || path(root.right, val)) return true;
    ans.remove(ans.size() - 1);
    return false;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(20);
    root.left = new TreeNode(8);
    root.right = new TreeNode(22);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(12);
    root.left.right.left = new TreeNode(10);
    root.left.right.right = new TreeNode(14);
    root.right.right = new TreeNode(25);

    int targetValue = 14;
    if (path(root, targetValue)) {
      System.out.println(
        "Path from root to node " + targetValue + " is: " + ans
      );
    } else {
      System.out.println("Node " + targetValue + " not found in the tree.");
    }
  }
}
