package com.tianhong.DIYDataStructure.BinarySearchTree;

public class BST<E extends Comparable<E>> {
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

    public BST() {
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
//        if(root == null){
//            root = new Node(e);
//            size++;
//            return;
//        } else {
//            add2(root, e);
//        }
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
        BST<Integer> tree = new BST<>();
        tree.add(9);
        tree.add(5);
        tree.add(2);
        tree.add(11);
        tree.add(15);
        tree.print(tree.root);
    }

}
