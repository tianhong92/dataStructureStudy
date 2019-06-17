package com.tianhong.leetcode.treeQuestions;

import java.util.ArrayList;
import java.util.List;

public class Le872LeafSimilarTree {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> t1 = new ArrayList<>();
        List<Integer> t2 = new ArrayList<>();
        traverse(root1, t1);
        traverse(root2, t2);
        return t1.equals(t2);
    }

    public void traverse(TreeNode node, List list) {
        if(node.left == null && node.right == null) {
            list.add(node.val);
        }
        traverse(node.left, list);
        traverse(node.right, list);
    }
}
