package jianzhi;

import java.util.LinkedList;

//剑指 Offer 55 - I. 二叉树的深度
//输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
//https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
//树的遍历包括深度优先搜索DFS和广度优先搜索BFS，深度优先遍历包括：先序，中序，后序，广度优先搜索一般为层序遍历
public class Offer55 {
    //方法一，先序遍历
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    //方法二，层序遍历
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> tmp;
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()) {
            tmp = new LinkedList<>();//重新给tmp赋值为空
            for (TreeNode node : queue) {
                if (node.right != null) tmp.add(node.right);
                if (node.left != null) tmp.add(node.left);
            }
            queue = tmp;
            res++;
        }
        return res;
    }
}
