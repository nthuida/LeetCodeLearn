package com.maomao.test.linkedlist;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * @author: huida
 * @date: 2021/11/28
 **/
public class LFUCache1 {

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
    private HashMap<Integer, Integer> keyTofreqMap;
    /**
     * 访问次数对应的链表
     */
    private HashMap<Integer, LinkedHashSet<Integer>> freqToListMap;

    public LFUCache1(int capacity) {
        this.capacity=capacity;
        keyToValMap = new HashMap<>();
        keyTofreqMap = new HashMap<>();
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
            keyToValMap.put(key, value);
            keyTofreqMap.put(key, 1);
            freqToListMap.putIfAbsent(1, new LinkedHashSet<>());
            freqToListMap.get(1).add(key);
            minFreq = 1;
        }

    }

    private void increaseFreq(int key) {
        int freq = keyTofreqMap.get(key);
        int newFreq = freq + 1;
        keyTofreqMap.put(key, newFreq);
        freqToListMap.get(freq).remove(key);
        freqToListMap.putIfAbsent(newFreq, new LinkedHashSet<>());
        freqToListMap.get(newFreq).add(key);
        if (freqToListMap.get(freq).isEmpty()) {
            //为空，删除
            freqToListMap.remove(freq);
            if (freq == minFreq) {
                //更新最小频率；
                minFreq++;
            }
        }

    }

    /**
     * 删除最低频率的值
     */
    private void removeMinFreqKey() {
        LinkedHashSet<Integer> linkedHashSet = freqToListMap.get(minFreq);
        int deleteKey = linkedHashSet.iterator().next();
        keyToValMap.remove(deleteKey);
        keyTofreqMap.remove(deleteKey);
        linkedHashSet.remove(deleteKey);
        if (linkedHashSet.isEmpty()) {
            freqToListMap.remove(minFreq);
        }

    }
}
