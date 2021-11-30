package jianzhi;

//剑指 Offer 25. 合并两个排序的链表
//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
//https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
//解题思路： 创建一个链表比较大小，进行循环，比较大小
public class Offer25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //0是指新建链表的数值
        ListNode dum = new ListNode(0), cur = dum; //创建一个伪头节点
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2; //这一步的作用是，当l1或者l2中的其中一个为空跳出循环之后，肯定还有另外一个不是为空，要把它直接加上cur之中
        return dum.next;


    }

    //递归解法
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        else if (l2 == null) return l1;
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
