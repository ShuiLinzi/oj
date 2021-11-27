package jianzhi;

//剑指 Offer 63. 股票的最大利润
//假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
//https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
//解题思路，求最大利润，就是找尽可能大的时候出，尽可能小的时候入，进行判断求和。
public class Offer63 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int cost = prices[0], profit = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }
}
