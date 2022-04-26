package programmercarl;

import java.util.Arrays;

public class LeetCode322 {
    public static void main(String[] args) {
        int i = coinChange(new int[]{2}, 3);
        System.out.println(i);
    }

    public static int coinChange(int[] coins, int amount) {
        //定义最大值为int所接受的最大值，最大值+1就成了最小值了
        int max = Integer.MAX_VALUE;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != max) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}
