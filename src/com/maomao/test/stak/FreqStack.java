package com.maomao.test.stak;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 最大频率栈
 * 实现 FreqStack，模拟类似栈的数据结构的操作的一个类。
 * FreqStack 有两个函数：
 * push(int x)，将整数 x 推入栈中。
 * pop()，它移除并返回栈中出现最频繁的元素。
 * 如果最频繁的元素不只一个，则移除并返回最接近栈顶的元素。
 *
 * @author: huida
 * @date: 2021/11/29
 **/
public class FreqStack {

    private int maxFreq = 0;

    /**
     * key对应的频率
     */
    private Map<Integer, Integer> keyToFreq = new HashMap<>();
    /**
     * 频率对应的存储栈
     */
    private Map<Integer, Stack<Integer>> freqToList = new HashMap<>();

    public FreqStack() {

    }

    public void push(int val) {
        int freq = keyToFreq.getOrDefault(val, 0) + 1;
        keyToFreq.put(val, freq);
        freqToList.putIfAbsent(freq, new Stack<>());
        freqToList.get(freq).push(val);
        maxFreq = Math.max(freq, maxFreq);
    }

    public int pop() {
        Stack<Integer> stack = freqToList.get(maxFreq);
        int key = stack.pop();
        int freq = keyToFreq.get(key) - 1;
        keyToFreq.put(key, freq);
        //最大频率减1
        if (stack.isEmpty()) {
            maxFreq--;
        }

        return key;
    }
}
