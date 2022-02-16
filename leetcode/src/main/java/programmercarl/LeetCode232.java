package programmercarl;

import java.util.Stack;

public class LeetCode232 {
    private Stack<Integer> a;
    private Stack<Integer> b;
    public LeetCode232() {
        a = new Stack<>();//输入栈
        b = new Stack<>();//输出栈
    }

    public void push(int x) {
        a.add(x);
    }

    public int pop() {
        if(b.isEmpty() ){
            while(!a.isEmpty()){
                b.push(a.pop());
            }
        }
        return b.pop();
    }

    public int peek() {
        if(b.isEmpty() ){
            while(!a.isEmpty()){
                b.push(a.pop());
            }
        }
        return b.peek();
    }
    public boolean empty() {
        return a.isEmpty() && b.isEmpty();
    }


}
