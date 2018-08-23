package com.tianhong.DIYDataStructure.BinarySearchTree.traverseElements;

import com.tianhong.DIYDataStructure.Queue.LoopQueue;
import com.tianhong.DIYDataStructure.Queue.Queue;
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
        if(node == null){
            return;
        }
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

    // 二分搜索树的层续遍历
    public void levelOrder(){
       levelOrder(root);
    }

    private void levelOrder(Node node){
        if(node == null){
            return;
        }
        Queue<Node> queue = new LoopQueue<>();
        queue.enqueue(root);

        while(!queue.isEmpty()){
            int length = queue.getSize();
            for(int i = 0; i < length; i++){
                Node cur = queue.dequeue();
                System.out.println(cur.e);
                if(cur.left != null){
                    queue.enqueue(cur.left);
                }
                if(cur.right != null){
                    queue.enqueue(cur.right);
                }

            }
        }
    }

    // 寻找二分搜索树最小元素
    public E minimum(){
        if(size == 0){
            return null;
        }
        if(size == 1){
            return root.e;
        }
        return minimum(root);
    }

    private E minimum(Node node){
        if(node.left == null){
            return node.e;
        }
        return minimum(node.left);
    }

    public Node deleteMinimum(){
        if(size == 0 || size == 1){
            root = null;
            size = 0;
            return null;
        }

        return deleteMinimum(root);
    }

    private Node deleteMinimum(Node node){
        if(node.left == null && node.right == null){
            node = null;
            return null;
        } else if (node.left == null && node.right != null){
            Node right = node.right;
            node = null;
            return right;
        }

        Node ret = deleteMinimum(node.left);
        node.left = ret;
        size--;
        return node;
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


        System.out.println("Minimum is: "+tree.minimum());
        tree.deleteMinimum();
        tree.preOrder();
    }
}
