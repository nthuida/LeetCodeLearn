package com.maomao.test.linkedlist;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 根据题意，「当存在平局（即两个或更多个键具有相同使用频率）时，最近最少使用的键将被去除」，
 * 即在「访问次数」相同的情况下，按照时间顺序，先删除在缓存里时间最久的数据。
 * 核心思想：先考虑访问次数，在访问次数相同的情况下，再考虑缓存的时间
 *
 *
 *
 * @author huida
 * @date 2020/5/26
 */
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
    private HashMap<Integer,Node> cache;
    /**
     * 访问次数对应的链表
     */
    private HashMap<Integer, LinkedList<Node>> freqMap;

    public LFUCache(int capacity) {
        this.capacity=capacity;
        cache = new HashMap<>(capacity);
        freqMap = new HashMap<>();
        minFreq=0;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        //更新访问次数对应map
        freqInc(node);
        return node.getValue();
    }


    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = cache.get(key);
        if (node != null) {
            //更新
            node.setValue(value);
            freqInc(node);
            return;
        }
        node = new Node(key, value);
        node.freqInc();
        if (cache.size() == capacity) {
            //已满，删除访问次数最小的
            LinkedList<Node> minFreqList = freqMap.get(minFreq);
            //最小次数链表删除尾节点
            Node nodeLast = minFreqList.removeLast();
            //cache删除
            cache.remove(nodeLast.getKey());
        }
        cache.put(key, node);
        LinkedList<Node> fredList = freqMap.get(1);
        if (fredList == null) {
            fredList = new LinkedList<>();
            freqMap.put(1, fredList);
        }
        fredList.addFirst(node);
        minFreq = 1;
    }

    /**
     * 更新次数、freqMap等信息
     * @param node
     */
    void freqInc(Node node) {
        int freq = node.getFreq();
        LinkedList<Node> oriList = freqMap.get(freq);
        //在原次数对应的链表中删除当前节点
        oriList.remove(node);
        //put或者get时更新最小访问次数
        if (node.getFreq() == minFreq && oriList.isEmpty()) {
            minFreq++;
        }
        //新次数对应的链表
        LinkedList<Node> newList = freqMap.get(freq + 1);
        if (newList == null) {
            newList = new LinkedList<>();
            freqMap.put(freq+1, newList);
        }
        //最新访问的加入头结点位置
        newList.addFirst(node);
        //node的访问次数+1
        node.freqInc();
    }

    /**
     * 内部类，
     */
    class Node {
        private int key;
        private int value;
        private int freq = 0;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public int getFreq() {
            return freq;
        }

        public void freqInc() {
            freq++;
        }
    }


    public static void main(String[] args) {
        LFUCache cache = new LFUCache(3);
        cache.put(2,2);
        cache.put(1,1);
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        cache.put(3,3);
        cache.put(4,4);
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        System.out.println(cache.get(4));
    }

}
