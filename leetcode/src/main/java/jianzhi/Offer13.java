package jianzhi;
//剑指 Offer 13. 机器人的运动范围
//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
// 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
// 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
//https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/

import java.util.Date;

public class Offer13 {
    public int movingCount(int m, int n, int k) {
        if (k == 0) return 1;
        boolean[][] vis = new boolean[m][n];
        int ans = 1;
        vis[0][0] = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0 || get(i) + get(j) > k) {
                    continue;
                }
                if (i - 1 >= 0) {
                    vis[i][j] |= vis[i - 1][j];
                }
                if (j - 1 >= 0) {
                    vis[i][j] |= vis[i][j - 1];
                }
                ans += vis[i][j] ? 1 : 0;
            }
        }
        return ans;
    }

    //得到位数之和
    private int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x = x / 10;
        }
//        System.out.printf("%8.2f", x);
        return res;
    }

    public int movingCount2(int m, int n, int k) {
        boolean[][] vis = new boolean[m][n];
        return dfs(vis, m, n, k, 0, 0);
    }

    private int dfs(boolean[][] vis, int m, int n, int k, int i, int j) {
        if (i >= m || j >= n || get(i) + get(j) > k || vis[i][j]) return 0;
        vis[i][j] = true;
        return 1 + dfs(vis, m, n, k, i + 1, j) + dfs(vis, m, n, k, i, j + 1);

    }

    public static void main(String[] args) {
        System.out.printf("%tm",new Date());
    }
}
