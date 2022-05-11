package programmercarl;

public class LeetCode188 {
    public int maxProfit(int k, int[] prices) {
        //先进行非空判断
        if (prices.length == 0) {
            return 0;
        }
        //用二维数组更容易表示
        int[][] dp = new int[prices.length][2 * k + 1];
        //初始化第一天,奇数买入，偶数卖出
        for (int i = 1; i < 2 * k + 1; i += 2) {
            dp[0][i] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < 2 * k - 1; j += 2) {
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
            }
        }
        return dp[prices.length - 1][2 * k];
    }
}
