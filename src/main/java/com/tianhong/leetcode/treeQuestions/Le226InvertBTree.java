package com.tianhong.leetcode.treeQuestions;

//         6                            6
//        / \                          / \
//       3   5         ===>>          5   3
//      / \   \                      /   / \
//     4   2   3                    3   2   4
//
public class Le226InvertBTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
