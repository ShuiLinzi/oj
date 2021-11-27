package jianzhi;
//剑指 Offer 42. 连续子数组的最大和
//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
//
//要求时间复杂度为O(n)。
//要求时间复杂度为On，因此不能暴露循环破解，要使用动态规划，才能达到时间复杂度为On,把nums数组给动态利用上
public class Offer42 {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0 ||nums==null){
            return 0;
        }
        int ans = nums[0];
        for(int i = 1;i<nums.length;i++){
            // nums[i] += nums[i]+nums[i-1]; //加等于其前面的数字，而不是一直相加
            nums[i] += Math.max(nums[i-1],0); //就比较是加上前面的和还是加上0，加上0就是不加
            ans = Math.max(ans,nums[i]);
        }
        return ans;
    }
}
