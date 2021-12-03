package jianzhi;

import java.util.LinkedList;
import java.util.List;

//剑指 Offer 34. 二叉树中和为某一值的路径
//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
//叶子节点 是指没有子节点的节点。
//https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
//解题思路：递归先序遍历，判断是否满足题意
public class Offer34 {
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        recur(root, target);
        return res;
    }

    private void recur(TreeNode root, int target) {
        if (root == null) return;
        path.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null)
            res.add(new LinkedList<>(path));
        recur(root.left, target);
        recur(root.right, target);
        path.removeLast(); //递归不成功，就把list里面的最后一个元素消除掉
    }
}
