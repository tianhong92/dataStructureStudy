package com.tianhong.Jianzhi;

import sun.reflect.generics.tree.Tree;

/**
 * @Author: TianhongWang
 * @Date: 2018/12/3
 * @Description
 */

// 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
// 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针
public class Re8NextNode {
    private class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public static TreeLinkNode findNext(TreeLinkNode node){
       if(node.right != null){
           TreeLinkNode right = node.right;
           while(right.left != null){
               right = right.left;
           }
           return right;
       } else {
           TreeLinkNode nextNode = node.next;
           while(nextNode != null){
               if(nextNode.left == node){
                   return nextNode;
               }
               nextNode = nextNode.next;
               node = nextNode;
           }
           return null;
       }
    }

}
