package com.maomao.test.stak;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 两个队列实现栈  一个入栈，一个出栈
 * @author Administrator
 * @date 2019/3/24
 */
public class MyStack {
    private  Queue<Integer> queue1;
    private  Queue<Integer> queue2;
    int top;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x){
        queue1.offer(x);
        top = x;
    }

    /**
     * 1、queue1只有一个元素直接出栈
     * 2、不止一个元素，queue1的元素放入queue2,只剩一个元素，弹出，然后再把queue2的元素放入queue1
     * 出栈
     */
    public int pop(){
        int e;
        if (queue1.size() == 1) {
            return queue1.poll();
        } else {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            e = queue1.poll();
            while (!queue2.isEmpty()) {
                int temp = queue2.poll();
                queue1.offer(temp);
                top = temp;
            }
        }
        return e;
    }

    public int top() {
        return top;
    }


    public  boolean isEmpty(){
        return queue1.isEmpty()&&queue2.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.isEmpty());
    }
}
