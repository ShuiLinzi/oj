package programmercarl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode216 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(k, n, 1, 0);
        return res;
    }

    void backtrack(int k, int n, int startIndex, int sum) {
        if (sum > n) {
            return;
        }
        if (path.size() == k) {
            if (sum == n)
                res.add(new ArrayList(path));
            return;
        }
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            backtrack(k, n, i + 1, sum);
            //回溯
            path.removeLast();
            //回溯
            sum -= i;
        }
    }
}
