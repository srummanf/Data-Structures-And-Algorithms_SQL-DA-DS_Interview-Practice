/**
 * Top view:
 * The Top View displays nodes visible from the top of the tree when viewed from
 * above.
 * It shows the outermost nodes at each vertical level.
 * Example:
 *
 * A
 * / \
 * B C
 * / / \
 * D E F
 *
 * Top View: D B A C F
 *
 */

import java.util.*;

class TreeNode {

  char val;
  TreeNode left;
  TreeNode right;

  public TreeNode(char val) {
    this.val = val;
    left = null;
    right = null;
  }
}

public class TopViewOfTree {

  public static List<Character> topView(TreeNode root) {
    List<Character> topView = new ArrayList<>();

    if (root == null) {
      return topView;
    }

    // New data Structure : TreeMap
    Map<Integer, Character> verticalMap = new TreeMap<>();
    // Queue<Pair> queue = new LinkedList<>();
    Queue<TreeNode> nodeQueue = new LinkedList<>();
    Queue<Integer> hdQueue = new LinkedList<>();

    // queue.offer(new Pair(root, 0));
    nodeQueue.offer(root);
    hdQueue.offer(0);

    while (!nodeQueue.isEmpty()) {
      // Pair pair = queue.poll();

      TreeNode node = nodeQueue.poll();
      int hd = hdQueue.poll();

      if (!verticalMap.containsKey(hd)) {
        verticalMap.put(hd, node.val);
      }

      if (node.left != null) {
        nodeQueue.offer(node.left);
        hdQueue.offer(hd - 1);
        // queue.offer(new Pair(node.left, hd - 1));
      }

      if (node.right != null) {
        nodeQueue.offer(node.right);
        hdQueue.offer(hd + 1);
        // queue.offer(new Pair(node.right, hd + 1));
      }
    }

    for (char nodeVal : verticalMap.values()) {
      topView.add(nodeVal);
    }
    return topView;
  }

  public static void main(String[] args) {
    // Sample binary tree input
    TreeNode root = new TreeNode('A');
    root.left = new TreeNode('B');
    root.right = new TreeNode('C');
    root.left.left = new TreeNode('D');
    root.right.left = new TreeNode('E');
    root.right.right = new TreeNode('F');
    List<Character> topViewResult = topView(root);
    // Printing the Top View
    System.out.print("Top View: ");
    for (char node : topViewResult) {
      System.out.print(node + " ");
    }
    System.out.println();
  }
}
