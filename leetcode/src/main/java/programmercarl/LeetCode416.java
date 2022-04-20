package programmercarl;


/**
 * 分割等和子集问题
 * 转化成01背包问题
 * 目标为背包容量
 * 重量和价值都为 nums[i]
 */
public class LeetCode416 {
    public boolean canPartition(int[] nums) {
        int length = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }
}
