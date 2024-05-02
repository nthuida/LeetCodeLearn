package com.maomao.test.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 两个队列实现栈
 * @author Administrator
 * @date 2019/3/24
 */
public class MyStack {
    /**
     * 主队列，存储栈内元素
     */
    private  Queue<Integer> queue1;
    /**
     * 辅助队列
     */
    private  Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x){
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            //把queue1元素放入queue2，先进变成后出
            queue2.offer(queue1.poll());
        }
        //交换queue1和queue2
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }


    /**
     * 用一个队列实现
     * @param x
     */
    public void push1(int x) {
        int size = queue1.size();
        queue1.offer(x);
        //把前面的元素放到新加入的后面，形成后进先出
        for (int i=0; i<size; i++) {
            queue1.offer(queue1.poll());
        }
    }




    public int pop(){
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }


    public  boolean isEmpty(){
        return queue1.isEmpty();
    }

}
