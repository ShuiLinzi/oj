package jianzhi;

//剑指 Offer 22. 链表中倒数第k个节点
//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
//例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
//https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
//解题思路 就是双指针，一个快，一个慢，快的先走k布，然后后面快慢一起往后走，直到快的指针为空，最后返回的就是最后面的k个节点
public class Offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head, latter = head;
        for (int i = 0; i < k; i++) {
            former = former.next;
        }
        while (former != null) {//former!=null
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }

    //方法二：k--,节省了一个指针的创建，不过时间复杂度，空间复杂度都一样，影响不大
    //这个方法还是挺神奇的，巧妙的利用了数组的长度和k的长度，并且进行了一下差的判断，然后就实现了题目所说的
    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode fast = head;
        while (fast != null) {
            fast = fast.next;
            if (k == 0) return head = head.next;
            else k--;
        }
        return head;
    }
}
