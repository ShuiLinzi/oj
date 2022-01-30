package programmercarl;
//双指针解决问题
public class LeetCode977 {
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] res = new int[nums.length];
        int k = nums.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                res[k--] = nums[left] * nums[left++];
            } else {
                res[k--] = nums[right] * nums[right--];
            }

        }
        return res;
    }
}
