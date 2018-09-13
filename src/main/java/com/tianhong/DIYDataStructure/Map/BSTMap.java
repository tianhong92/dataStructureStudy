package com.tianhong.DIYDataStructure.Map;

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V>{
    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public Node(K key, V value, Node left, Node right){
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
        public Node(K key, V value){
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BSTMap(){
        root = null;
        size = 0;
    }

    // 向二分搜索树中添加新的元素（key, value)
    @Override
    public void add(K key, V value) {
        add(root, key, value);
    }

    // 向以node为根的二分搜索树中插入元素（key value), 递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node, K key, V value){
        if(node == null){
            size++;
            return new Node(key, value);
        }
        else if(node.key.compareTo(key) < 0){
            node.right = add(node.right, key, value);
        } else if(node.key.compareTo(key) > 0){
            node.left = add(node.left, key, value);
        }
        return node;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(root, key);
        if(node == null){
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
        node.value = value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    // 返回以node为根节点的二分搜索树中， key所在的节点
    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) == 0) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }
    }

    // 删除node为根节点的二分搜索树的最小节点
    // 返回根节点
//    private Node removeMin(Node node){
//        if(node == null){
//            return null;
//        }
//        removeMin(node.left);
//    }

    // 找到node为根节点的二分搜索树的最小节点
    // 返回给节点
}
