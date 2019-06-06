package com.tianhong.leetcode.treeQuestions;

public class Le1026MaximumDiffBetweenNodeAndAncestor {
    public int maxAncestorDiff(TreeNode root) {
        return getDiff(root, root.val, root.val);
    }

    // int[0] min; int[1] max; int[2] maxDiff;
    public int getDiff(TreeNode node, int max, int min) {
        if(node == null) {
            return max - min;
        }
        int left = 0;
        int right = 0;
        int leftMax = max;
        int leftMin = min;
        int rightMax = max;
        int rightMin = min;
        if(node.left != null){
            leftMax = node.left.val > max ? node.left.val : max;
            leftMin = node.left.val < min ? node.left.val : min;
        }
        left = getDiff(node.left, leftMax, leftMin);
        if(node.right != null){
            rightMax = node.right.val > max ? node.right.val : max;
            rightMin = node.right.val < min ? node.right.val : min;
        }
        right = getDiff(node.right, rightMax, rightMin);
        return Math.max(right, left);
    }
}
