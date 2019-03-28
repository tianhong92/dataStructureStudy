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
       return validLeft(root.left, root.val) && validRight(root.right, root.val);
    }

    public boolean validLeft(TreeNode node, int max){
        if(node == null){
            return true;
        }
        if(node.left == null && node.right == null){
            if(node.val < max)
                return true;
            else
                return false;
        }
        if(node.left != null){
            if(node.left.val >= max || node.left.val >= node.val){
                return false;
            }
        }
        if(node.right != null){
            if(node.right.val >= max || node.right.val <= node.val){
                return false;
            }
        }

        return validLeft(node.left, node.val) && validRight(node.right, node.val);
    }


    public boolean validRight(TreeNode node, int min){
        if(node == null){
            return true;
        }
        if(node.left == null && node.right == null){
            if(node.val > min)
                return true;
            else
                return false;
        }
        if(node.left != null){
            if(node.left.val <= min || node.left.val > node.val){
                return false;
            }
        }
        if(node.right != null){
            if(node.right.val <= min || node.right.val < node.val){
                return false;
            }
        }

        return validLeft(node.left, node.val) && validRight(node.right, node.val);
    }
}
