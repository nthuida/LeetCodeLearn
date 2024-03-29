package com.maomao.test.queue;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 *
 * @author huida
 * @date 2020/6/30
 */
public class CQueue {

    /**
     * 入队
     */
    private Stack<Integer> stack1;
    /**
     * 出队
     */
    private Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.add(value);
    }

    public int deleteHead() {
        if (stack1.empty() && stack2.empty()) {
            return -1;
        }else if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.add(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
