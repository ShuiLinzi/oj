package stack;

//最简单基础的二分查找
public class BinarySearch {
    public int binarySearch(int[] nums, int target) {
        //定义左右都闭合的区间[l , r]
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target) {
                left = mid + 1;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            }

        }
        return -1;
    }

    //查找目标最左边的二分
    public int binarySearchLeft(int[] nums, int target) {
        // 搜索区间为 [left, right]
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right]
                left = mid + 1;
            }
            if (nums[mid] > target) {
                // 搜索区间变为 [left, mid-1]
                right = mid - 1;
            }
            if (nums[mid] == target) {
                // 收缩右边界
                right = mid - 1;
            }
        }
        // 检查是否越界
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }

    //
}
