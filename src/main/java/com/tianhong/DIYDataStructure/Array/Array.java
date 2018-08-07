package com.tianhong.DIYDataStructure.Array;

// 数组最大优点： 快速查询； 数组最好应用在："索引有语意"的情况
public class Array<E> {

    // Capacity == data.length
    private E[] data;
    private int size;

    public Array(int capacity) {
        data = (E[])new Object[capacity];
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
    public void addLast(E e) {
       add(size, e);
    }

    // 向数组指定位置添加一个新元素
    public void add(int index, E e) {
        // 元素必须紧密排列
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, require index >=0 and index <= size");
        }

        if(size == data.length) {
            resize(2*data.length);
        }

        for(int i = size; i > index; i--) {
            data[i] = data[i-1];
        }
        data[index] = e;
        size ++;
    }

    //获取index索引位置的元素
    E get(int index) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed, index is illegal");
        return data[index];
    }

    //修改index索引位置的元素
    void set(int index, E e) {
        if(index < 0 || index >=size)
            throw new IllegalArgumentException("Set failed, index is illegal");
        data[index] = e;
    }

    // 查找数组是否存在元素为e
    public boolean contains(E e) {
        for(int i=0; i < size; i++) {
            if(data[i].equals(e))
                return true;
        }
        return false;
    }

    // 查找数组中元素e所在的索引，如果不存在e， 则返回-1
    public int find(E e) {
        for(int i=0; i < size; i++) {
            if(data[i].equals(e))
                return i;
        }
        return -1;
    }

    // 删除指定索引的元素, 返回删除的元素
    public E remove(int index) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Delete failed, the index is illegal");
        }
        E ret = data[index];
        for(int i = size - 1; i > index; i--) {
            data[i-1] = data[i];
        }
        size--;
        data[size] = null; // loitering objects != memory leak
        // lazy缩容， 防止震荡
        if(size == data.length/4 && data.length != 1) {
            resize((int) (data.length/2));
        }
        return ret;
    }

    //从数组中删除第一个元素， 返回删除的元素
    public E removeFirst() {
        return remove(0);
    }

    //从数组中删除最后一个元素， 返回删除的元素
    public E removeLast() {
        return remove(size -1);
    }

    //从数组中删除元素e
    public void removeElement(E e) {
        int index = find(e);
        if(index != -1)
            remove(index);
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

    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
