package programmercarl;

public class LeetCode704 {
    public int search(int nums[], int target) {
        //首先判断特殊情况
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        //找左右下标的边界
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left >> 1);
            if (nums[mid] > target)
                right = mid - 1;
            if (nums[mid] < target)
                left = mid + 1;
            if (nums[mid] == target)
                return mid;
        }
        return -1;
    }
}
