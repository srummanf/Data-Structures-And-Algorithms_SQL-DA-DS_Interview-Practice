/**
 * You are given two binary search trees. Your task is to check whether the two BSTs contains the same set of elements or not.

The structure of the two given BSTs can be different.

Note: All elements in a given BST are unique.

For Example:

The above two BSTs contain the same set of elements, hence the answer is True.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 100 
1 <= N <= 1000

Time Limit: 1 sec
Sample Input 1:
2
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
10 5 -1 -1 2 8 -1 -1 6 -1 -1 
26 -1 52 -1 78 -1 -1 
26 -1 52 -1 78 -1 -1
Sample Output 1:
false
true 
 */

import java.util.HashSet;

class TreeNode<T> {
    T data;
    TreeNode<T> left, right;

    TreeNode(T item) {
        data = item;
        left = right = null;
    }
}

public class SameBST {
    // Method to traverse the tree and add elements to the HashSet
    public static void traverse(TreeNode<Integer> root, HashSet<Integer> set) {
        if (root != null) {
            traverse(root.left, set);
            set.add(root.data);
            traverse(root.right, set);
        }
    }

    // Method to check if two BSTs contain the same set of elements
    public static Boolean checkBSTs(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        
        traverse(root1, set1);
        traverse(root2, set2);
        
        return set1.equals(set2);
    }

    public static void main(String[] args) {
        // Example inputs
        TreeNode<Integer> root1 = new TreeNode<>(80);
        root1.left = new TreeNode<>(64);
        root1.left.left = new TreeNode<>(48);
        root1.left.left.left = new TreeNode<>(32);
        root1.left.left.left.left = new TreeNode<>(16);

        TreeNode<Integer> root2 = new TreeNode<>(80);
        root2.left = new TreeNode<>(64);
        root2.left.left = new TreeNode<>(48);
        root2.left.left.left = new TreeNode<>(32);
        root2.left.left.left.left = new TreeNode<>(16);

        TreeNode<Integer> root3 = new TreeNode<>(13);
        root3.right = new TreeNode<>(26);
        root3.right.right = new TreeNode<>(39);
        root3.right.right.right = new TreeNode<>(52);
        root3.right.right.right.right = new TreeNode<>(65);
        root3.right.right.right.right.right = new TreeNode<>(78);

        TreeNode<Integer> root4 = new TreeNode<>(13);
        root4.right = new TreeNode<>(26);
        root4.right.right = new TreeNode<>(39);
        root4.right.right.right = new TreeNode<>(52);
        root4.right.right.right.right = new TreeNode<>(65);
        root4.right.right.right.right.right = new TreeNode<>(68);

        TreeNode<Integer> root5 = new TreeNode<>(11);
        root5.right = new TreeNode<>(22);
        root5.right.right = new TreeNode<>(33);
        root5.right.right.right = new TreeNode<>(44);
        root5.right.right.right.right = new TreeNode<>(55);
        root5.right.right.right.right.right = new TreeNode<>(66);
        root5.right.right.right.right.right.right = new TreeNode<>(77);

        TreeNode<Integer> root6 = new TreeNode<>(11);
        root6.right = new TreeNode<>(22);
        root6.right.right = new TreeNode<>(33);
        root6.right.right.right = new TreeNode<>(44);
        root6.right.right.right.right = new TreeNode<>(55);
        root6.right.right.right.right.right = new TreeNode<>(66);
        root6.right.right.right.right.right.right = new TreeNode<>(77);
        root6.right.right.right.right.right.right.left = new TreeNode<>(56);

        // Test cases
        System.out.println(checkBSTs(root1, root2)); // true
        System.out.println(checkBSTs(root3, root4)); // false
        System.out.println(checkBSTs(root5, root6)); // false
    }
}
