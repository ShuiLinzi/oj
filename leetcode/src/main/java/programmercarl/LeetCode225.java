package programmercarl;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode225 {//用两个队列实现
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public LeetCode225() { //构造器
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();

    }

    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());//实现栈增加的关键步骤
        }
        Queue temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
