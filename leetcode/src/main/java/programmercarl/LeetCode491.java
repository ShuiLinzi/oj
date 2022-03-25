package programmercarl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode491 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    void backtrack(int[] nums, int index) {
        if (path.size() > 1) {
            res.add(new ArrayList<>(path));
        }
        int[] used = new int[201];
        for (int i = index; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1) || used[nums[i] + 100] == 1) continue;
            //去重的关键操作，如果nums[i]==nums[i+1] 那么最终used[nums[i]]和i+1指向的是同一个位置，
            // 相当于用一个数组代表一个简易的hash表
            used[nums[i] + 100] = 1;
            path.add(nums[i]);
            backtrack(nums, i + 1);
            path.removeLast();
        }
    }
}
