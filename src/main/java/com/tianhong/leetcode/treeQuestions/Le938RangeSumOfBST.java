package com.tianhong.leetcode.treeQuestions;

public class Le938RangeSumOfBST {
    private int sum = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null)
            return 0;
        traverseTree(root, L, R);
        return sum;
    }

    public void traverseTree(TreeNode node, int L, int R) {
        if(node == null)
            return;
        if(node.val >= L && node.val <= R){
            sum += node.val;
            traverseTree(node.right, L, R);
            traverseTree(node.left, L, R);
        } else if (node.val < L) {
            traverseTree(node.right, L, R);
        } else {
            traverseTree(node.left, L, R);
        }
    }

    public int rangeSumBST2(TreeNode root, int L, int R) {
        if(root == null)
            return 0;
        if(root.val < L) {
            return rangeSumBST2(root.right, L, R);
        } else if (root.val > R) {
            return rangeSumBST2(root.left, L, R);
        } else {
            return root.val + rangeSumBST2(root.left, L, R) + rangeSumBST2(root.right, L, R);
        }
    }
}
