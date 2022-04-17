package com.maomao.test.stak;

import java.util.LinkedList;

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
    private LinkedList<Integer> list = new LinkedList<>();
    int min = Integer.MAX_VALUE;
    public MinStack() {

    }

    /**
     * 同时保存当前最小值和上一个最小值
     * @param x
     */
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
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.push(-4);
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

    }
}
