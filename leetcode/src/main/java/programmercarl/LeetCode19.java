package programmercarl;

//删除链表的倒数第N个节点
//解题思路，双指针删除，首先让快指针走n步，然后快慢指针一起走，直到快指针走到链表的最后一个元素
//然后删除慢指针所指向的元素
public class LeetCode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (n-- > 0) {
            fast = fast.next;
        }
        ListNode prev = null;
        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = slow.next;
        return dummy.next;
    }
}
