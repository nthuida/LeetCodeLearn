package com.maomao.test.stack;

import java.util.LinkedList;

/**
 * 基于LinkedList实现栈
 * @author Administrator
 * @date 2019/3/17
 */
public class StackOfList<E> {

    private LinkedList<E> list = new LinkedList<E>();
    //入栈
    public void push(E e){
        list.addFirst(e);
    }

    //查看栈顶元素但不移除
    public E peek(){
        return list.getFirst();
    }

    //出栈
    public E pop(){
        return list.removeFirst();
    }

    //判空
    public boolean empty(){
        return list.isEmpty();
    }

    public static void main(String[] args) {
        StackOfList<String> stackOfList = new StackOfList<>();
        stackOfList.push("fakjkljsa");
        stackOfList.push("dd");
        System.out.println(stackOfList.toString());
    }
}
