/** Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

Return the roots of the trees in the remaining forest. You may return the result in any order.

 

Example 1:


Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]
Example 2:

Input: root = [1,2,4,null,3], to_delete = [3]
Output: [[1,2,4]]
  */

// Company Tags - Google, Meta, Amazon

class Solution {

  ArrayList<TreeNode> ans = new ArrayList<>();

  // Hashset contains the values to be deleted
  public void dfs(TreeNode root, boolean isRoot, HashSet<Integer> hash) {
    if (root == null) return;

    boolean toDelete = hash.contains(root.val);
    if (isRoot && !toDelete) {
      ans.add(root);
    }

    if (root.left != null) {
      if (hash.contains(root.left.val)) {
        // Breaking the tree by making the node as root
        dfs(root.left, true, hash);
        // Making the root.left as null , so broken
        root.left = null;
      } else {
        dfs(root.left, false, hash);
      }
    }

    if (root.right != null) {
      if (hash.contains(root.right.val)) {
        dfs(root.right, true, hash);
        root.right = null;
      } else {
        dfs(root.right, false, hash);
      }
    }

    if (toDelete) {
      dfs(root.left, true, hash);
      dfs(root.right, true, hash);
    }
  }

  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    HashSet<Integer> hash = new HashSet<>();
    for (int value : to_delete) {
      hash.add(value);
    }
    dfs(root, true, hash);
    return ans;
  }
}
/** A simple explanation of the code:

TreeNode Class:

This is a basic class for the nodes of a binary tree. Each node has a value (val), a left child (left), and a right child (right).
Solution Class:

This class contains the methods to solve the problem.
ans List:

This list stores the roots of the trees left after deleting the specified nodes.
dfs Method:

This method does the main work of the problem.
It goes through each node in the tree.
If a node needs to be deleted, it will mark its children as potential new roots and continue checking them.
If a node doesn't need to be deleted and it's a new root, it adds it to the ans list.
It also sets child nodes to null if they are deleted.
delNodes Method:

This method starts the process.
It converts the to_delete array into a HashSet for quick lookup of values to be deleted.
It then calls the dfs method starting with the root node of the tree.
Step-by-Step Explanation:
Initialize:

Create a list ans to store the roots of the remaining trees.
Convert the to_delete array into a HashSet called toDeleteSet.
Depth-First Search (DFS):

Start the DFS with the root node.
If the current node is null, return immediately (base case for recursion).
Check Deletion:

Check if the current node's value is in the toDeleteSet.
If it is, mark it for deletion:
Recursively check its left and right children as new roots.
Set the node's left and right children to null if they are in toDeleteSet.
If it's not in the toDeleteSet, continue to check its children without deleting it:
Add the current node to ans if it's a new root (either the initial root or a new root after a deletion).
Process Children:

Recursively check the left child.
If the left child needs to be deleted, set root.left to null.
Recursively check the right child.
If the right child needs to be deleted, set root.right to null.
Return Result:

After the DFS completes, the ans list will contain the roots of the trees that remain after deleting the specified nodes.
In essence, the code traverses the tree, deletes the specified nodes, and keeps track of the new roots of the resulting smaller trees in the ans list. */
