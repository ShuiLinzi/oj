package programmercarl;

public class LeetCode70 {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int sum = 0;
        int a = 1;
        int b = 2;
        for (int i = 3; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }
}
