package com.maomao.test.linkedlist;

/**
 * @author Administrator
 * @date 2019/3/6
 */
public class LinkedListNode {
    public int data;
    public LinkedListNode next;
    public LinkedListNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public LinkedListNode getNext() {
        return next;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }
}
