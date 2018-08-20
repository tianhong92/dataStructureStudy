package com.tianhong.DIYDataStructure.BST;

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

    // 往二叉查找树中添加Node节点
    public void add(Node node){
        add(node.e);
    }
    // 往二分查找树中添加元素
    public void add(E e){
        add(root, e);
    }

    // 往以root为根节点的二叉树中添加元素
    private Node add(Node root, E e){
        if(root == null){
            root = new Node(e);
            return root;
        }
        if(e.compareTo(root.left.e) < 0){
            root.left = add(root.left, e);
        } else if (e.compareTo(root.right.e) > 0){
            root.right = add(root.right, e);
        }
        return root;
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

    public void addNodes(){
        Node node1 = new Node((E) new Integer(5));
        Node node2 = new Node((E) new Integer(4));
        Node node3 = new Node((E) new Integer(7));
        Node node4 = new Node((E) new Integer(8));
        Node node5 = new Node((E) new Integer(1));
        add(node1);
        add(node2);
        add(node3);
        add(node4);
        add(node5);
        print(this.root);
    }


    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.addNodes();
    }

}
