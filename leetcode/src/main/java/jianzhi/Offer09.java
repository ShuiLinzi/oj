package jianzhi;

import java.util.Stack;

//用两个栈实现队列
//用两个栈实现队列，一个栈用来存放元素，另一个栈用来删除元素
class CQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty()) { //如果第二个栈不为空，直接弹出来
            return stack2.pop();
        } else {
            while (!stack1.isEmpty()) { //第二个栈为空
                stack2.push(stack1.pop());
            }
            return stack2.isEmpty() ? -1 : stack2.pop();
        }
    }
}
