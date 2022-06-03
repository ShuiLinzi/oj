package programmercarl;

import java.util.Collections;
import java.util.Stack;

public class LeetCode84 {
    public static int largestRectangleArea(int[] heights) {
        //整体思路就是当前柱子，往左找小于他的第一根，往右找小于他的第一根，然后求和
        int res = 0;
        int[] new_heights = new int[heights.length + 2];
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i < heights.length + 1; i++) {
            new_heights[i] = heights[i - 1];
        }
        //关键在于比5大的树状，可以进栈，然后最后一起算出，然后就可以求出最大面积了
        for (int i = 0; i < new_heights.length; i++) {
            while (!stack.isEmpty() && new_heights[i] < new_heights[stack.peek()]) {
                int n = new_heights[stack.peek()];
                stack.pop();
                res = Math.max(res, (i - stack.peek() - 1) * n);
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        int i = largestRectangleArea(heights);
        System.out.println(i);

    }
}
