package programmercarl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode77 {
    public static void main(String[] args) {
        LeetCode77 test = new LeetCode77();
        test.combine(4, 2);
        String s = test.res.toString();
        System.out.println(s);
    }

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        //解题思路，回溯+剪枝操作
        backtrack(n, k, 1);
        return res;
    }

    void backtrack(int n, int k, int startIndex) {
        //递归模板
        //判断终止条件
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {//i<n-(k-path.size())+1,进行了剪枝操作
            path.add(i);
            backtrack(n, k, i + 1);
            path.removeLast();
        }
    }
}
