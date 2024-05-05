package com.maomao.test.search.sort;

import java.util.*;

/**
 * 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，
 * 而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明: 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * @author huida
 * @date 2020/6/29
 */
public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        //默认最小堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i: nums) {
            queue.add(i);
            //超过，删除堆顶元素
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }


}
