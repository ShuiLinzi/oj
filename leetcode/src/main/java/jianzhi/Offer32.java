package jianzhi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//剑指 Offer 32 - I. 从上到下打印二叉树
//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
//https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
//队列，广度优先遍历，队列，用一个队列和一个数组集合实现，就一直循环实现，把值加入到arrayList，然后最终循环输出，用队列储存二叉树的节点
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

public class Offer32 {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ans.add(node.val);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}

//剑指 Offer 32 - II. 从上到下打印二叉树 II
//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
//https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
class Offer32_2 {
    //第二题的解题思路，从上到下打印，二叉树的广度优先搜索（BFS）
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
//        ArrayList<Integer> ans = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        //先进行非空判断
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            //[3,9,20,null,null,15,7]
            //① for (int i = 0; i < queue.size(); i++)
            //② for(int i =queue.size();i>0;i--)
            for (int i = queue.size(); i > 0; i--) {//为什么1不行，而2可以，因为这个循环里面的queue.size是变量，不是固定的值，所以循环会出现错误
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            ans.add(temp);


        }
        return ans;
    }
}

//剑指 Offer 32 - III. 从上到下打印二叉树 III
//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
//https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
//解题思路：本题和前两题的区别在于，这一题的奇数层顺序打印，偶数层逆序打印，可以使用双端链表的队列，进行判断打印实现
class Offer32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();//为啥是linklist呢
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (res.size() % 2 == 0)//用res取余2是真的妙啊，因为res是要返回的list，它的长度是固定的，而且确实能有效判断是单数层，或者说是双数层
                    tmp.addLast(node.val);//size为0的时候，是第一层（奇数），正序输出，size为1的时候，是第二层（偶数），逆序输出
                else tmp.addFirst(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }

}
