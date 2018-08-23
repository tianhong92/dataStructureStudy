package com.tianhong.DIYDataStructure.BinarySearchTree.traverseElements;

import com.tianhong.DIYDataStructure.Stack.ArrayStack;

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

    // 前序遍历
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

    // 中序遍历
    public void inOrder(){
        inOrder(root);
    }

    // 非递归前序遍历二叉树
    public void preOrderNR(){
        preOrderNR(root);
    }

    // 二分搜索树的非递归前序遍历
    private void preOrderNR(Node node){
        ArrayStack<Node> stack = new ArrayStack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);
            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
    }

    private void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    // 后序遍历
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res){
        if(node == null) {
            res.append(generateDepthString(depth)+"null\n");
            return;
        }
        res.append(generateDepthString(depth)+node.e+"\n");
        generateBSTString(node.left, depth+1, res);
        generateBSTString(node.right, depth+1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < depth; i++){
            res.append("--");
        }
        return res.toString();
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
        System.out.println("***************");
        tree.inOrder();
        System.out.println("***************");
        tree.postOrder();
        System.out.println("***************");
        tree.preOrderNR();
    }
}
