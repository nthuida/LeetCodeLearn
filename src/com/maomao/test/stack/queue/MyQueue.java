package com.maomao.test.stack.queue;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * 思路：一个栈用于入队列，另一个用于出队列
 * @author Administrator
 * @date 2019/3/24
 */
public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int e) {
        stack1.add(e);
    }

    /**
     *返回头元素，并删除
     */
    public int pop() {
        if (empty()) {
            return -1;
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
    public int peek() {
        if (empty()) {
            return -1;
        }else if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.add(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }

}
