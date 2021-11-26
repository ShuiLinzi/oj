package jianzhi;

//剑指 Offer 28. 对称的二叉树
//请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
//https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
//解题思路：递归判断左右节点是否相等， 以及左的左和右的右以及左的右和右的左是否相等
public class Offer28 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return recur(root.left, root.right);

    }

    private boolean recur(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if (l == null || r == null || l.val != r.val) return false;
        return recur(l.left, r.right) && recur(l.right, r.left);
    }
}
