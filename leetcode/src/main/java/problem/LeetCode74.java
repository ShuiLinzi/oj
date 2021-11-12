package problem;

import javax.naming.directory.SearchControls;

//二维数组的二分查找
public class LeetCode74 {
//    public boolean searchMatrix(int[][] matrix, int target) {
//        int line = matrix.length, row = matrix[0].length;
//        int left = 0, high = line * row;
//        while (left <= high) {
//            int mid = left + (high - left) / 2;
//
//        }
//    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int x = matrix[mid / n][mid % n];//mid/n求出二维数组的行，mid%n，求出二维数组的列，然后根据二分法进行求解
            if (x < target) {
                low = mid + 1;
            } else if (x > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//       System.out.println(123);
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}};
        boolean b = searchMatrix(arr, 4);
        System.out.println(b);
    }
}


//
//作者：LeetCode-Solution
//        链接：https://leetcode-cn.com/problems/search-a-2d-matrix/solution/sou-suo-er-wei-ju-zhen-by-leetcode-solut-vxui/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。