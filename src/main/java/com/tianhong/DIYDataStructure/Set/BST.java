package com.tianhong.DIYDataStructure.Set;

import com.tianhong.DIYDataStructure.BinarySearchTree.searchElements.BSTSearch;
import com.tianhong.DIYDataStructure.BinarySearchTree.traverseElements.BSTTraverse;

import java.util.LinkedList;
import java.util.Queue;

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
    private int depth;

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
        if (node.left == null){
            Node right = node.right;
            node = null;
            return right;
        }

        Node ret = deleteMinimum(node.left);
        node.left = ret;
        size--;
        return node;
    }

    public Node remove(E e){
        return delete(root, e);
    }

    private Node delete(Node node, E e){
        if(node == null){
            return null;
        }
        if(e.compareTo(node.e) < 0){
            node.left = delete(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0){
            node.right = delete(node.right, e);
            return node;
        } else { // if e == node.e
            if(node.right == null){
                Node left = node.left;
                node = left;
                size--;
                return node;
            }
            if(node.left == null){
                Node right = node.right;
                node = right;
                size--;
                return  node;
            }

            Node successor = new Node(minimum(node.right));
            Node right = deleteMinimum(node.right);
            successor.left = node.left;
            successor.right = right;
            return  successor;

        }
    }

    // 看二分搜索树是否包含元素e
    public boolean contains(E e){
        return contains(root, e);
    }

    private boolean contains(Node node, E e){
        if(node == null){
            return false;
        }
        if(e.compareTo(node.e) == 0){
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
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

}
