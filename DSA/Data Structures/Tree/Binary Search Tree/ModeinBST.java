import java.util.*;

class ModeinBST {

  static class TreeNode {

    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  public static TreeNode insert(TreeNode root, int val) {
    if (root == null) {
      root = new TreeNode(val);
      return root;
    }
    if (val < root.data) {
      root.left = insert(root.left, val);
    } else {
      root.right = insert(root.right, val);
    }
    return root;
  }

  //   --------------------------------------------------------------------

  HashMap<Integer, Integer> hm = new HashMap<>();

  public void Traverse(TreeNode root) {
    if (root == null) {
      return;
    }
    Traverse(root.left);
    hm.put(root.data, hm.getOrDefault(root.data, 0) + 1);
    Traverse(root.right);
  }

  public int[] findMode(TreeNode root) {
    Traverse(root);

    int maxVal = -1;
    for (int value : hm.values()) {
      if (value > maxVal) {
        maxVal = value;
      }
    }

    ArrayList<Integer> ans = new ArrayList<>();
    for (int i : hm.keySet()) {
      if (hm.get(i) == maxVal) {
        ans.add(i);
      }
    }

    int[] intArray = new int[ans.size()];
    for (int i = 0; i < ans.size(); i++) {
      intArray[i] = ans.get(i);
    }
    return intArray;
  }

  public static void main(String[] args) {
    ModeinBST m = new ModeinBST();
    int val[] = { 1,1,1,3,3,3,4 };
    TreeNode root = null;
    for (int x : val) {
      root = insert(root, x);
    }
    System.out.println(Arrays.toString(m.findMode(root)));
  }
}
