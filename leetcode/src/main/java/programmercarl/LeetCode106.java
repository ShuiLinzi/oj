package programmercarl;

public class LeetCode106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buile(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    TreeNode buile(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inEnd - inStart < 1) {
            return null;
        }
        //用次数值对中序遍历进行切割
        int rootVal = postorder[postEnd - 1];
        //循环遍历中序遍历
        int index = 0;
        for (int i = inStart; i < inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        //利用找到的下标对后续遍历数组进行切割
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = buile(inorder, inStart, index, postorder, postStart, postStart + leftSize);
        root.right = buile(inorder, index + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);
        return root;

    }
}
