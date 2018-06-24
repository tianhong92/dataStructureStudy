package com.tianhong;

public class BinaryTreePruning {

    public static NodePoint printTree(NodePoint root) {
        if(root == null) {
            return null;
        }
        NodePoint right = printTree(root.getRight());
        System.out.println("root: "+root.getVal());
        printTree(root.getLeft());

        return root;
    }

    public static NodePoint pruneTree(NodePoint root) {
        if(root == null || (root.getRight() == null && root.getLeft() == null && root.getVal() == 0)) {
            return null;
        }
        NodePoint leftTree = pruneTree(root.getLeft());
        NodePoint rightTree = pruneTree (root.getRight());

        if(leftTree == null) {
            root.setLeft(null);
        }

        if(rightTree == null) {
            root.setRight(null);
        }
        return root;
    }

    public static void main(String[] args) {
        NodePoint root = new NodePoint(1);
        NodePoint node1 = new NodePoint(2);
        NodePoint node2 = new NodePoint(3);
        NodePoint node3 = new NodePoint(4);
        NodePoint node4 = new NodePoint(5);
        NodePoint node5 = new NodePoint(6);

        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(null);
        node2.setLeft(node4);
        node2.setRight(node5);

        NodePoint newRoot = pruneTree(root);
        printTree(newRoot);

    }

}

class NodePoint {
    private int val;
    private NodePoint left;
    private NodePoint right;

    public NodePoint(int val) {
        this.val = val;
    }

    public void setLeft(NodePoint left) {
        this.left = left;
    }

    public void setRight(NodePoint right) {
        this.right = right;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public NodePoint getRight() {
        return this.right;
    }

    public NodePoint getLeft() {
        return this.left;
    }

    public int getVal() {
        return this.val;
    }
}