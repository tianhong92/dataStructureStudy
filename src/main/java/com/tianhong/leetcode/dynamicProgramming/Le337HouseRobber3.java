package com.tianhong.leetcode.dynamicProgramming;

import com.tianhong.leetcode.treeQuestions.TreeNode;

public class Le337HouseRobber3 {
    public int rob(TreeNode root) {
        return recursive(root)[0];
    }

    // ret[0]代表左右孩子和
    // ret[1]代表父亲值
    public int[] recursive(TreeNode root) {
        int[] ret = new int[2];
        if(root == null)
            return ret;
        int[] left = recursive(root.left);
        int[] right = recursive(root.right);
        ret[0] = left[1] + right[1];
        ret[1] = left[0] + right[0] + root.val;
        return new int[] { Math.max(ret[0], ret[1]), ret[0] };
    }
}