package jianzhi;

import java.util.Date;

//剑指 Offer 54. 二叉搜索树的第k大节点
//给定一棵二叉搜索树，请找出其中第k大的节点。
//https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
//解题思路：中序遍历的逆序得到从大到小，题目是得到第k大的节点，就是逆序的第k个元素，每次遍历一个，k都减一，直到为零，返回输出
public class Offer54 {
    int res, k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        if (k == 0) return;
        if (--k == 0) res = root.val;
        dfs(root.left);
    }


}
