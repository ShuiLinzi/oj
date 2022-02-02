package programmercarl;

//解题思路：设置链表的各种操作
public class LeetCode707 {
    //使用虚拟节点解决问题
    int size;//size存储元素的个数
    ListNode head;//虚拟头节点

    //初始化链表
    public LeetCode707() {
        size = 0;
        head = new ListNode(0);
    }

    //获得下标链表的值
    public int get(int index) {
        if (index >= size || index < 0) return -1;
        ListNode currentNode = head;
        for (int i = 0; i <= index; i++) {
            currentNode = currentNode.next;

        }
        return currentNode.val;
    }

    //在头部添加元素
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    //在尾部添加元素
    public void addAtTail(int val) {
        addAtIndex(size, val);//在尾部新添加元素，而不是替换最后一个，所以是size,而不是size-1;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index < 0) index = 0;
        size++;//添加元素要扩大size
        ListNode current = head;
        ListNode add = new ListNode(val);
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        add.next = current.next;
        current.next = add;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        size--;
        ListNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.next = current.next.next;
    }
}
