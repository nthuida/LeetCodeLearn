package com.maomao.test.array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 最小的K个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 *
 * 示例 2：
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 * @author huida
 * @date 2020/6/10
 */
public class GetLeastNumbers {

    /**
     * 直接通过快排切分排好第 K 小的数（下标为 K-1），那么它左边的数就是比它小的另外 K-1 个数
     * 复杂度O(n)
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 下标为k-1的数
        return sort(arr, 0, arr.length - 1, k - 1);
    }

    public int[] sort(int[] arrary, int low, int high, int pos) {
        int mid = getMid(arrary, low, high);
        if (mid == pos) {
            //最小的k个数
            return Arrays.copyOf(arrary,pos+1);
        } else if(mid > pos) {
            //左边
           return sort(arrary, low, mid-1, pos);
        } else {
            return sort(arrary, mid+1, high, pos);
        }

    }

    public int getMid(int[] arrary, int low, int high) {
        //基准元素
        int temp = arrary[low];
        while (low < high) {
            while (low < high && arrary[high] >= temp) {
                high--;
            }
            arrary[low] = arrary[high];
            while (low < high && arrary[low] <= temp) {
                low++;
            }
            arrary[high] = arrary[low];
        }
        //中间元素和位置
        arrary[low] = temp;
        return low;
    }

    /**
     * 最大堆实现
     * 保持堆的大小为K，然后遍历数组中的数字，遍历的时候做如下判断：
     * 若目前堆的大小小于K，将当前数字放入堆中。
     * 否则判断当前数字与堆顶元素的大小关系，如果当前数字比堆顶还大，这个数就直接跳过；
     * 反之如果当前数字比堆顶小，先poll掉堆顶，再将该数字放入堆中
     * 时间复杂度 O(nlogk)
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbersII(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 默认是小根堆，实现大根堆需要重写一下比较器。优先队列
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num: arr) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (num < pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }

        // 返回堆中的元素
        int[] res = new int[pq.size()];
        int idx = 0;
        for(int num: pq) {
            res[idx++] = num;
        }
        return res;
    }

}
