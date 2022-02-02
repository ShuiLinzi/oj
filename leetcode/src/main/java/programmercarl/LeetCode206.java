package programmercarl;

//可以使用双指针方法来反转链表
public class LeetCode206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;//保存
            cur.next = pre;//反转
            pre = cur;//后移
            cur = temp;//后移
        }
        return pre;

    }

    //递归解决反转链表
    public ListNode reverseList1(ListNode head) {
        return reverse(null, head);
    }

    private ListNode reverse(ListNode pre, ListNode cur) {
        if (cur == null) return pre;
        ListNode temp = null;
        temp = cur.next;
        cur.next = pre;
        return reverse(cur, temp);
    }
}
