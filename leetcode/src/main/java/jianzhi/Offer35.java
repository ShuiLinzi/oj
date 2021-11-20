package jianzhi;

import java.util.HashMap;

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
class Offer35 {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map  = new   HashMap<>();
        Node temp = head;
        //把链表复制到hashmap的值里面
        while(temp!= null){
            map.put(temp,new Node(temp.val));
            temp = temp.next;
        }
        //开始复制链表
        temp = head;
        while(temp!=null){
            map.get(temp).next =  map.get(temp.next);//复制next指针
            //复制random节点
            map.get(temp).random = map.get(temp.random);
            temp=temp.next;

        }
        //返回新链表的头节点
        return map.get(head);
    }

    //方法二:
}