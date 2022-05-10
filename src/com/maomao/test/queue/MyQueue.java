package com.maomao.test.queue;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * 思路：一个栈用于入队列，另一个用于出队列
 * @author Administrator
 * @date 2019/3/24
 */
public class MyQueue<E> {
    private Stack<E> stack1 = new Stack<>();
    private Stack<E> stack2 = new Stack<>();

    public void add(E e) {
        stack1.add(e);
    }

    /**
     *返回头元素，并删除
     */
    public E pop() {
        if (empty()) {
            throw new RuntimeException("empty");
        }else if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.add(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /**
     *返回头元素，不删除删除
     */
    public E peek() {
        if (empty()) {
            throw new RuntimeException("empty");
        }else if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.add(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.empty();
    }

}
