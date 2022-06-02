package programmercarl;

import java.util.Stack;

/**
 * @author cgq
 * 接雨水
 */
public class LeetCode42 {
    public static int trap(int[] height) {
        //接雨水单调栈
        int sum = 0;
        int current = 0;
        Stack<Integer> stack = new Stack<>();
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int n = height[stack.peek()];//接水的凹值
                stack.pop();//出栈
                if (stack.isEmpty()) {
                    break; //栈空无法存雨水，跳出
                }
                int width = current - stack.peek() - 1;
                int min = Math.min(height[current], height[stack.peek()]);
                sum = sum + (min - n) * width;


            }
            stack.push(current);
            current++;

        }
        return sum;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap = trap(height);
        System.out.println(trap);
    }
}
