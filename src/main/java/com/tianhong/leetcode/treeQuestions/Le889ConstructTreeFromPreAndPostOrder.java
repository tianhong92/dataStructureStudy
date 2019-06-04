package com.tianhong.leetcode.treeQuestions;

public class Le889ConstructTreeFromPreAndPostOrder {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int length = pre.length;
        if(pre.length != post.length || pre == null || post == null) {
            return null;
        }
        if(pre.length == 1) {
            return new TreeNode(pre[0]);
        }
        TreeNode root = new TreeNode(pre[0]);
        TreeNode first = root;
        construct(root, pre, post, 1, length - 2);
        return first;
    }

    public TreeNode construct(TreeNode root, int[] pre, int[] post, int i, int j) {
        if(root == null || i >= pre.length || j < 0) {
            return root;
        }
        if(pre[i] != post[j]) {
            root.left = construct(new TreeNode(pre[i]), pre, post, i++, j);
            root.right = construct(new TreeNode(post[j]), pre, post, i, j--);
        } else {
            root.left = null;
            root.right = construct(new TreeNode(pre[i]), pre, post, i++, j);
        }
        return root;
    }

}
