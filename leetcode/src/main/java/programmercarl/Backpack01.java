package programmercarl;


public class Backpack01 {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagsize = 4;
        backpack02(weight, value, bagsize);
    }
    //一维数组背包解法
    public static void backpack02(int[] weight, int[] value, int bagweight) {
        //dp数组，下标代表背当前包容量，所以要+1
        int[] dp = new int[bagweight + 1];
        int length = weight.length;
        //先遍历物品
        for (int i = 0; i < length; i++) {
            //判断是否能放物品i，如果不能就跳过，如果能，就走dp方程
            for (int j = bagweight ; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }//打印dp数组
        for (int j = 0; j <= bagweight; j++){
            System.out.print(dp[j] + " ");
        }
    }

    //二位背包解法
    public static void backpack01(int[] weight, int[] value, int bagweight) {
        int[][] dp = new int[weight.length + 1][bagweight + 1];
        //先初始化背包的行和列
        for (int i = weight[0]; i <= bagweight; i++) {
            dp[0][i] = value[0];
        }
        //从1开始是因为已经初始化了
        for (int i = 1; i < weight.length; i++) {
            //j=0是因为我们没有初始化列为0，如果提前初始化j=0，我们可以从j=1开始循环
            for (int j = 0; j <= bagweight; j++) {
                //如果放不下物品[i]，那么肯定不放，所以dp值等于放上一个物品的值
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //物品放得下，但是也可以不放物品，所以取不放物品 和 放了物品比较最大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }

        }
        //打印dp数组
        int wlen = weight.length, value0 = 0;
        for (int m = 0; m <= wlen; m++) {
            for (int j = 0; j <= bagweight; j++) {
                System.out.print(dp[m][j] + " ");
            }
            System.out.print("\n");
        }
    }




    public static void testweightbagproblem(int[] weight, int[] value, int bagsize) {
        int wlen = weight.length, value0 = 0;
        //定义dp数组：dp[i][j]表示背包容量为j时，前i个物品能获得的最大价值
        int[][] dp = new int[wlen + 1][bagsize + 1];
        //初始化：背包容量为0时，能获得的价值都为0
        for (int i = 0; i <= wlen; i++) {
            dp[i][0] = value0;
        }
        //遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 1; i <= wlen; i++) {
            for (int j = 1; j <= bagsize; j++) {
                if (j < weight[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
            }
        }
        //打印dp数组
        for (int i = 0; i <= wlen; i++) {
            for (int j = 0; j <= bagsize; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
