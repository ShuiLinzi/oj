package jianzhi;

public class Offer53s {
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == mid) {
                i = mid + 1;//右边
            } else
                j = mid - 1;//左边
        }
        return i;
    }
}
