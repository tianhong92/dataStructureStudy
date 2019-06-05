package com.tianhong.leetcode.treeQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Le515FindMaxInEachRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size() != 0) {
            int max = Integer.MIN_VALUE;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                max = node.val > max ? node.val : max;
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            list.add(max);
        }
        return list;
    }


    public List<Integer> largestValues2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;
        preOrderTraverse(list, root, 0);
        return list;
    }

    public void preOrderTraverse(List<Integer> list, TreeNode node, int d) {
        if(node == null)
            return;
        if(list.size() == d) {
            list.add(node.val);
        } else {
            int temp = list.get(d);
            if(node.val > temp) {
                list.set(d, node.val);
            }
        }
        preOrderTraverse(list, node.left, d + 1);
        preOrderTraverse(list, node.right, d + 1);
    }
}
