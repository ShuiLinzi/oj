package programmercarl;

public class LeetCode309 {
    public int maxProfit(int[] prices) {
        //买卖股票处于冷冻期无非就是多了一个状态
        //状态0：持有股票所有的最大金额
        //状态1：不持有股票，不在冷冻期的最大金额
        //状态2：不持有股票，在冷冻期的最大金额
        int[] dp = new int[3];
        dp[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[0] = Math.max(dp[0], dp[1] - prices[i]);
            dp[1] = Math.max(dp[2], dp[1]);
            dp[2] = dp[0] + prices[i];
        }
        return Math.max(dp[1], dp[2]);
    }
}
