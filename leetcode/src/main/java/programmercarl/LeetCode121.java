package programmercarl;

/**
 * @author 陈国庆
 */
public class LeetCode121 {
    public int maxProfit(int[] prices) {
        //方法二，优化空间之后的
        //优化空间，因为动态规划中状态转移方程里下标为 i 的行只参考下标为 i - 1 的行的话，就可以优化空间，
        int[] dp = new int[2];
        dp[0] = -prices[0];//持有股票
        dp[1] = 0;//不持有股票
        for (int i = 0; i < prices.length; i++) {
            dp[0] = Math.max(-prices[i], dp[0]);
            dp[1] = Math.max(dp[1], prices[i] + dp[0]);
        }
        return dp[1];
    }


    public int maxProfit2(int[] prices) {
        //方法一，一次遍历
        int minPrice = Integer.MAX_VALUE;
        int maxRes = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxRes) {
                maxRes = prices[i] - minPrice;
            }
        }
        return maxRes;
    }

    //方法二，二维dp数组
    public int maxProfit3(int[] prices) {
        if (prices.length == 0 || prices == null) {
            return 0;
        }
        int length = prices.length;
        int[][] dp = new int[length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
        }
        return dp[length - 1][1];
    }
}
