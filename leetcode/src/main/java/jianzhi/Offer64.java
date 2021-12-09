package jianzhi;

//剑指 Offer 64. 求1+2+…+n
//求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
//https://leetcode-cn.com/problems/qiu-12n-lcof/
//解题思路：不能使用if 之类的，可以用逻辑判断符合的短路特点，来决定递归的出口
public class Offer64 {
    public int sumNums(int n) {
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
