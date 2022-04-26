package programmercarl;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Arrays;

public class LeetCode860 {
    public static void main(String[] args) {
//        int[] arr = new int[]{5, 5, 5, 5, 20, 20, 5, 5, 5, 5};
//        int[][] people = new int[12][12];
//        Arrays.sort(people, (a, b) -> {
//            if (a[0] == b[0]) return a[1] - b[1];
//            return b[0] - a[0];
//        });
//        boolean b = lemonadeChange(arr);
//        System.out.println(b);
        int[] nums = new int[]{0, 2, 1, 4, 3, 5, 6, 7, 8, 9};
     //   int judgr = judgr(nums, );
     //   System.out.println(judgr);

    }
    private static int judgr(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        Arrays.sort(nums);
        int count = 0;
        while (left <= right) {
            if (nums[left] + nums[right] == target) {
                count++;
                right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else if (nums[left] + nums[right] > target) {
                right--;
            }

        }
        return count;
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