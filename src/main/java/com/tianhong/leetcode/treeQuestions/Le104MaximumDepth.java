package com.tianhong.leetcode.treeQuestions;

// Given a binary tree, find its maximum depth.
// The maximum depth is the number of nodes along the
// longest path from the root node down to the farthest leaf node.
// Note: A leaf is a node with no children.

public class Le104MaximumDepth {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    //                           3
    //                          / \
    //                         3   6
    //                        / \   \
    //                       5   4   7
    //                      /
    //                     8

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(8);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        node3.left = node6;

        Le104MaximumDepth test = new Le104MaximumDepth();
        System.out.println(test.maxDepth(root));
    }
}
