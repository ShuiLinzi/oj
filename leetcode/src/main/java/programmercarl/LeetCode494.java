package programmercarl;

/**
 * @author 陈国庆
 */
public class LeetCode494 {


    /**
     * //此时问题就转化为，装满容量为x背包，有几种方法。
     * //拿第一行为例，只有一个整数nums[0] =1的时候，是装不满容量为4
     * //的背包的，所以此时dp[4] =0;
     * //所以最终转成用1个整数装满+用2个加满+...+最终所有的时候都满的和
     *
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((target + sum) % 2 != 0) {
            return 0;
        }
        int bagSize = (sum + target) / 2;
        if (bagSize < 0) {
            bagSize = -bagSize;
        }
        int[] dp = new int[bagSize + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = bagSize; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[bagSize];
    }
}
