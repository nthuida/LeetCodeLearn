package com.maomao.test.design;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * 当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近最久未使用 的键。
 * @author: huida
 * @date: 2021/11/28
 **/
public class LFUCache {

    /**
     * 容量
     */
    private int capacity;
    /**
     * 当前最小访问次数
     */
    private int minFreq;
    /**
     *保存 (k，v)
     */
    private HashMap<Integer, Integer> keyToValMap;

    /**
     * 保存key到频率的映射
     */
    private HashMap<Integer, Integer> keyToFreqMap;
    /**
     * 访问次数对应的链表，LinkedHashSet有顺序
     */
    private HashMap<Integer, LinkedHashSet<Integer>> freqToListMap;

    public LFUCache(int capacity) {
        this.capacity=capacity;
        keyToValMap = new HashMap<>();
        keyToFreqMap = new HashMap<>();
        freqToListMap = new HashMap<>();
        minFreq=0;
    }

    public int get(int key) {
        if (!keyToValMap.containsKey(key)) {
            return -1;
        }
        increaseFreq(key);
        return keyToValMap.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        if (keyToValMap.containsKey(key)) {
            keyToValMap.put(key, value);
            increaseFreq(key);
        } else {
            if (capacity == keyToValMap.size()) {
                //满了
                removeMinFreqKey();
            }
            //插入值
            keyToValMap.put(key, value);
            keyToFreqMap.put(key, 1);
            freqToListMap.putIfAbsent(1, new LinkedHashSet<>());
            freqToListMap.get(1).add(key);
            //更新最小频率
            minFreq = 1;
        }

    }

    /**
     * 更新访问次数等信息
     * @param key
     */
    private void increaseFreq(int key) {
        //原次数
        int freq = keyToFreqMap.get(key);
        //次数加1
        int newFreq = freq + 1;
        keyToFreqMap.put(key, newFreq);
        //原次数对应的列表中删除当前key
        freqToListMap.get(freq).remove(key);
        if (freqToListMap.get(freq).isEmpty()) {
            //为空，删除
            freqToListMap.remove(freq);
            if (freq == minFreq) {
                //更新最小频率；
                minFreq++;
            }
        }
        //新次数对应列表
        LinkedHashSet<Integer> set = freqToListMap.getOrDefault(newFreq, new LinkedHashSet<>());
        set.add(key);
        freqToListMap.put(newFreq, set);
    }

    /**
     * 删除最低频率的值
     */
    private void removeMinFreqKey() {
        LinkedHashSet<Integer> linkedHashSet = freqToListMap.get(minFreq);
        //链表头节点，最近最少使用
        int deleteKey = linkedHashSet.iterator().next();
        //删除key对应的值、次数、链表
        keyToValMap.remove(deleteKey);
        keyToFreqMap.remove(deleteKey);
        linkedHashSet.remove(deleteKey);
        //删除空链表
        if (linkedHashSet.isEmpty()) {
            freqToListMap.remove(minFreq);
        }

    }
}
