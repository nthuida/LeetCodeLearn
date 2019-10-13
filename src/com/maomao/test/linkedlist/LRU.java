package com.maomao.test.linkedlist;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Administrator
 * @date 2019/4/11
 */
public class LRU {
    public static void main(String[] args) {
        int cacheSize = 5;
        Map<String, String> map = new LinkedHashMap<String, String>(cacheSize, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > cacheSize;
            }
        };
        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        map.put("4","4");
        map.put("5","5");
        map.get("3");
        map.put("6", "6");
        for (String key : map.keySet()) {
            System.out.println(key);
        }


    }
}
