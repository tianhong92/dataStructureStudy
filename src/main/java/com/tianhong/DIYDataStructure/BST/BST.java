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
    private Node add(Node root, E e) {
        if(root == null){
            return new Node(e);
        }
        if(e.compareTo(root.e) < 0){
            root.left = add(root.left, e);
        }
        if(e.compareTo(root.e) > 0){
            root.right = add(root.right, e);
        }
        return root;
    }


    // 往以root为根节点的二叉树中添加元素, 易理解版
    private void add2(Node root, E e){
        if(root == null) {
            return;
        }
        Node leftNode = root.left;
        Node rightNode = root.right;
        if(root.left == null && e.compareTo(root.e) < 0){
            root.left = new Node(e);
        } else if(root.left != null && e.compareTo(root.e) < 0){
            add2(root.left, e);
        }

        if(root.right == null && e.compareTo(root.e) > 0){
            root.right = new Node(e);
        } else if(root.right != null && e.compareTo(root.e) > 0){
            add2(root.right, e);
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

    public void addNodes(){
        Node node1 = new Node((E) new Integer(5));
        add(node1, (E) new Integer(8));
        add(node1, (E) new Integer(4));
        add(node1, (E) new Integer(9));
        add(node1, (E) new Integer(2));
        add(node1, (E) new Integer(7));
        print(node1);
    }


    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.addNodes();
    }

}
