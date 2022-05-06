package com.maomao.test.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * 合并两个有序数组
 *
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * 示例:
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 *
 * @Author huida.mao
 * @Date 2019/10/14
 */
public class Merge {
    /**
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] merge = new int[m+n];
        int i = 0,j=0,k=0;
        while(i<m && j<n) {
            if (nums1[i] <= nums2[j]) {
                merge[k++] = nums1[i++];
            } else {
                merge[k++] = nums2[j++];
            }
        }
        while (i<m) {
            merge[k++] = nums1[i++];
        }
        while (j<n) {
            merge[k++] = nums2[j++];
        }
        System.arraycopy(merge,0,nums1,0,k);
    }

    /**
     * 合并区间
     * 给出一个区间的集合，请合并所有重叠的区间。
     *
     * 示例 1:
     * 输入: [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     *
     * 示例 2:
     * 输入: [[1,4],[4,5]]
     * 输出: [[1,5]]
     * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
     *
     * 思路：
     * 如果我们按照区间的左端点排序，那么在排完序的列表中，可以合并的区间一定是连续的。
     * 再进行 n -1次 两两合并
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        //按左端点从小到大排序
        Arrays.sort(intervals, (a,b) -> {
            return a[0] - b[0];
        });
        LinkedList<int[]> res = new LinkedList<>();
        res.add(intervals[0]);
        for (int i=1; i<intervals.length; i++) {
            //当前数组
            int[] cur = intervals[i];
            //保存的数组
            int[] last = res.getLast();
            if (last[1] < cur[0]) {
                //前一个的end 比 当前的start 还小，不合并
                res.add(cur);
            } else {
                last[1] = Math.max(last[1], cur[1]);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }

}
