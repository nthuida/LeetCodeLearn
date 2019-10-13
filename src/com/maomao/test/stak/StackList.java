package com.maomao.test.stak;

import java.util.LinkedList;

/**
 * 基于LinkedList实现栈
 * @author Administrator
 * @date 2019/3/17
 */
public class StackList<E> {

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

    //打印栈元素
    public String toString(){
        return list.toString();
    }

    public static void main(String[] args) {
        StackList<String> stackList = new StackList<>();
        stackList.push("fakjkljsa");
        stackList.push("dd");
        System.out.println(stackList.toString());
    }
}
