package jianzhi;


//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode(int x) {
//        val = x;
//    }
//}

import java.util.Stack;

class Solution24 {
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        //压栈
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        //把栈尾tail弹出,并且进行存储
        if (stack.isEmpty()) {
            return null;
        }
        ListNode tail = stack.pop();
        temp = tail;
        //改变链表的顺序
        while (!stack.isEmpty()) {
            temp.next = stack.pop();
            temp = temp.next;
        }
        head.next = null;
        return tail;


    }

    //方法二:双指针反转
    public ListNode reverseList1(ListNode head) {
        ListNode cur = head;
        ListNode next = null;
        ListNode pre = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}