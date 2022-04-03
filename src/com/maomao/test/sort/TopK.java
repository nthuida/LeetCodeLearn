package com.maomao.test.sort;

import java.util.*;

/**
 * topk 问题
 *
 * 基于最小堆的解法：
 * 为了查找Top K个大的数，我们可以使用最小堆来存储最大的K个元素。最小堆的堆顶元素就是最大K个数中最小的一个。
 * 每次考虑下一个数x时，如果x比堆顶元素小，则不需要改变原来的堆。如果想x比堆顶元素大，那么用x替换堆顶元素，
 * 同时，在替换之后，x可能破坏最小堆的结构，需要调整堆来维持堆的性质
 * @Author huida.mao
 * @Date 2019/11/25
 */
public class TopK<T> {

    /**
     * 堆的边界，Top K 问题中的 K
     */
    private final int boundary;

    /**
     * 优先队列:底层使用堆来实现,用来构造一个有界的堆
     */
    private final PriorityQueue<T> boundaryHeap;


    /**
     * 通过自定义边界 boundary 可以求解 top K 问题
     * 通过自定义比较器 comparator 可以控制求解 top K 大 还是 top K 小
     * @param boundary 边界 K
     * @param comparator 数据比较器
     */
    public TopK(int boundary, Comparator<T> comparator) {
        this.boundary = boundary;
        boundaryHeap = new PriorityQueue<>(boundary, comparator);
    }

    /**
     * 向有界堆中添加元素的帮助方法
     * @param t 待添加数据
     */
    private void add(T t) {
        boundaryHeap.add(t);
        if (boundaryHeap.size() > boundary) {
            boundaryHeap.poll();
        }
    }

    public List<T> sortedList() {
        List<T> list = new ArrayList<>(boundaryHeap);
        return list;
    }

    public static void main(String[] args) {
        int[] array = {4, 5, 1, 6, 2, 7, 3, 8};
        TopK pq = new TopK(4, (Comparator<Integer>) (o1, o2) -> {
            // 最大堆用o2 - o1，最小堆用o1 - o2
            return (o1.compareTo(o2));
        });
        for (int n : array) {
            pq.add(n);
        }
        System.out.println(pq.sortedList());
    }

}
