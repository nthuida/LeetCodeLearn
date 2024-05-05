package com.maomao.test.search.sort;

import java.util.*;

/**
 * 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * @author huida
 * @date 2020/9/1
 */
public class TopKFrequent {

    /**
     * 最小堆实现
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        //map计数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        //优先队列: 最小堆 保存频率最大的k个数
        //比较的是map的value
        //Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        Queue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (int key : map.keySet()) {
            minHeap.add(key);
            if (minHeap.size() > k) {
                //保持最小堆
                minHeap.poll();
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll();
        }
        return res;

    }
}
