package programmercarl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 这一题和39题有两个区别
 * 1.本题candidates 中的每个数字在每个组合中只能使用一次。
 * 2.本题数组candidates的元素是有重复的，而39.组合总和 (opens new window)是无重复元素的数组candidates
 * 所以解法有点不同
 */
class LeetCode40 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //排序才能确定一样的数据在一起
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, 0);
        return res;
    }

    void backtrack(int[] candidates, int target, int sum, int index) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length && sum + candidates[i] <= target; i++) {//剪枝操作
            //这个if判断是全程mvp，他确保了同一层相同数剪掉，不同层的不剪掉
            //原因很简单，同一层开启第二个遍历的时候，还没进入backtrack递归之前，已经i++了
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            backtrack(candidates, target, sum + candidates[i], i + 1);
            path.remove(path.size() - 1);
        }
    }
}