package jianzhi;

import java.util.HashSet;
import java.util.Set;

//剑指 Offer 03. 数组中重复的数字
//找出数组中重复的数字。
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
//https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
public class Offer03 {
    //方法一用set实现
    public int findRepeatNumber(int[] nums) {
        Set<Integer> dic = new HashSet<>();
        for (int num : nums) {
            if (dic.contains(num)) //如果set集合里面包含重复的数字，说明存在，直接返回，记住set有contains的api，要学会调用
                return num;
            dic.add(num); //不存在就继续添加
        }
        return -1;
    }

    //方法二 原地交换（优点，空间复杂度O(n) ,时间复杂度O(1)）

    //
    public int findRepeatNumber2(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) { //先判断下标和数字是否配对，如果符合 就继续循环
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i]) //此操作是判断是否有重复数字，如果有就返回
                return nums[i];
            int temp = nums[i];//如果没有，就交换数字
            nums[i] = nums[temp];
            nums[temp] = temp;
        }
        return -1;
    }

}
