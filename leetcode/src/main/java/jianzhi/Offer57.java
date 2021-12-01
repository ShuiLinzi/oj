package jianzhi;

//剑指 Offer 57. 和为s的两个数字
//输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
//https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
//解题思路：就双指针，一个在左边，一个在右边，两数之和和target比较大小，然后缩短边界，完成条件
public class Offer57 {
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int s = nums[i] + nums[j];
            if (s > target) {
                j--;
            } else if (s < target) i++;
            else return new int[]{nums[i], nums[j]};

        }
        return new int[0];

    }
}
