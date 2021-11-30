package jianzhi;

//剑指 Offer 52. 两个链表的第一个公共节点
//输入两个链表，找出它们的第一个公共节点。
//https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
//解题思路：题目描述的意思是，一直循环 A循环完到B，B循环完到A，直到AB有公共节点，没有返回null
public class Offer52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return B;

    }
}
