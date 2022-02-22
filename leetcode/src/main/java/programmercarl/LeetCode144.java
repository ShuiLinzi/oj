package programmercarl;

import java.util.LinkedList;
import java.util.List;

public class LeetCode144 {
    /**
     * 递归三步走
     * 先确定函数变量，返回值
     * 确定终止条件
     * 递归的编写
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        preorder(root, res);
        return res;

    }

    //确定函数变量，返回值
    public void preorder(TreeNode node, List<Integer> res) {
        if (node == null)
            return;//确定终止条件
        //编写递归
        res.add(node.val);
        preorder(node.left, res);
        preorder(node.right, res);
    }
}
