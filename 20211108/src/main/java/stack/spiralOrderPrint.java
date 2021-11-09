package stack;

public class spiralOrderPrint {
    public static void spiraOrderPrint(int[][] matrix) {
        int row1 = 0;
        int col1 = 0;
        int row2 = matrix.length - 1;
        int col2 = matrix[0].length - 1;
        while (row1 <= row2 && col1 <= col2) {
            printEdge(matrix, row1++, col1++, row2--, col2--);
        }
    }

    private static void printEdge(int[][] matrix, int row1, int col1, int row2, int col2) {
        if (row1 == row2) {
            for (int i = col1; i <= col2; i++) {
                System.out.println(matrix[row1][i] + " ");
            }
        } else if (col1 == col2) {
            for (int i = row1; i <= row2; i++) {
                System.out.println(matrix[i][col1] + " ");

            }
        }else {

        }
    }
}
