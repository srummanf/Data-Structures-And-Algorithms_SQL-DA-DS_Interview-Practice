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

class L20_BoundaryTraversal_OnlyLeafNodes {

  private static void printLeaves(TreeNode root) {
    if (root != null) {
      printLeaves(root.left);
      if (root.left == null && root.right == null) {
        System.out.print(root.val + " ");
      }
      printLeaves(root.right);
    }
  }

  public static void boundaryTraversal(TreeNode root) {
    if (root != null) {
      System.out.print(root.val + " ");
      printLeaves(root.left);
      printLeaves(root.right);
    }
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

    System.out.println("Boundary Traversal of the given tree is:");
    boundaryTraversal(root);
  }
}
