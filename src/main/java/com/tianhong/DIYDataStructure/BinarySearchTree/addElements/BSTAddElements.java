package com.tianhong.DIYDataStructure.BinarySearchTree.addElements;

import java.util.LinkedList;
import java.util.Queue;

public class BSTAddElements<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;
    private int depth;

    public BSTAddElements() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    // 往二分查找树中添加元素
    public void add(E e){
        root = add(root, e);
    }

    // 往以root为根节点的二叉树中添加元素
    private Node add(Node node, E e) {
       if(node == null){
           node = new Node(e);
           size++;
           return node;
       }
       if(e.compareTo(node.e) < 0){
           node.left = add(node.left, e);
       }
       if(e.compareTo(node.e) > 0){
           node.right = add(node.right, e);
       }
       return node;
    }


    // 往以root为根节点的二叉树中添加元素, 易理解版
   private void add2(Node node, E e){
        if(node.left == null && e.compareTo(node.e) < 0){
            node.left = new Node(e);
            size++;
        }
        if(node.right == null && e.compareTo(node.e) > 0){
            node.right = new Node(e);
            size++;
        }
        if(node.left != null && e.compareTo(node.e) < 0){
            add2(node.left, e);
        }
        if(node.right != null && e.compareTo(node.e) > 0){
            add2(node.right, e);
        }
   }

   public int getTreeDepth(){
       if(size == 0){
           return 0;
       }
       int depth = 0;
       Queue<Node> queue = new LinkedList<>();
       queue.add(root);
       while(!queue.isEmpty()){
           int length = queue.size();
           depth++;
           for(int i = 0; i < length; i++){
               Node cur = queue.remove();
               if(cur.left != null){
                   queue.add(cur.left);
               }
               if(cur.right != null){
                   queue.add(cur.right);
               }
           }
       }
       return depth;
   }

    private void print(Node root){
        if(root == null){
            return;
        }
        if(root.left != null){
            print(root.left);
        }
        System.out.println(root.e);
        if(root.right != null){
            print(root.right);
        }
    }

    public static void main(String[] args) {
        BSTAddElements<Integer> tree = new BSTAddElements<>();
        tree.add(5);
        tree.add(2);
        tree.add(1);
        tree.add(9);
        tree.add(3);
        tree.add(7);
        tree.add(8);

        //////////////////////
        //          5       //
        //       /    \     //
        //     2       9    //
        //   /   \   /      //
        // 1     3 7        //
        //          \       //
        //           8      //
        //////////////////////
        System.out.println(tree.getTreeDepth());
    }

}
