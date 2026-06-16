### Binary Search Tree (BST) Revision Code Snippets

#### 1. Insertion in a BST

```java
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

public class BST {
    public TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insert(root.left, val);
        else if (val > root.val) root.right = insert(root.right, val);
        return root;
    }
}
```

#### 2. Search in a BST

```java
public class BST {
    public TreeNode search(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        if (val < root.val) return search(root.left, val);
        return search(root.right, val);
    }
}
```

#### 3. Deletion in a BST

```java
public class BST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val) root.left = deleteNode(root.left, key);
        else if (key > root.val) root.right = deleteNode(root.right, key);
        else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            root.val = minValue(root.right);
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private int minValue(TreeNode root) {
        int minv = root.val;
        while (root.left != null) {
            root = root.left;
            minv = root.val;
        }
        return minv;
    }
}
```

#### 4. Inorder Traversal (Recursive and Iterative)

```java
// Recursive
public class BST {
    public void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }
}

// Iterative
import java.util.Stack;

public class BST {
    public void inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.val + " ");
            curr = curr.right;
        }
    }
}
```

#### 5. Checking if a Tree is a BST

```java
public class BST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;
        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;
        if (!isValidBST(node.right, val, upper)) return false;
        if (!isValidBST(node.left, lower, val)) return false;
        return true;
    }
}
```

#### 6. Finding the Lowest Common Ancestor (LCA) in a BST

```java
public class BST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) root = root.left;
            else if (p.val > root.val && q.val > root.val) root = root.right;
            else return root;
        }
        return null;
    }
}
```

### Popular LeetCode Problems on BST

1. **[Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/)**

   - Given a binary tree, determine if it is a valid binary search tree (BST).
2. **[Lowest Common Ancestor of a Binary Search Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)**

   - Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
3. **[Insert into a Binary Search Tree](https://leetcode.com/problems/insert-into-a-binary-search-tree/)**

   - You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion.
4. **[Delete Node in a BST](https://leetcode.com/problems/delete-node-in-a-bst/)**

   - Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
5. **[Kth Smallest Element in a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst/)**

   - Given a binary search tree, write a function to find the kth smallest element in it.
6. **[Convert Sorted Array to Binary Search Tree](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/)**

   - Given an array where elements are sorted in ascending order, convert it to a height-balanced BST.
7. **[Binary Search Tree Iterator](https://leetcode.com/problems/binary-search-tree-iterator/)**

   - Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
8. **[Find Mode in Binary Search Tree](https://leetcode.com/problems/find-mode-in-binary-search-tree/)**

   - Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the BST.

These problems and snippets cover a range of essential BST operations and concepts that will help reinforce your understanding and skills in working with binary search trees.
