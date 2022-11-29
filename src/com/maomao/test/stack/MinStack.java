package com.maomao.test.stack;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * @author huida
 * @date 2020/5/12
 */
public class MinStack {
    /*private LinkedList<Integer> list = new LinkedList<>();
    int min = Integer.MAX_VALUE;
    public MinStack() {

    }

    *//**
     * 同时保存当前最小值和上一个最小值
     * @param x
     *//*
    public void push(int x) {
        if (x <= min) {
            //保存之前的最小值
            list.addFirst(min);
            min = x;
        }
        list.addFirst(x);
    }

    public void pop() {
        int top = list.getFirst();
        list.removeFirst();
        if (top == min) {
            //更新最小值为上一保存的最小值
            min = list.getFirst();
            //删除之前保存的最小值
            list.removeFirst();
        }
    }

    public int top() {
        return list.getFirst();
    }

    public int getMin() {
        return min;
    }*/

    //主栈，保存元素
    private Stack<Integer> stack;
    //辅助栈，单调递减栈
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    public void push(int x) {
        stack.push(x);
        //当前元素小于等于栈顶元素，入栈
        if(minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        //出栈元素和最小栈栈顶元素相等，最小栈也要出栈
        if(stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
