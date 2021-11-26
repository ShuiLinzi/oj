package jianzhi;

//剑指 Offer 10- I. 斐波那契数列
//写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
//递归实现，斐波那契数列
//https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
//解题思路,斐波那契没有用递归实现，而是用动态规划实现，因为这样可以减少重复的计算，使空间复杂度由 O(n)降低到O(1)
//最简单的递归方法，时间复杂度为O（2的n次方），而下面解法的时间复杂度为O(n)
public class Offer10 {
    public int fib(int n) {
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}

//
class Offer10_1 {
    public int numWays(int n) {
        if (n < 1) return 0;
        if (n == 1 || n == 2) return n;
        int pre = 1;
        int res = 2;
        int tmp = 0;
        for (int i = 3; i <= n; i++) {
            tmp = res;
            res = res + pre;
            pre = tmp;
        }
        return res;
    }

}

//母牛产仔问题
class Offer10_2 {
    public int c(int n) {
        if (n<1) return 0;
        return 0;
    }
}
