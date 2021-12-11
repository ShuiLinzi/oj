package jianzhi;

//剑指 Offer 68 - II. 二叉树的最近公共祖先
//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
// 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
//https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
//此题和上一个题目的区别是，这个题目提供的树不是二叉搜索树，也就是说排序大小不唯一
//题目的意思就是，给定节点p,q 寻找p,q的最近公共祖先，所以说p,q肯定是不变的阿
//解题思路：root节点在二叉树中进行先序遍历，寻找p,q节点，判断是否相等，进行递归循环
public class Offer68s {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p == root || q == root) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;

    }
}
