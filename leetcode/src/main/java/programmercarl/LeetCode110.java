package programmercarl;

public class LeetCode110 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        node.left = node1;
        node.right = node2;
        node2.left = node3;
        node2.right = node4;
        boolean balanced = isBalanced(node);
        System.out.println(balanced);
    }

    public static boolean isBalanced(TreeNode root) {
        return balanced(root) != -1;
    }

    private static int balanced(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLength = balanced(root.left);
        if (leftLength == -1) {
            return -1;
        }
        int rightLength = balanced(root.right);
        if (rightLength == -1) {
            return -1;
        }
        if (Math.abs(leftLength - rightLength) > 1) {
            return -1;
        }
        return Math.max(leftLength, rightLength) + 1;
    }
}