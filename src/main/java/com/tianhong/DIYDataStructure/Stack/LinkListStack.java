package com.tianhong.DIYDataStructure.Stack;

import com.tianhong.DIYDataStructure.LinkedList.DummyHeadLinkedList;
import com.tianhong.DIYDataStructure.LinkedList.LinkedList;

public class LinkListStack<E> implements Stack<E> {
    private DummyHeadLinkedList<E> linkedList;
    public LinkListStack() {
        this.linkedList = new DummyHeadLinkedList<>();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedList.addLast(e);
    }

    @Override
    public E pop() {
        return linkedList.removeLast();
    }

    @Override
    public E peak() {
        return linkedList.getLast();
    }

    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder();
        ret.append("bot [");
        for(int i = 0; i < linkedList.getSize(); i++){
            ret.append(linkedList.get(i).toString());
            if(i != (linkedList.getSize() - 1)){
                ret.append(", ");
            }
        }
        ret.append("] top");
        return ret.toString();
    }

    public static void main(String[] args) {
        LinkListStack<Integer> stack = new LinkListStack();
        for(int i = 0; i < 5; i++){
            stack.push(i);
        }
        System.out.println(stack);
        for(int j = 0; j < 3; j++){
            stack.pop();
        }
        System.out.println(stack);
    }
}
