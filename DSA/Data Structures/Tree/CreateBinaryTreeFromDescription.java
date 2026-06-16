/** You are given a 2D integer array descriptions where descriptions[i] = [parenti, childi, isLefti] indicates that parenti is the parent of childi in a binary tree of unique values. Furthermore,

If isLefti == 1, then childi is the left child of parenti.
If isLefti == 0, then childi is the right child of parenti.
Construct the binary tree described by descriptions and return its root.

The test cases will be generated such that the binary tree is valid.

 

Example 1:


Input: descriptions = [[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]
Output: [50,20,80,15,17,19]
Explanation: The root node is the node with value 50 since it has no parent.
The resulting binary tree is shown in the diagram.
Example 2:


Input: descriptions = [[1,2,1],[2,3,0],[3,4,1]]
Output: [1,2,null,null,3,4]
Explanation: The root node is the node with value 1 since it has no parent.
The resulting binary tree is shown in the diagram.
 

Constraints:

1 <= descriptions.length <= 104
descriptions[i].length == 3
1 <= parenti, childi <= 105
0 <= isLefti <= 1
The binary tree described by descriptions is valid.



 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

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

class Solution {
    /**
     * Creates a binary tree from a list of node descriptions.
     *
     * @param descriptions Array of triples describing the tree. Each triple contains the parent value,
     *                     child value, and a flag to indicate if the child is a left or right child.
     * @return The root of the constructed binary tree.
     */
    public TreeNode createBinaryTree(int[][] descriptions) {
        // Map to store the value and corresponding TreeNode
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
      
        // Set to track visited child nodes
        Set<Integer> visited = new HashSet<>();

        // Loop through each description to build the tree
        for (int[] description : descriptions) {
            int parentValue = description[0];
            int childValue = description[1];
            int isLeftChild = description[2];

			// Ensure that a TreeNode exists for the parentValue
            if (!nodeMap.containsKey(parentValue)) {
                nodeMap.put(parentValue, new TreeNode(parentValue));
            }

            // Ensure that a TreeNode exists for the childValue
            if (!nodeMap.containsKey(childValue)) {
                nodeMap.put(childValue, new TreeNode(childValue));
            }

            // Link parent to child appropriately based on isLeftChild flag
            if (isLeftChild == 1) {
                nodeMap.get(parentValue).left = nodeMap.get(childValue);
            } else {
                nodeMap.get(parentValue).right = nodeMap.get(childValue);
            }

            // Mark the child as visited
            visited.add(childValue);
        }

        // Find the root of the binary tree (the node that was never visited as a child)
        for (Map.Entry<Integer, TreeNode> entry : nodeMap.entrySet()) {
            if (!visited.contains(entry.getKey())) {
                return entry.getValue();
            }
        }

        // In case no root is found (which shouldn't happen if input is valid), return null
        return null;
    }
}