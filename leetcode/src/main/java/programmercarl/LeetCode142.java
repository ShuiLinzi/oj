package programmercarl;

//142. 环形链表 II
//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null
//解题思路:双指针一个块一个慢
//先找环，一定先找到相遇的点，然后一个从相遇的点出发一个从头出发，最终相遇一定是环的入口
public class LeetCode142 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;//一次走两步
            if (slow == fast) {//说明有环，进入了循环
                ListNode index1 = head;
                ListNode index2 = fast;
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
