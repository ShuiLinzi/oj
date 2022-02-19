package programmercarl;

import java.util.LinkedList;

public class LeetCode239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2) return nums;
        //双向队列，保存当前窗口最大值的数组位置，保证队列中数组位置的数值从大到小排序
        LinkedList<Integer> queue = new LinkedList();
        //结果数组
        int[] res = new int[nums.length - k + 1];
        //便利nums数组
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            //添加当前值对应的数组下标
            queue.addLast(i);
            //判断当前队列中队首的值是否有效
            if (queue.peek() <= i - k) {
                queue.poll();
            }
            //当窗口长度为k时，保存当前窗口中的最大值
            if (i + 1 >= k) {
                res[i + 1 - k] = nums[queue.peek()];
            }
        }

        return res;
    }

}
