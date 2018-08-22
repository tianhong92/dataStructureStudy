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


    // 往以root为根节点的二叉树中添加元素
    // 插入新元素返回跟节点
    private Node add(Node root, E e){
        if(root == null){
            root = new Node(e);
            size++;
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

    // 查看二分树是否包含元素e
    public boolean contains(Node root, E e){
        if(root == null){
            return false;
        }
        if(root.e.equals(e)){
            return true;
        }
        boolean leftContains = contains(root.left, e);
        boolean rightContains = contains(root.right, e);
        return leftContains || rightContains;
    }


    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.add(tree.root, 6);
        tree.print(tree.root);

    }

}
