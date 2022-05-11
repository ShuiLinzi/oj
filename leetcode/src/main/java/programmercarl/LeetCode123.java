package programmercarl;

public class LeetCode123 {
    public int maxProfit(int[] prices) {
        //dp转移方程
        int[] dp = new int[4];
        //0 第一次买入 1第一次卖出 2第二次买入 3第二次卖出
        //第一天不持有为0，不需要初始化
        dp[0] = -prices[0];
        dp[2] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[0] = Math.max(dp[0], -prices[i]);
            dp[1] = Math.max(dp[1], dp[0] + prices[i]);
            dp[2] = Math.max(dp[2], dp[1] - prices[i]);
            dp[3] = Math.max(dp[3], dp[2] + prices[i]);
        }
        return dp[3];
    }
}
