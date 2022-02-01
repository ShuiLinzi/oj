package programmercarl;

public class LeetCode69 {
    public int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, s = 0, x = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while (num <= tar) {
            for (int i = l; i <= r; i++) {
                mat[s][i] = num++;
            }
            s++;
            for (int i = s; i <= x; i++) {
                mat[i][r] = num++;
            }
            r--;
            for (int i = r; i >= l; i--) {
                mat[x][i] = num++;
            }
            x--;
            for (int i = x; i >= s; i--) {
                mat[i][l] = num++;
            }
            l++;

        }
        return mat;
    }
}
