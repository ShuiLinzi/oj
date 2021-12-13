package jianzhi;

//剑指 Offer 16. 数值的整数次方
//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，x的n次方）。不得使用库函数，同时不需要考虑大数问题。
//https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
//解题思路：好难，完全写不出来阿，必须用给的答案，泪目了，画图画一下很清晰。但是自己怎么能写出来呢
public class Offer16 {
    public double myPow(double x, int n) {
        if (x == 0.0f) return 0.0d;
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }

        while (b > 0) {
            //判断是否为奇数，为奇数多成一次x
            if ((b & 1) == 1) res = res * x;//判断是否为奇数
            x *= x;
            b >>= 1;//除以2向
        }
        return res;
    }

    public static void main(String[] args) {
        Offer16 offer16 = new Offer16();
        double v = offer16.myPow(3.0, 7);
        System.out.println(v);
    }
}
