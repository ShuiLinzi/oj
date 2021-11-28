package jianzhi;

//剑指 Offer 46. 把数字翻译成字符串
//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。
// 请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
//https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
//解题思路，动态规划，
//状态定义： 设动态规划列表 dp，dp[i]代表以 x_ix为结尾的数字的翻译方案数量。
//初始状态：如下
//转移方程：为什么：画图一目了然，无论两个数字组合起来是否满足条件，都能和dp[i-1]组合一起，当两个数字组合起来小于26个英文字母的时候，还能组合成二位数和dp[i-2]组合起来
//时间复杂度：On, n为字符串 s 的长度（即数字 num 的位数 \log(num)log(num) ），其决定了循环次数。
//空间复杂度： 字符串 s 使用 O(N) 大小的额外空间。
public class Offer46 {
    public int translateNum(int num) {
        String s = String.valueOf(num);//把传递过来的数字转化成字符串
        int a = 1, b = 1;//初始状态，为什么是int型，因为这是要返回的数值
        //转移方程 👇
        //dp[i] = dp[i-1]+dp[i-2]当两个数字组合起来小于二十六个英文字母的时候 或者 dp[i] = dp[i-1]当两个数字组合起来大于二十六个英文字母的时候
        for (int i = 2; i < s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }
}
