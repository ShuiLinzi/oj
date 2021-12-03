package jianzhi;

//剑指 Offer 36. 二叉搜索树与双向链表
//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
//https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
//解题思路：由于是二叉平衡树，其中序遍历就已经树中所有数字的顺序排序，然后在中序遍历的同时，把循环双向链表创建完成即可，使用的是递归完成
class Node36 {
    public int val;
    public Node36 left;
    public Node36 right;

    public Node36() {
    }

    public Node36(int _val) {
        val = _val;
    }

    public Node36(int _val, Node36 _left, Node36 _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

public class Offer36 {
    Node36 pre, head;

    public Node36 treeToDoublyList(Node36 root) {
        if (root == null) return null;
        dfs(root);//完成先序遍历
        head.left = pre;//完成双向循环链表
        pre.right = head;
        return head;
    }

    //打印中序遍历
    void dfs(Node36 cur) {
        if (cur == null) return;
        dfs(cur.left);//左
        if (pre != null) pre.right = cur;
        else head = cur;
        cur.left = pre;
        pre = cur;
     //   System.out.println(cur.val);
        dfs(cur.right);//右
    }
}
