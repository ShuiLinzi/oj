package jianzhi;

//剑指 Offer 53 - I. 在排序数组中查找数字 I
//统计一个数字在排序数组中出现的次数。
//双重二分，判断下标（目标的右边界），然后相减，得出问题的答案
//https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
public class Offer53 {
    public int search(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }

    private int helper(int[] nums, int tar) {//tar是目标数字，先找到目标数字的有边界，再找到目标数字-1的右边界
        int i = 0;
        int length = nums.length - 1;
        while (i <= length) {
            int mid = i + (length - i);
            if (nums[mid] <= tar) {
                i = mid + 1;//右边
            } else {
                length = mid - 1;//左边
            }
        }
        return i;//为啥i是右边界的大小呢，因为当i==tar的时候，仍进行了加一操作，所以是目标数字的右边的一个下标
    }

    public static void main(String[] args) {


    }
}
