package jianzhi;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//剑指 Offer 61. 扑克牌中的顺子
//从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
// 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
//https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
//解题思路：真的是巧解 妙啊，
public class Offer61 {
    public boolean isStraight(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int min = 14, max = 0;
        for (int num : nums) {
            if (num == 0) continue;
            max = Math.max(num, max);
            min = Math.min(num, min);
            if (repeat.contains(num)) return false;
            repeat.add(num);
        }
        return max - min < 5;
    }

    //解题思路：和上面的解题思路一样，唯一的区别就是nums[nums.length-1] - nums[joker] <5; 理由必须减去nums[joker]，因为[0,0,1,2,5]错误示例，自己理解
    public boolean isStraight2(int[] nums) {
        int joker = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) joker++; //用来进行下标判断的
            else if (nums[i] == nums[i + 1]) return false;//有除开零之外的重复数字，直接返回false，肯定不符合题意
        }
        return nums[nums.length - 1] - nums[joker] < 5;
    }

}
