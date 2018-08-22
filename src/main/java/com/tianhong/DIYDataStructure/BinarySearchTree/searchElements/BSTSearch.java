package com.tianhong.DIYDataStructure.BinarySearchTree.searchElements;

public class BSTSearch<E extends Comparable> {
    private class Node{
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
    public BSTSearch(){
        root = null;
        size = 0;
    }

    public void add(E e){
        root = add(root, e);
    }

    private Node add(Node node, E e){
        if(node == null){
            size++;
            return new Node(e);
        }
        if(e.compareTo(node.e) < 0){
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    public void print(Node node){
        if(node == null) {
            return;
        }
        if(node.left != null){
            print(node.left);
        }
        System.out.println(node.e);
        if(node.right != null){
            print(node.right);
        }
    }

    // 看二分搜索树是否包含元素e
    public boolean contains(E e){
        return contains(root, e);
    }

    public boolean contains(Node node, E e){
        if(node == null){
            return false;
        }
        if(node.e == e){
            return true;
        }

        boolean rightContains = contains(node.right, e);
        boolean leftContains = contains(node.left, e);

        return rightContains||leftContains;
    }

    public static void main(String[] args) {
        BSTSearch<Integer> tree = new BSTSearch<>();
        tree.add(9);
        tree.add(3);
        tree.add(11);
        tree.add(5);
        tree.add(10);
        tree.print(tree.root);
        System.out.println(tree.contains(99));
    }
}
