package com.tianhong.leetcode.treeQuestions;

public class Le1022SumOfRootToLeafBN {
    private int total;
    public int sumRootToLeaf(TreeNode root) {
        total = 0;
        traverse(root, 0);
        return total;
    }

    public void traverse(TreeNode node, int sum) {
        if(node == null)
            return;
        sum = sum * 2 + node.val;
        if(node.left == null && node.right == null) {
            total += sum;
        }
        traverse(node.left, sum);
        traverse(node.right, sum);
    }
}
