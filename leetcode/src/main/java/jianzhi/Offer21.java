package jianzhi;

//剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
//https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
//
public class Offer21 {
    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1, tmp;
        while (i < j) {
            //while语句里面仍要判断，i < j
            while (i < j && (nums[i] & 1) == 1) i++;//nums[i] & 1) == 1 代表这个数为奇数，跳过，直到为偶数停止
            while (i < j && (nums[j] & 1) == 0) j--;//(nums[j] & 1) == 0代表这个数为偶数，跳过，直到为奇数停止
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }
}
