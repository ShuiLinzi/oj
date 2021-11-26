package jianzhi;

//剑指 Offer 26. 树的子结构
//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
//B是A的子结构， 即 A中有出现和B相同的结构和节点值。
//https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
public class Offer26 { //
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);

    }

    boolean recur(TreeNode A, TreeNode B) {//此函数是用来判断是否相等的，即a左和b左，a右和b右，是否最终相等
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);  //循环判断是否相等，当上面的判断条件都不满足的时候，就是成立的情况

    }
}
