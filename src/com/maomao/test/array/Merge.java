package com.maomao.test.array;

import java.util.Arrays;
import java.util.Comparator;

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
        int len = intervals.length;
        if (len < 2) {
            return intervals;
        }
        // 按照左端点排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        // 遍历区间
        int[][] res = new int[intervals.length][2];
        int index = -1;
        for (int i=0; i<intervals.length; i++) {
            // 如果当前区间的起始位置 > 结果数组中最后区间的终止位置，
            // 则不合并，直接将当前区间加入结果数组。
            if (index == -1 || intervals[i][0] > res[index][1]) {
                res[++index] = intervals[i];
            } else {
                // 反之将当前区间合并至结果数组的最后区间
                res[index][1] = Math.max(res[index][1], intervals[i][1]);
            }
        }
        return Arrays.copyOf(res, index + 1);
    }

    public static void main(String[] args) {
        int[][] a = {{1,3},{2,6},{8,10},{15,18}};
        int[][] res = new Merge().merge(a);
        for (int i=0; i<res.length; i++) {
            for (int j=0; j<res[i].length; j++) {
                System.out.println(res[i][j]);
            }
        }
    }
}
