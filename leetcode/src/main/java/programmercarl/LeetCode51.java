package programmercarl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode51 {//n皇后
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] c : board) {
            Arrays.fill(c, '.');
        }
        backtrack(n, 0, board);
        return res;
    }

    void backtrack(int n, int row, char[][] board) {
        List<String> temp = new ArrayList<>();
        if (row == n) {
            for (char[] c : board) {
                temp.add(String.copyValueOf(c));
            }
            res.add(temp);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(col, row, n, board)) {
                board[row][col] = 'Q';
                backtrack(n, row + 1, board);
                board[row][col] = '.';
            }
        }
    }

    boolean isValid(int col, int row, int n, char[][] board) {
        for (int i = 0; i < row; i++) {//检查列
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}