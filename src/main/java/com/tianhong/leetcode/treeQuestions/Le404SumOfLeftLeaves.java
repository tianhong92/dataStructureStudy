package com.tianhong.leetcode.treeQuestions;

//    3
//   / \
//  9  20
//    /  \
//   15   7
//
// There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
public class Le404SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left != null && root.left.left == null && root.left.right == null)
            return root.left.val + sumOfLeftLeaves(root.right);
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
