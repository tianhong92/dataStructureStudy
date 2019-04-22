package com.tianhong.leetcode.treeQuestions;


import java.util.Date;
import java.util.TimeZone;

public class Le450DeleteNodeInBST {
    // wip
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;
        if(root.val == key && root.left == null && root.right == null)
            return null;
        if(root.left == null && root.val == key)
            return root.right;
        if(root.right == null && root.val == key)
            return root.left;
        //找到右字数最小节点替换删除节点
        if(root.right != null && root.left != null && root.val == key) {
            TreeNode rightMin = getMinNode(root.right);
            deleteMinNode(root.right);
            rightMin.left = root.left;
            rightMin.right = root.right;
            return rightMin;
        }
        root.left = deleteNode(root.left, key);
        root.right = deleteNode(root.right, key);
        return root;
    }

    public TreeNode getMinNode(TreeNode node){
        if(node == null){
            return null;
        }
        if(node.left == null && node.right == null)
            return node;
        return getMinNode(node.left);
    }

    public void deleteMinNode(TreeNode node){
        if(node == null)
            return;
        if(node.left == null && node.right == null) {
            node = null;
            return;
        }
        deleteMinNode(node.left);
    }


    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(Integer.valueOf("1")+Integer.valueOf("2"));
        System.out.println(date);
        //System.out.println(TimeZone.getTimeZone("CST"));
    }
}
