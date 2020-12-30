package com.maomao.test.array;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: huida
 * @date: 2020/12/30
 **/
public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        //最大堆
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int a : stones) {
           pq.offer(a);
        }
        while (pq.size() >1) {
            int a = pq.poll();
            int b = pq.poll();
            if (a > b) {
                pq.offer(a-b);
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }
}
