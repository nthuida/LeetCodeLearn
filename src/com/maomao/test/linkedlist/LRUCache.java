package com.maomao.test.linkedlist;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Administrator
 * @date 2019/4/23
 */
public class LRUCache {
    private Map<Integer, Integer> map;
    public LRUCache(int capacity) {
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        map.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));      // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));     // 返回 -1 (未找到)
        System.out.println(cache.get(3));     // 返回  3
        System.out.println(cache.get(4));     // 返回  4
    }
}
