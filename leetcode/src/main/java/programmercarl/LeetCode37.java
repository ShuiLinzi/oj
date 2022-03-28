package programmercarl;

public class LeetCode37 {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

    boolean backtrack(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                for (char k = '1'; k <= '9'; k++) {
                    if (isValid(i, j, k, board)) {
                        board[i][j] = k;
                        if (backtrack(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    boolean isValid(int row, int col, char k, char[][] board) {
        //判断同行是否重复
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == k) {
                return false;
            }
        }
        //判断列
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == k) {
                return false;
            }
        }
        //判断九宫格
        int startRow = row / 3 * 3;
        int startCol = col / 3 * 3;
        for (int j = startRow; j < startRow + 3; j++) {
            for (int x = startCol; x < startCol + 3; x++) {
                if (board[j][x] == k) {
                    return false;
                }
            }
        }
        return true;
    }
}
