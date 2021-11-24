package jianzhi;

//剑指 Offer 04. 二维数组中的查找
//在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
//解题思路，使二维数组的最左下的一个数字为flag数字，然后通过循环比较与target的大小，进行下标改变，直到找到目标数字
//时间复杂度：由于一次对一行或者一列数字操作，所以时间复杂度为O(M+N)
//空间复杂度：显然是O(1)
public class Offer4 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;//i是越来越小，j是越来越大
        while (i >= 0 && j <= matrix[0].length - 1) {//判断条件，当flag数字下标越界的时候结束循环
            if (matrix[i][j] > target)
                i--;
            else if (matrix[i][j] < target)
                j++;
            else return true;
        }


        return false;
    }

}
