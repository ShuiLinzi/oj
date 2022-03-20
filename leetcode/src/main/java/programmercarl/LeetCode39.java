package programmercarl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode39 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //方法一，没有双重剪枝操作
        if (candidates.length == 0) {
            return res;
        }
        backtrack(candidates, target, 0, 0);
        return res;
    }

    void backtrack(int[] candidates, int target, int sum, int index) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) {
            return;
        }
        //进行递归和回溯
        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            sum += candidates[i];
            backtrack(candidates, target, sum, i);
            path.remove(path.size() - 1);
            sum -= candidates[i];
        }
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //进行剪枝操作，需要排序才能完成
        Arrays.sort(candidates);
        backtrack2(candidates, target, 0, 0);
        return res;

    }

    void backtrack2(int[] candidates, int target, int sum, int index) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        //因为进行了排序剪枝，所以不会大于index，因从也不需要进行判断
        for (int i = index; i < candidates.length; i++) {


            if (sum + candidates[i] > target) {
                break;
            }
            path.add(candidates[i]);
            backtrack(candidates, target, sum + candidates[i], i);
            path.remove(path.size() - 1);
        }
    }
}
