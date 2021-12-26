package jianzhi;

//剑指 Offer 15. 二进制中1的个数
//编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量)。
//https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
//解题思路：进行位运算，如果与上1为1，则说明最右边的数字为1，然后进行++循环
public class Offer15 {
    public int hammingWeight(int n) {
        int flag = 0;
        while (n != 0) {
            flag += n & 1;
            n >>>= 1;
        }
        return flag;
    }
}
