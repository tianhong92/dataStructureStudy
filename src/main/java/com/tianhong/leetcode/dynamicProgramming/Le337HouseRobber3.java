package com.tianhong.leetcode.dynamicProgramming;

import com.tianhong.leetcode.treeQuestions.TreeNode;

public class Le337HouseRobber3 {
    public int rob(TreeNode root) {
        int[] ret = recursive(root);
        return Math.max(ret[0], ret[1]);
    }

    // ret[0]代表左右孩子和
    // ret[1]代表父亲值
    public int[] recursive(TreeNode root) {
        int[] ret = new int[2];
        if(root == null)
            return ret;
        int[] retLeft = recursive(root.left);
        int[] retRight = recursive(root.right);
        ret[0] = retLeft[1] + retRight[1];
        ret[1] = Math.max(retLeft[0] + retRight[0] + root.val, ret[0]);
        return ret;
    }
}