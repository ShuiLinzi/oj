package programmercarl;

public class LeetCode110 {
    public boolean isBalanced(TreeNode root) {
        return balanced(root) != -1;
    }

    private int balanced(TreeNode root) {
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