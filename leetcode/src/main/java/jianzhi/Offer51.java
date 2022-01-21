package jianzhi;

//剑指 Offer 51. 数组中的逆序对
//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
//
// https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
public class Offer51 {
    int[] nums, tmp;

    public int reversePairs(int[] nums) {
        this.nums = nums;
        tmp = new int[nums.length];
        return mergeSort(0, nums.length - 1);

    }

    private int mergeSort(int l, int r) {
        //递归先写终止条件
        if (l >= r) return 0;
        //递归划分
        int m = l + (r - l) / 2;
        int res = mergeSort(l, m) + mergeSort(m + 1, r);
        //递归的步骤，合并过程
        int i = l, j = m + 1;
        for (int k = l; k <= r; k++) {
            tmp[k] = nums[k];

        }
        for (int k = l; k <= r; k++) {
            if (i == m + 1)
                nums[k] = tmp[j++];
            else if (j == r + 1 || tmp[i] <= tmp[j])
                nums[k] = tmp[i++];
            else {
                nums[k] = tmp[j++];
                res += m - i + 1;//统计逆序对
            }

        }
        return res;
    }


}
