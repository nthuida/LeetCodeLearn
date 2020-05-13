package com.maomao.test.stak;

/**
 * 基于链表实现
 * @author Administrator
 * @date 2019/3/17
 */
public class StackOfLinked<E> {
    private class Node<E>{
        E data;
        Node<E> next;
        public Node(){}
        public Node(E e){
            this.data = e;
        }
    }

    private Node<E> top;
    private int size;

    public StackOfLinked(){
        top = null;
    }

    //当前栈大小
    public int length(){
        return size;
    }

    //判空
    public boolean empty(){
        return size == 0;
    }

    //入栈：让top指向新创建的元素，新元素的next引用指向原来的栈顶元素
    public void push(E e){
        Node newNode = new Node(e);
        newNode.next = top;
        top = newNode;
        size ++;
    }

    //查看栈顶元素但不删除
    public E peek(){
        if(empty()){
            throw new RuntimeException("空栈异常！");
        }else{
            return top.data;
        }
    }

    //出栈
    public E pop(){
        if(empty()){
            throw new RuntimeException("空栈异常！");
        }else{
            //得到栈顶元素
            E value = top.data;
            //让top引用指向原栈顶元素的下一个元素
            top = top.next;
            size --;
            return value;
        }
    }

    public static void main(String[] args) {
        StackOfLinked<String> stack = new StackOfLinked<>();
        System.out.println(stack.size);
        System.out.println(stack.empty());
        stack.push("a");
        stack.push("b");
        System.out.println(stack.peek());
        System.out.println(stack.pop());
    }
}
