package programmercarl;

public class LeetCode70 {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int sum = 0;
        int a = 1;
        int b = 2;
        for (int i = 3; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }

    public int climbStairs2(int n) {
        //以前我没得选，现在，我要用动态规划跳楼梯！！！！
        int[] weight = new int[]{1, 2};
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int j = 0; j <= n; j++) {
            for (int i = 0; i < weight.length; i++) {
                if (j >= weight[i]) {
                    dp[j] += dp[j - weight[i]];
                }
            }
        }
        return dp[n];
    }
}
