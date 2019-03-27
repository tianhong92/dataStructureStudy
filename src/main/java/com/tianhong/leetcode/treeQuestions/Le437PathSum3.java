package com.tianhong.leetcode.treeQuestions;

//                       10
//                      /  \
//                     5   -3
//                    / \    \
//                   3   2   11
//                  / \   \
//                 3  -2   1
//
//          Return 3. The paths that sum to 8 are:
//
//          1.  5 -> 3
//          2.  5 -> 2 -> 1
//          3. -3 -> 11

public class Le437PathSum3 {
    public int pathSum(TreeNode root, int sum) {
        if(root == null)
            return 0;
        return countPaths(root, sum, 0) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int countPaths(TreeNode node, int sum, int total){
        if(node == null)
            return 0;
        if(node.left == null && node.right == null){
            if(total + node.val == sum){
                return 1;
            } else {
                return 0;
            }
        }
        if(total + node.val == sum) {
            total += node.val;
            return 1 + countPaths(node.right, sum, sum) + countPaths(node.left, sum, total);
        }
        total += node.val;
        return countPaths(node.left, sum, total) + countPaths(node.right, sum, total);
    }
}
