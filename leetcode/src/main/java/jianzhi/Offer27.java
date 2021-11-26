package jianzhi;
//剑指 Offer 27. 二叉树的镜像
//请完成一个函数，输入一个二叉树，该函数输出它的镜像。
//https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
//解题思路：先判断是否为空，为空直接返回null，然后通过递归思想，实现二叉树的镜像翻转，引用临时变量，以免丢失数据
public class Offer27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }
}
