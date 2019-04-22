package com.tianhong.leetcode.treeQuestions;

// The minimum depth is the number of
// nodes along the shortest path from the root node down to the nearest "leaf node".
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
        if(root.left == null || root.right == null)
            return minDepth(root.left) + minDepth(root.right) + 1;
        else
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
