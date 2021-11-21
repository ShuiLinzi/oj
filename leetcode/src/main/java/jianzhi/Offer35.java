package jianzhi;

import java.util.HashMap;
//剑指 Offer 35. 复杂链表的复制
//请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
//https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

//方法一 hashmap<node,node>实现
public class Offer35 {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node temp = head;
        //把链表复制到hashmap的值里面
        while (temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        //开始复制链表
        temp = head;
        while (temp != null) {
            map.get(temp).next = map.get(temp.next);//复制next指针
            //复制random节点
            map.get(temp).random = map.get(temp.random);
            temp = temp.next;

        }
        //返回新链表的头节点
        return map.get(head);
    }

    //方法二:
    public Node copyRandomList1(Node head) {
        Node temp = head;
        //判空
        if (head == null) {
            return null;
        }
        //合并链表
        while (temp != null) {
            Node copy = new Node(temp.val);
            copy.next = temp.next;
            temp.next = copy;
            temp = copy.next; //注意，这里应该是copy.next，因为temp++应该指向B而不是A'
        }
        //随机指针指向
        temp = head;
        while (temp != null) {
            Node copy = temp.next;
            if (temp.random != null) {
                copy.random = temp.random.next;//random指针的判断
            }
            temp = copy.next;
        }
        //拆分链表
        temp = head;
        Node cloneHead = head.next;
        while (temp.next != null) {//因为是要拆分，所以判断当前指针的复制节点是否为空，知道其为空，才结束循环
            Node next = temp.next;
            temp.next = next.next;
            temp = next;
        }
        return cloneHead;
    }
}