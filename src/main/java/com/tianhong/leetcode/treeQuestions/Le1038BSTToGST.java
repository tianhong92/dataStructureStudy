package com.tianhong.leetcode.treeQuestions;

public class Le1038BSTToGST {
    private int pre = 0;
    public TreeNode bstToGst(TreeNode root) {
        if(root == null)
            return null;
        bstToGst(root.right);
        root.val = pre + root.val;
        pre = root.val;
        bstToGst(root.left);
        return root;
    }
}
