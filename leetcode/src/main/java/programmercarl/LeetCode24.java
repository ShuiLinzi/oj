package programmercarl;

import com.sun.xml.internal.messaging.saaj.soap.name.NameImpl;

//两两交换链表中的节点
public class LeetCode24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);//链表问题要创建虚拟节点
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null && pre.next.next != null) {
            ListNode node1 = pre.next;
            ListNode node2 = pre.next.next;
            pre.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            pre = node1;
        }
        return dummy.next;
    }
}
