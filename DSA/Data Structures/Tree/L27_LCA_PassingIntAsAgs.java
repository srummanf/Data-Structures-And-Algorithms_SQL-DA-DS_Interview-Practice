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

class L27_LCA_PassingIntAsAgs {

  private TreeNode findNode(TreeNode root, int val) {
    if (root == null) return null;
    if (root.val == val) return root;
    TreeNode left = findNode(root.left, val);
    if (left != null) return left;
    return findNode(root.right, val);
  }

  public TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
    TreeNode nodeP = findNode(root, p);
    TreeNode nodeQ = findNode(root, q);
    if (nodeP == null || nodeQ == null) return null;
    return lowestCommonAncestorHelper(root, nodeP, nodeQ);
  }

  private TreeNode lowestCommonAncestorHelper(
    TreeNode root,
    TreeNode p,
    TreeNode q
  ) {
    if (root == null || root == p || root == q) return root;

    TreeNode left = lowestCommonAncestorHelper(root.left, p, q);
    TreeNode right = lowestCommonAncestorHelper(root.right, p, q);

    if (left == null) return right; else if (
      right == null
    ) return left; else return root;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(20);
    root.left = new TreeNode(8);
    root.right = new TreeNode(22);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(12);
    root.left.right.left = new TreeNode(10);
    root.left.right.right = new TreeNode(14);

    L27_LCA_PassingIntAsAgs solution = new L27_LCA_PassingIntAsAgs();
    TreeNode lca = solution.lowestCommonAncestor(root, 10, 14);
    if (lca != null) {
      System.out.println("Lowest Common Ancestor: " + lca.val);
    } else {
      System.out.println("One or both nodes not found in the tree.");
    }
  }
}
