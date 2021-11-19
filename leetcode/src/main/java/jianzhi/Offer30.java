package jianzhi;

import java.util.Stack;

/**
 * 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/solution/mian-shi-ti-30-bao-han-minhan-shu-de-zhan-fu-zhu-z/
 */
class MinStack {

    Stack<Integer> A, B;

    public MinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }

    /**
     * push(x) 函数： 重点为保持栈 BB 的元素是 非严格降序 的。
     * <p>
     * 将 xx 压入栈 AA （即 A.add(x) ）；
     * 若 ① 栈 BB 为空 或 ② xx 小于等于 栈 BB 的栈顶元素，则将 xx 压入栈 BB （即 B.add(x) ）。
     */
    public void push(int x) {
        A.push(x);//添加元素的时候，A无脑加
        if (B.empty() || B.peek() >= x) {//由于B栈的作用就是使min函数的时间复杂度为O1，所以要保持栈顶为非严格降序的最小值，所以要进行判断
            B.push(x);  //B.peek() >= x  表示重复最小x也要压栈，避免了重复最小值被弹出。
        }
    }

    public void pop() {
        //保持AB栈的一致性
        if (A.pop().equals(B.peek())) {//弹出栈的时候，A无脑弹出就行，但是B要确定自己栈顶的最小元素有没有被弹出，因此确定一下，如果相同，那么B也被弹出
            B.pop();
        }
    }

    public int top() {
        return A.peek();
    }

    public int min() {//B栈栈顶保存的总是A栈的最小值，因此取最小的时候，直接把B栈栈顶弹出
        return B.peek();
    }
}