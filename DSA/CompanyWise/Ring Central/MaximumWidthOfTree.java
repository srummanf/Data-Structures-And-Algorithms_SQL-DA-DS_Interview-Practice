/**  Single File Programming Question

Problem Statement


Given the root of a binary tree, return the maximum width of the given tree.


The maximum width of a tree is the full width of all levels.


The width of one level is defined as the length between the end nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.


Example 1:


Input: root = [1,3,2,5,3, null,9]

Output: 4

Explanation: The maximum width exists on the third level with length 4 (5, 3, null, 9).


Example 2:

Input: root = [1,3,2,5, null, null,9,6, null,7]

Output: 7

Explanation: The maximum width exists in the fourth level with length 7 (6, null,null,null, null, null,7).


Example 3:


Input: root = [1,3,2,5]

Output: 2

Explanation: The maximum width exists in the second level with length 2 (3,2).
Input format :

The input consists of a single line containing a comma-separated list of integer values representing the binary tree nodes, where 'null' indicates an empty node.
Output format :

The output prints a single line containing the maximum width of the binary tree.


﻿Refer to the sample output for the formatting specifications.
Code constraints :

In this scenario, the given test cases will fall under the following constraints:

Each value in the input list is either an integer or the string "null".

1 ≤ Elements of binary tree ≤ 9
Sample test cases :
Input 1 :

1,3,2,5,3,null,9

Output 1 :

4

Input 2 :

1,3,2,5

Output 2 :

2

Input 3 :

1,3,2,5,null,null,9,6,null,7

Output 3 :

7
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the input string of integers and nulls separated by commas
        System.out.println("Enter nodes of binary tree (use 'null' for null nodes):");
        String input = scanner.nextLine();
        
        // Convert the input string to ArrayList of Strings
        ArrayList<String> nodes = convertStringToArrayList(input);

        // Convert ArrayList of Strings to List of Integers
        List<Integer> integerList = convertStringListToIntegerList(nodes);

        // Build the binary tree
        Solution solution = new Solution();
        TreeNode root = solution.buildTree(integerList);
        
        // Calculate the maximum width of the binary tree
        int result = solution.widthOfBinaryTree(root);
        System.out.println("Maximum width of the binary tree: " + result);
    }

    // Function to convert a comma-separated string to ArrayList of Strings
    public static ArrayList<String> convertStringToArrayList(String input) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(input.split(",")));
        return list;
    }

    // Function to convert ArrayList of Strings to List of Integers
    public static List<Integer> convertStringListToIntegerList(ArrayList<String> nodes) {
        List<Integer> integerList = new ArrayList<>();
        for (String s : nodes) {
            if (s.trim().equals("null")) {
                integerList.add(null); // Use null for "null" values
            } else {
                integerList.add(Integer.parseInt(s.trim()));
            }
        }
        return integerList;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int maxWidth = 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0)); // Pair(node, index)

        while (!queue.isEmpty()) {
            int size = queue.size();
            int minIndex = queue.peek().getValue(); // Get the index of the first node at the current level
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> pair = queue.poll();
                TreeNode node = pair.getKey();
                int index = pair.getValue() - minIndex; // Normalize the index to avoid overflow

                if (i == 0) first = index;
                if (i == size - 1) last = index;

                if (node.left != null) {
                    queue.add(new Pair<>(node.left, 2 * index));
                }
                if (node.right != null) {
                    queue.add(new Pair<>(node.right, 2 * index + 1));
                }
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;
    }

    // Function to build a binary tree from a list of Integers
    public TreeNode buildTree(List<Integer> nodes) {
        if (nodes == null || nodes.isEmpty()) return null;

        TreeNode root = new TreeNode(nodes.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int index = 1;
        while (index < nodes.size()) {
            TreeNode current = queue.poll();
            if (current == null) continue;

            // Add left child
            if (index < nodes.size() && nodes.get(index) != null) {
                current.left = new TreeNode(nodes.get(index));
                queue.add(current.left);
            } else {
                queue.add(null);
            }
            index++;

            // Add right child
            if (index < nodes.size() && nodes.get(index) != null) {
                current.right = new TreeNode(nodes.get(index));
                queue.add(current.right);
            } else {
                queue.add(null);
            }
            index++;
        }

        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }
    public V getValue() { return value; }
}
