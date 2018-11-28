package com.tianhong.leetcode.treeQuestions;

public class MaximumBinaryTree654 {
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0)
            return null;
        if(nums.length == 1)
            return new TreeNode(nums[0]);
        int index = findIndex(nums);
        TreeNode node = new TreeNode(nums[index]);
        int[] left = new int[index];
        int[] right = new int[nums.length - index - 1];
        for(int i = 0; i < index; i++){
            left[i] = nums[i];
        }
        for(int j = index+1; j < nums.length; j++){
            right[j] = nums[j];
        }
        node.left = constructMaximumBinaryTree(left);
        node.right = constructMaximumBinaryTree(right);
        return node;
    }

    public static int findIndex(int[] nums){
        int index = 0;
        int temp = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > temp) {
                temp = nums[i];
                index = i;
            }
        }
        return index;
    }
}
