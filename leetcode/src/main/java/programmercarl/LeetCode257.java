package programmercarl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode257 {
    public List<String> binaryTreePaths(TreeNode root) {//递归加回溯解决问题
        List<String> res = new ArrayList<>();
        LinkedList<String> path = new LinkedList<>();
        dfs(root, res, path);
        return res;
    }

    private void dfs(TreeNode root, List<String> res, LinkedList<String> path) {
        path.add(String.valueOf(root.val));
        //递归结束条件
        if (root.left == null && root.right == null) {
            res.add(String.join("->", path));
            return;
        }
        if (root.left != null) {
            dfs(root.left, res, path);
            path.removeLast();//回溯
        }
        if (root.right != null) {
            dfs(root.right, res, path);
            path.removeLast();//回溯
        }
    }
}
