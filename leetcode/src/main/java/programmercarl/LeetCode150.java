package programmercarl;

import java.util.Stack;

public class LeetCode150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if ("+".equals(tokens[i])) {
                stack.push(stack.pop() + stack.pop());
            } else if ("-".equals(tokens[i])) {
                stack.push(-stack.pop() + stack.pop());
            } else if ("*".equals(tokens[i])) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(tokens[i])) {
                int m = stack.pop();
                int n = stack.pop();
                stack.push(n / m);
            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }
}
