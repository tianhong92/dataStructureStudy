package com.tianhong.leetcode.treeQuestions;

//    3
//   / \
//  9  20
//    /  \
//   15   7
// return true;

//       1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// return false;

public class Le110BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);
        boolean diffLessThanTwo;
        if(Math.abs(maxLeft - maxRight) < 2){
            diffLessThanTwo = true;
        } else {
            diffLessThanTwo = false;
        }

        boolean ret1 = isBalanced(root.right);
        boolean ret2 = isBalanced(root.left);

        return diffLessThanTwo && ret1 && ret2;
    }

    public int maxDepth(TreeNode node){
        if(node == null)
            return 0;
        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }
}
