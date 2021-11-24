package jianzhi;
//剑指 Offer 11. 旋转数组的最小数字
//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
// 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
//https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
//解题思考：由于题目是递增排序数组，可以使用二分查找降低其时间复杂度，通过二分查找，进行三种情况的判断，从而找到最小值
public class Offer11 {
    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (numbers[mid] < numbers[j])
                j = mid;
            else if (numbers[mid] > numbers[j]) {
                i = mid + 1;
            } else j = j - 1;
        }
        return numbers[i];
    }

}
