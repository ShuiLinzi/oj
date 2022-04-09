package programmercarl;

public class LeetCode968 {
    int count = 0;

    public int minCameraCover(TreeNode root) {
        if (trval(root) == 0) {
            count++;
        }
        return count;
    }

    int trval(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int left = trval(root.left);
        int right = trval(root.right);

        if (left == 0 || right == 0) {
            count++;
            return 2;
        }
        if (left == 2 || right == 2) {
            return 1;
        }
        return 0;
    }
}
