package com.tianhong.leetcode.treeQuestions;

//         1
//        / \
//       2   2
//      / \ / \
//     3  4 4  3
//
//   return true

//         1
//        / \
//       2   2
//        \   \
//        3    3
//
//   return false

public class Le101SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return compare(root.left, root.right);
    }

    public boolean compare(TreeNode left, TreeNode right){
        if(left == null && right == null)
            return true;
        if(left == null || right == null)
            return false;
        if(left.val != right.val)
            return false;
        return compare(left.left, right.right) && compare(left.right, right.left);
    }
}
