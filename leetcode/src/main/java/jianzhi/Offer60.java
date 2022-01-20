package jianzhi;

import java.util.Arrays;

public class Offer60 {
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
            double[] temp = new double[5 * i + 1];
//todo 为完成呢
        }
        return null;
    }
}
