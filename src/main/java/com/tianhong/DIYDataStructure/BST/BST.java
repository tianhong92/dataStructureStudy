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
        if(root == null){
            root = new Node(e);
            size++;
        } else {
            add(root, e);
        }
    }

    // 往以root为根节点的二叉树中添加元素
    private Node add(Node root, E e){
        if(e == root.e){
            return root;
        }
        else if(e.compareTo(root.e) < 0 && root.left == null){
            root.left = new Node(e);
            size++;
        }
        else if(e.compareTo(root.e) > 0 && root.right == null){
            root.right = new Node(e);
            size++;
        }

        if(e.compareTo(root.e) < 0 && root.left != null){
            add(root.left, e);
        }
        else if(e.compareTo(root.e) > 0 && root.right != null){
            add(root.right, e);
        }
        return root;
    }

    private void print(Node root){
        if(root == null){
            return;
        }
        else if(root.left != null){
            print(root.left);
        }
        System.out.println(root.e);
        if(root.right != null){
            print(root.right);
        }
    }

    public void addNodes(){
        add((E) new Integer(5));
        add((E) new Integer(8));
        add((E) new Integer(9));
        add((E) new Integer(3));
        add((E) new Integer(2));
        add((E) new Integer(4));
    }

    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.addNodes();
    }

}
