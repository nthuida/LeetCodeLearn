package com.maomao.test.stak;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 两个队列实现栈  一个入栈，一个出栈
 * @author Administrator
 * @date 2019/3/24
 */
public class MyStack<E> {
    private  Queue<E> queue1 = new LinkedList<>();
    private  Queue<E> queue2 = new LinkedList<>();

    /*
     * 向队列中执行入栈操作
     */
    public void push(E item){
        queue1.offer(item);
    }

    /**
     * 1、queue1只有一个元素直接出栈
     * 2、不止一个元素，queue1的元素放入queue2,只剩一个元素，弹出，然后再把queue2的元素放入queue1
     * 出栈
     * @return
     */
    public E pop(){
        E e;
        if(!isEmpty()){
            if (queue1.size() == 1) {
                return queue1.poll();
            } else {
                while (queue1.size() > 1) {
                    queue2.offer(queue1.poll());
                }
                e = queue1.poll();
                while (!queue2.isEmpty()) {
                    queue1.offer(queue2.poll());
                }
            }
        } else {
            throw new RuntimeException("栈为空，无法执行出栈操作");
        }
        return e;
    }

    /*
     * 检查栈是否为空
     */
    public  boolean isEmpty(){
        return queue1.isEmpty()&&queue1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack<String> myStack = new MyStack<>();
        myStack.push("A");
        System.out.println(myStack.pop());
        myStack.push("b");
        myStack.push("c");
        System.out.println(myStack.pop());
        myStack.push("d");
        System.out.println(myStack.pop());
    }
}
