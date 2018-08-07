package com.tianhong.DIYDataStructure;

// 数组最大优点： 快速查询； 数组最好应用在："索引有语意"的情况
public class Array {

    private int[] data;
    private int size;

    /**
     *
     * @param capacity
     */

    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    // 无参构造函数， 默认容量capacity=10
    public Array() {
        this(10);
    }

    // 获取数组中元素个数
    public int getSize() {
        return size;
    }

    // 获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    // 返回数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 向所有元素后添加一个新元素
    public void addLast(int e) {
       add(size, e);
    }

    // 向数组指定位置添加一个新元素
    public void add(int index, int e) {
        if(size == data.length) {
            throw new IllegalArgumentException("Add failed, the array is full.");
        }
        // 元素必须紧密排列
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, require index >=0 and index <= size");
        }
        for(int i = size; i > index; i--) {
            data[i] = data[i-1];
        }
        data[index] = e;
        size ++;
    }

    //获取index索引位置的元素
    int get(int index) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed, index is illegal");
        return data[index];
    }

    //修改index索引位置的元素
    void set(int index, int e) {
        if(index < 0 || index >=size)
            throw new IllegalArgumentException("Set failed, index is illegal");
        data[index] = e;
    }
    //数组中查询元素， 如果存在返回下标， 如果不存在返回-1
    public int findIndex(int e) {
        for(int i = 0; i < size; i++) {
            if(data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append('[');
        for(int i = 0; i < size; i++) {
            res.append(data[i]);
            if(i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }
}
