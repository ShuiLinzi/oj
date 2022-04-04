package programmercarl;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Arrays;

public class LeetCode860 {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 5, 5, 5, 20, 20, 5, 5, 5, 5};
        int[][] people = new int[12][12];
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
        boolean b = lemonadeChange(arr);
        System.out.println(b);

    }

    public static boolean lemonadeChange(int[] bills) {
        int bill5 = 0;
        int bill10 = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) bill5++;
            else if (bills[i] == 10) {
                bill5--;
                bill10++;
            } else {
                if (bill10 > 0) {
                    bill10--;
                    bill5--;
                } else bill5 -= 3;
            }
            if (bill5 < 0 || bill10 < 0) return false;//每次走一个循环的时候都要进行判断是否符合题意
        }

        return true;
    }
}