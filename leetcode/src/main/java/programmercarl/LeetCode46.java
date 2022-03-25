package programmercarl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//全排列，回溯+used[]数组
public class LeetCode46 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;

    public static void main(String[] args) {
        LeetCode46 leetCode46 = new LeetCode46();
        leetCode46.permute(new int[]{1, 2, 3});
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return res;
        }
        used = new boolean[nums.length];
        backtrack(nums);
        return res;
    }

    void backtrack(int[] nums) {
        if (nums.length == path.size()) {
            for (int m : path) {
                System.out.print(m + " ");
            }
            System.out.println();
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == true) continue;
            used[i] = true;
            path.add(nums[i]);
            backtrack(nums);
            used[i] = false;
            path.removeLast();
        }
    }
}
