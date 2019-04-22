package com.tianhong.leetcode.treeQuestions;
//           5
//          / \
//         4   8
//        /   / \
//       11  13  4
//      /  \      \
//     7    2      1
// Given the below binary tree and sum = 22
// return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
public class Le112PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
       if(root == null)
           return false;

       return getSum(root, sum, root.val);
    }

    public boolean getSum(TreeNode node, int sum, int total){
        if(node.left == null && node.right == null && sum == total)
            return true;
        if(node.left == null && node.right == null && sum != total)
            return false;

        boolean leftResult = false;
        boolean rightResult = false;
        if(node.left != null)
             leftResult = getSum(node.left, sum, total + node.left.val);
        if(node.right != null)
             rightResult = getSum(node.right, sum, total + node.right.val);
        return leftResult || rightResult;

    }


}
