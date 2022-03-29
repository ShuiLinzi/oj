package programmercarl;

public class LeetCode376 {
    //插值计算
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int pre = 0;
        int cur = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            cur = nums[i] - nums[i - 1];
            if ((cur > 0 && pre <= 0) || (cur < 0 && pre >= 0)) {
                count++;
                pre = cur;
            }
        }
        return count;
    }
}
