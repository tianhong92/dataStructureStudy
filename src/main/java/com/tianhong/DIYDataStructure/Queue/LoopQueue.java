package com.tianhong.DIYDataStructure.Queue;

public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    // 队首所在的索引， 队列最后一个元素的下一个位置
    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue(){
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        if((tail + 1)%data.length == front){
            resize(getCapacity()*2);
        }
        data[tail] = e;
        tail = (tail+1)%data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        E ret = data[front];
        front = (front + 1)%data.length;
        size --;
        if(size == getCapacity()/4 && getCapacity()/2 != 0){
            resize(getCapacity()/2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Cannot get element from an empty queue");
        }
        return data[front];
    }

    private void resize(int capacity) {
        E[] newData = (E[])new Object[capacity + 1];
        for(int i = 0; i < size; i++){
            newData[i] = data[(i + front)%data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Queue: size = %d, capacity = %d\n", size, getCapacity()));
        builder.append("front [");
        System.out.println("length: "+data.length);
        System.out.println("size: "+size);
        for(int i = front; i != tail; i = ( i + 1 ) % data.length){
            builder.append(data[i]);
            if((i + 1) % data.length != tail){
                builder.append(", ");
            }
        }
        builder.append("] tail");
        return builder.toString();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LoopQueue<>();
        for(int i = 0; i < 10; i++) {
            queue.enqueue(i);
            if(i%4 == 3) {
                System.out.println(queue);
            }
        }
        System.out.println(queue);
        for(int i = 0; i < 5; i++){
            queue.dequeue();
            System.out.println(queue);
        }
    }
}
