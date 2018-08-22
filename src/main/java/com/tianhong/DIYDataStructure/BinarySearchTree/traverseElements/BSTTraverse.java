package com.tianhong.DIYDataStructure.BinarySearchTree.traverseElements;

public class BSTTraverse<E extends Comparable<E>> {
    private int size;
    private class Node{
        public E e;
        public Node left, right;
        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }
    private Node root;
    public BSTTraverse() {
        this.root = null;
        this.size = 0;
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
        }
        else if(e.compareTo(node.e) > 0){
            node.right = add(node.right, e);
        }
        return node;
    }

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node) {
        if(node == null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void main(String[] args) {
        BSTTraverse<Integer> tree = new BSTTraverse<>();
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

        tree.preOrder();
    }
}
