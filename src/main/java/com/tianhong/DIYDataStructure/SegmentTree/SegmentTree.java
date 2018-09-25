package com.tianhong.DIYDataStructure.SegmentTree;

public class SegmentTree<E> {
    private E[] tree;
    private E[] data;
    public SegmentTree(E[] arr){
        data = (E[])new Object[arr.length];
        for(int i = 0; i < arr.length; i++)
            data[i] = arr[i];
        tree = (E[])new Object[4 * arr.length];
    }

    public E get(int index){
        if(index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index is illegal");
        return data[index];
    }

    public int getSize(){
        return data.length;
    }

    // 返回一个完全二叉树数组表示中， 一个索引所表示元素的左孩子节点的索引
    private int leftChild(int index){
        return 2*index + 1;
    }

    private int rightChild(int index){
        return 2*index + 2;
    }


}
