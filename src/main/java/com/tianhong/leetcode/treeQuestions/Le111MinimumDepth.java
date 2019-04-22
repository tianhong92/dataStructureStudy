package com.tianhong.leetcode.treeQuestions;

//    3
//   / \
//  9  20
//    /  \
//   15   7
// return 2(3 -> 9)
public class Le111MinimumDepth {
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        if(root.left == null || root.right == null)
            return minDepth(root.right) + minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
