package jianzhi;

import java.util.ArrayList;
import java.util.Stack;
//剑指 Offer 06. 从尾到头打印链表
//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

//https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/solution/
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

//方法一:用栈结构解决
class Solution {
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        //压栈
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        //出栈
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pop().val;
        }
        return res;
    }
}

//方法二:递归调用解决
class Solution2 {
    ArrayList<Integer> list = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        recur(head);
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    //递归刚好也是倒叙输出数字
    void recur(ListNode node) {
        //递归三步走
        //递归出口
        if (node == null) {
            return;
        }
        //递归
        recur(node.next);

        //每一层的真正操作
        list.add(node.val);
    }
}