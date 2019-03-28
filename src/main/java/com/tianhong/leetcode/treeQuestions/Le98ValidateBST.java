package com.tianhong.leetcode.treeQuestions;

// Given a binary tree, determine if it is a valid binary search tree (BST).

//    Input:
//       2
//      / \
//     1   3
//  Output: true

public class Le98ValidateBST {
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        if(root.left == null && root.right == null)
            return true;
        return validation(root.left, null, root.val) && validation(root.right, root.val, null);
    }

    // if node's value less than max, update max
    public boolean validation(TreeNode node, Integer min, Integer max){

        if(node == null)
            return true;
        if(min != null && node.val <= min)
            return false;
        if(max != null && node.val >= max)
            return false;
        boolean left;
        boolean right;
        if(max == null){
            left = validation(node.left, min, node.val);
        } else {
            left = validation(node.left, min, Math.min(max, node.val));
        }

        if(min == null){
            right = validation(node.right, node.val, max);
        } else {
            right = validation(node.right, Math.min(node.val, min), max);
        }

        return left && right;
    }


}
