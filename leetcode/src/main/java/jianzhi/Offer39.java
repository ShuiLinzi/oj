package jianzhi;

//剑指 Offer 39. 数组中出现次数超过一半的数字
//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
//https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
//解题思路：摩尔投票法，依次投票，取出最优解
public class Offer39 {
    public int majorityElement(int[] nums) {
        int res = 0, count = 0;
        for (int i : nums) {
            if (count == 0) {
                res = i;
                //count++;
            }
            //  res == i ? count++ : count--;
            count = count + (res == i ? 1 : -1);
        }
        return res;
    }
}
