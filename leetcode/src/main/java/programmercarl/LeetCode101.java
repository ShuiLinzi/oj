package programmercarl;

public class LeetCode101 {
    public boolean isSymmetric(TreeNode root) {
        return meger(root.left, root.right);
    }

    private boolean meger(TreeNode left, TreeNode right) {
        if (left != null && right == null) {
            return false;
        }
        if (left == null && right != null) {
            return false;
        }
        if (left == null && right == null) {
            return true;
        }
        if (left.val != right.val) {//必须是不等于，返回false，这样才会继续走下面的判断
            return false;
        }
        boolean b1 = meger(left.left, right.right);
        boolean b2 = meger(left.right, right.left);
        return b1 && b2;
    }
}

