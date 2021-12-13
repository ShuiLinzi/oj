package jianzhi;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.HashMap;

//剑指 Offer 07. 重建二叉树
//输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
//假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
//解题思路:看注释，这题是真的绕，麻了，没答案根本不可能写出来，二刷，还是那么妙阿！
public class Offer07 {
    int[] preorder;
    HashMap<Integer, Integer> dic = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {//转化获得中序遍历的hash表
            dic.put(inorder[i], i);

        }
        return recur(0, 0, inorder.length - 1);
    }

    private TreeNode recur(int root, int left, int right) {//前序遍历的索引root,left是中序遍历的左边界， right是中序遍历的右边界
        if (left > right) return null;//相等就是自己
        TreeNode node = new TreeNode(preorder[root]);//建立根节点
        int i = dic.get(preorder[root]);//获取在中序遍历中根节点所在的索引，以方便获取左子树的数量
        //左子树的根的索引为先序中的根节点+1
        //递归左子树的左边界为原来中序左边界
        //左子树的右边界为中序根节点-1
        node.left = recur(root + 1, left, i - 1);
        //右子树的根的索引为 先序的根+左子树+1
        //右子树的左边界为 中序根节点+1
        //右子树右边界为中序的右边界
        node.right = recur(root + i - left + 1, i + 1, right);
        return node;
    }
}
