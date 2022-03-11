package programmercarl;

public class LeetCode105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preEnd - preStart < 1) {
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int index = 0;
        for (int i = 0; i < inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }//注意左闭右开，因为传入的是preorder.length
        root.left = build(preorder, preStart + 1, preStart + index - inStart + 1, inorder, inStart, index);
        root.right = build(preorder, preStart + index - inStart + 1, preEnd, inorder, index + 1, inEnd);
        return root;
    }
}
