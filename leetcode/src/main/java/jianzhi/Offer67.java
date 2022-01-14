package jianzhi;

//剑指 Offer 67. 把字符串转换成整数
//写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
//https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/
//解题思路：和剑指offer20一样，把每一个测试用例都考虑进去
public class Offer67 {
    public int strToInt(String str) {
        str = str.trim();
        if (str.length() == 0) return 0;
        char[] c = str.toCharArray();
        //判断符号 + - .
        int lj = Integer.MAX_VALUE / 10;//临界值
        int res = 0;
        int i = 0;//开始的位置
        int sign = 1;//正负号
        //确定正负号
        if (c[0] == '-') {
            sign = -1;
        }
        //确定开始的符号
        if (c[0] == '+' || c[0] == '-') {
            i = 1;
        }
        for (int j = i; j < c.length; j++) {
            if (c[j] < '0' || c[j] > '9')
                break;
            //判断是否超出范围，若超出范围直接返回最大最小值
            if (res > lj || (res == lj && c[j] > '7')) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            //计算值
            res = res * 10 + (c[j] - '0');

        }
        return res * sign;
    }
}
