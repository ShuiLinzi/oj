package programmercarl;

import java.util.HashSet;
import java.util.Set;

public class LeetCode202 {
    public boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();
        while (n != 1 && !record.contains(n)) {
            record.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }

    private int getNextNumber(int n) {
        int res = 0;
        while (n > 0) {
            int x = n % 10;//个位数
            res += x * x;
            n = n / 10;
        }
        return res;
    }

}
