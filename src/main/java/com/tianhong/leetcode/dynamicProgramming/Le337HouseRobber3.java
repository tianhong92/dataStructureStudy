package com.tianhong.leetcode.dynamicProgramming;

import com.tianhong.leetcode.treeQuestions.TreeNode;

public class Le337HouseRobber3 {
    public int rob(TreeNode root) {
        return recursive(root)[0];
    }

    // ret[0]代表左右孩子和
    // ret[1]代表父亲值
    public int[] recursive(TreeNode root) {
        if(root == null)
            return new int[]{0, 0};
        int[] left = recursive(root.left);
        int[] right = recursive(root.right);
        int max1 = left[1] + right[1];
        int max2 = left[0] + right[0] + root.val;
        return new int[] { Math.max(max1, max2), max1 };
    }
}