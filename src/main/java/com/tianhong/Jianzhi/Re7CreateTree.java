package com.tianhong.Jianzhi;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: TianhongWang
 * @Date: 2018/12/3
 * @Description
 */

// 根据二叉树的前序遍历和中序遍历的结果，重建出该二叉树。
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//
//  preorder = [3,9,20,15,7]
//  inorder =  [9,3,15,20,7]

public class Re7CreateTree {
    private static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int val){
            this.val = val;
        }
    }
    private static Map<Integer, Integer> indexForInorder = new HashMap<>();
    public static TreeNode createTree(int[] pre, int[] in){
        for(int i = 0; i < in.length; i++){
            indexForInorder.put(in[i], i);
        }
        return reCreate(pre, 0, pre.length - 1, 0);
    }

    public static TreeNode reCreate(int[] pre, int preL, int preR, int inL){
        if(preL > preR)
            return null;
        TreeNode root = new TreeNode(pre[preL]);
        int inIndex = indexForInorder.get(root.val);
        int leftSize = inIndex - inL;
        root.left = reCreate(pre, preL + 1, preL + leftSize, inL);
        root.right = reCreate(pre, preL + leftSize + 1, preR, inIndex + 1);
        return root;
    }
}
