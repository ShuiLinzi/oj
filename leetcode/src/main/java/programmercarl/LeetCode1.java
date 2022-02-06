package programmercarl;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0)
            return new int[0];
        //<num[i],i>
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                res[0] = i;
                res[1] = map.get(temp);
            }
            map.put(nums[i], i);

        }
        return res;
    }
}
