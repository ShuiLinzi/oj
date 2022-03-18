package programmercarl;
//二叉搜索树的删除节点

/**
 * TreeNode node = root.right;
 * while (node.left != null) {
 * node = node.left;
 * }
 * node.left = root.left;
 * root = root.right;
 * return root;
 * 核心代码
 */
public class LeetCode450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val == key) {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            else {
                TreeNode node = root.right;
                while (node.left != null) {
                    node = node.left;
                }
                node.left = root.left;
                root = root.right;
                return root;
            }
        }
        if (root.val > key) root.left = deleteNode(root.left, key);
        if (root.val < key) root.right = deleteNode(root.right, key);
        return root;
    }
}