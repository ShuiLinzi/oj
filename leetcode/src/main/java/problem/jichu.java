package problem;

import java.util.Arrays;

public class jichu {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 2, 1, 4, 3, 5, 6, 7, 8, 9};
        int judgr1 = judgr(nums, 7);
        System.out.println(judgr1);
    }

    private static int judgr(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        Arrays.sort(nums);
        int count = 0;
        while (left <= right) {
            if (nums[left] + nums[right] == target) {
                count++;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else if (nums[left] + nums[right] > target) {
                right--;
            }

        }
        return count;
    }
}
