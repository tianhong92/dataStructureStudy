package com.tianhong.leetcode.treeQuestions;

// return the bottom-up level order traversal of its nodes' values.
// input
//    3
//   / \
//  9  20
//    /  \
//   15   7

// output
// [
//  [15,7],
//  [9,20],
//  [3]
//]

import java.util.List;

public class LevelOrderTraverse107 {
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ this.val = x; }
    }

//    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//
//    }
}
