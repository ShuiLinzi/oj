package problem;

//最最最简单标准的二分查找
public class LeetCode704 {
    public int search(int[] nums, int target) {
        int left = 0;//左
        int length = nums.length - 1;//右
        while (left <= length) {
            int mid = left + (length - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                //    mid = length - 1;//改变的是左右边界啊，卧槽，我怎么改成mid了
                length = mid - 1;

            } else
                //    mid = left + 1;
                left = mid + 1;
        }
        return -1;
    }
}
