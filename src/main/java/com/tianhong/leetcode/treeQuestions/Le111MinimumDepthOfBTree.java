package com.tianhong.leetcode.treeQuestions;

// Given binary tree [3,9,20,null,null,15,7],
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
// return its minimum depth = 2.


public class Le111MinimumDepthOfBTree {
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
