package com.tianhong.leetcode.treeQuestions;

// The lowest common ancestor is defined between two nodes p and q as the lowest node in T
// that has both p and q as descendants (where we allow a node to be a descendant of itself).

import java.util.Date;

public class Le236LowestCommonAncestorBT {
    private TreeNode ret = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return root;
        traverse(root, p.val, q.val);
        return ret;
    }

    public boolean traverse(TreeNode node, int p, int q){
        if(node == null)
            return false;
        int left = traverse(node.left, p, q) ? 1 : 0;
        int right = traverse(node.right, p, q) ? 1 : 0;
        int mid = ( node.val == p || node.val == q ) ? 1 : 0;
        if(left + right + mid == 2) {
            ret = node;
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

    }
}
