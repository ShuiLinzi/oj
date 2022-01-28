package programmercarl;

public class LeetCode34 {
    int[] searchRange(int nums[], int target) {
        int leftBorder = getLeftBorder(nums, target);
        int rightBorder = getRightBorder(nums, target);
        if (leftBorder == -2 || rightBorder == -2)
            return new int[]{-1, -1};
        if (rightBorder - leftBorder > 1)
            return new int[]{leftBorder + 1, rightBorder - 1};
        return new int[]{-1, -1};
    }

    int getRightBorder(int[] nums, int target) {
        int left = 0, right = nums.length - 1, rightBorder = -2;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
                rightBorder = left;
            }
        }
        return rightBorder;
    }

    int getLeftBorder(int[] nums, int target) {
        int left = 0, right = nums.length - 1, leftBorder = -2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                right = mid + 1;
            } else {
                left = mid - 1;
                leftBorder = left;
            }
        }
        return leftBorder;
    }
//上面是超时解法

    int[] searchRange1(int nums[], int target) {
        int search = binarySearch(nums, target);
        if (search == -1) return new int[]{-1, -1};
        int left = search, right = search;//定义两个边界滑动数组
        while (left - 1 >= 0 && nums[search] == nums[left - 1]) {
            left--;
        }
        while (right + 1 <= nums.length - 1 && nums[search] == nums[right + 1]) {
            right++;
        }
        return new int[]{left, right};
    }

    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 不变量：左闭右闭区间

        while (left <= right) { // 不变量：左闭右闭区间
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1; // 不变量：左闭右闭区间
            }
        }
        return -1; // 不存在
    }
}

