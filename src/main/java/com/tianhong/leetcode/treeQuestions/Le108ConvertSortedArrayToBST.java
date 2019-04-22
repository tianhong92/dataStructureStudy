package com.tianhong.leetcode.treeQuestions;

// input: [-10,-3,0,5,9]
//            0
//           / \
//         -3   9
//         /   /
//       -10  5


public class Le108ConvertSortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)
            return null;
        if(nums.length == 1)
            return new TreeNode(nums[0]);
        return partition(nums, 0, nums.length - 1);
    }

    public TreeNode partition(int[] nums, int start, int end){
        if(start > end)
            return null;
        if(start == end)
            return new TreeNode(nums[start]);
        int mid = (start + end) / 2;
        TreeNode temp = new TreeNode(nums[mid]);
        TreeNode left = partition(nums, start, mid - 1);
        TreeNode right = partition(nums, mid + 1, end);
        temp.left = left;
        temp.right = right;
        return temp;
    }
}
