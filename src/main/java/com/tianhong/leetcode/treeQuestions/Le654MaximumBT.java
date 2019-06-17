package com.tianhong.leetcode.treeQuestions;

public class Le654MaximumBT {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0)
            return null;
        return construct(nums, 0, nums.length - 1);
    }

    public TreeNode construct(int[] nums, int l, int r) {
        if(l > r)
            return null;
        int mid = l;
        int temp = nums[l];
        for(int i = l; i <= r; i++) {
            if(nums[i] > temp) {
                mid = i;
                temp = nums[i];
            }
        }
        TreeNode node = new TreeNode(temp);
        node.left = construct(nums, l, mid - 1);
        node.right = construct(nums, mid + 1, r);
        return node;
    }
}
