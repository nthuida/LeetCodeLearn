package com.maomao.test.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 无重叠区间
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * 注意:
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 *
 * 示例 1:
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 * 输出: 1
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 *
 * 示例 2:
 * 输入: [ [1,2], [1,2], [1,2] ]
 * 输出: 2
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 *
 * 示例 3:
 * 输入: [ [1,2], [2,3] ]
 * 输出: 0
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 *
 * @author: huida
 * @date: 2020/12/31
 **/
public class EraseOverlapIntervals {

    /**
     * 贪心算法
     * 如果后面区间的头小于当前区间的尾，为了防止在下一个区间和现有区间有重叠，
     * 应该让现有区间越短越好，所以应该移除尾部比较大的。
     *
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        //左边界从小到大排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int res = 0;
        //最小右边界
        int rightMin = intervals[0][1];
        for (int i=1; i<intervals.length; i++) {
            if (intervals[i][0] < rightMin) {
                res++;
                //保留右边界小的那个
                rightMin = Math.min(rightMin, intervals[i][1]);
            } else {
                rightMin = intervals[i][1];
            }
        }
        return res;
    }
}
