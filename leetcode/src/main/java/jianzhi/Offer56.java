package jianzhi;

//^ 异或 ----相当于 无进位的求和， 想象10进制下的模拟情况：
// （如:19+1=20；无进位求和就是10，而非20；因为它不管进位情况）
//
//& 与 ----相当于求每位的进位数， 先看定义：1&1=1；1&0=0；0&0=0；即都为1的时候才为1，
// 正好可以模拟进位数的情况,还是想象10进制下模拟情况：
// （9+1=10，如果是用&的思路来处理，则9+1得到的进位数为1，而不是10，所以要用<<1向左再移动一位，这样就变为10了）；
//解题思路：先把数组中的每一个数字异或一次，得到一个数，然后找到该数字的位上第一个位为1的，然后根据这一位，把数组
//中的数字，分成两组，在分别异或，求出这两个数字
public class Offer56 {
    public int[] singleNumbers(int[] nums) {
        int x = 0, y = 0, n = 0, m = 1;
        for (int num : nums)
            n ^= num;       //把数组的每一个异或一次，得到那两个数字的异或的值
        while ((n & m) == 0) {
            m <<= 1;    //找到结果右边的第一位 为1的

        }
        for (int num : nums) {
            if ((num & m) == 0) x ^= num;
            else y ^= num;
        }
        return new int[]{x, y};
    }
}
