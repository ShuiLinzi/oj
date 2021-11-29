package jianzhi;

//剑指 Offer 18. 删除链表的节点
//给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
//返回删除后的链表的头节点。
//https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
//时间复杂度 On 遍历了链表
//空间复杂度： O1 用了pre和cur的临时变量
//解题思路：其实很简单，这个就是判断是否一样，一样的话就把前一个链表的next指向 后一个节点，就ok了
public class Offer18 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) return head.next; // 如果链表的第一个就是所需要的，直接返回后面的子链，就行了
        ListNode pre = head , cur  = head.next;
        while (cur.next != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if (cur!=null){
            pre.next = cur.next;
        }
        return head;

    }
}
