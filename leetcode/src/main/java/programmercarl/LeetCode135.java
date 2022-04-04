package programmercarl;

public class LeetCode135 {
    public int candy(int[] ratings) {
        //贪心算法，从左边循环一次，再从右边循环一次，找到糖果最大值
        int[] res = new int[ratings.length];
        res[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                res[i] = res[i - 1] + 1;
            } else res[i] = 1;
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                //   res[i] = res[i+1]+1;
                res[i] = Math.max(res[i], res[i + 1] + 1);
            }
        }
        int sum = 0;
        for (int n : res) {
            sum += n;
        }
        return sum;
    }
}
