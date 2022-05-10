package com.maomao.test.design;

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
}
