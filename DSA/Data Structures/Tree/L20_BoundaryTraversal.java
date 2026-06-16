class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode() {}

    TreeNode(int val) { this.val = val; }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class L20_BoundaryTraversal {

    private static void printLeaves(TreeNode root) {
        if (root != null) {
            printLeaves(root.left);
            if (root.left == null && root.right == null) {
                System.out.print(root.val + " ");
            }
            printLeaves(root.right);
        }
    }

    private static void printBoundaryLeft(TreeNode root) {
        if (root != null) {
            if (root.left != null) {
                System.out.print(root.val + " ");
                printBoundaryLeft(root.left);
            } else if (root.right != null) {
                System.out.print(root.val + " ");
                printBoundaryLeft(root.right);
            }
        }
    }

    private static void printBoundaryRight(TreeNode root) {
        if (root != null) {
            if (root.right != null) {
                printBoundaryRight(root.right);
                System.out.print(root.val + " ");
            } else if (root.left != null) {
                printBoundaryRight(root.left);
                System.out.print(root.val + " ");
            }
        }
    }

    public static void boundaryTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            printBoundaryLeft(root.left);
            printLeaves(root.left);
            printLeaves(root.right);
            printBoundaryRight(root.right);
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
