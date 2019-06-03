package com.tianhong.leetcode.treeQuestions;

public class Le865SmallestSubtree {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root == null)
            return root;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if(right == left) {
            return root;
        } else if (right > left) {
            return subtreeWithAllDeepest(root.right);
        } else {
            return subtreeWithAllDeepest(root.left);
        }
    }

    public int getDepth(TreeNode root) {
        if(root == null)
            return 0;
        int left = getDepth(root.left) + 1;
        int right = getDepth(root.right) + 1;
        return Math.max(right, left);
    }
}
