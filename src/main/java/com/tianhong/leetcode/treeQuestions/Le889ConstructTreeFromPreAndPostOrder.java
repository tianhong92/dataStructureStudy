package com.tianhong.leetcode.treeQuestions;

import java.util.Arrays;

public class Le889ConstructTreeFromPreAndPostOrder {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int size = pre.length;
        if(size == 0)
            return null;
        if(size == 1)
            return new TreeNode(pre[0]);
        TreeNode root = new TreeNode(pre[0]);
        int L = 0;
        for(int i = 0; i < size; i++) {
            if(post[i] == pre[1]){
                L = i + 1;
            }
        }
        root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, 1 + L), Arrays.copyOfRange(post, 0, L));
        root.right = constructFromPrePost(Arrays.copyOfRange(pre, L + 1, size), Arrays.copyOfRange(post, L, size - 1));
        return root;
    }
}
