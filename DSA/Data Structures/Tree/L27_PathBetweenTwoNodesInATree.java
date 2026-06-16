class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class PathBetweenTwoNodesInATree {

    private TreeNode lowestCommonAncestor(TreeNode root, int src, int dest) {
        if (root == null || root.val == src || root.val == dest) {
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, src, dest);
        TreeNode right = lowestCommonAncestor(root.right, src, dest);
        
        return left != null && right != null ? root : (left != null ? left : right);
    }

    private int findDistance(TreeNode root, int value, int distance) {
        if (root == null) {
            return -1;
        }

        if (root.val == value) {
            return distance;
        }

        int leftDistance = findDistance(root.left, value, distance + 1);
        if (leftDistance != -1) {
            return leftDistance;
        }

        int rightDistance = findDistance(root.right, value, distance + 1);
        return rightDistance;
    }

    public int distanceBetweenNodes(TreeNode root, int src, int dest) {
        if (root == null) {
            return -1;
        }

        TreeNode LCA = lowestCommonAncestor(root, src, dest);
        int distanceFromLCAtoSrc = findDistance(LCA, src, 0);
        int distanceFromLCAtoDest = findDistance(LCA, dest, 0);

        if (distanceFromLCAtoSrc == -1 || distanceFromLCAtoDest == -1) {
            return -1;
        }

        return distanceFromLCAtoSrc + distanceFromLCAtoDest;
    }

    public static void main(String[] args) {
        // Example usage:
        PathBetweenTwoNodesInATree solution = new PathBetweenTwoNodesInATree();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        int src = 5;
        int dest = 4;

        int distance = solution.distanceBetweenNodes(root, src, dest);
        System.out.println("Distance between nodes " + src + " and " + dest + ": " + distance);
    }
}
