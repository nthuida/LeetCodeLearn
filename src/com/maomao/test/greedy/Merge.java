package com.maomao.test.greedy;

import java.util.Arrays;
import java.util.LinkedList;

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
 * @author: huida
 * @date: 2022/7/14
 **/
public class Merge {

    /**
     * 思路：
     * 如果我们按照区间的左端点排序，那么在排完序的列表中，可以合并的区间一定是连续的。
     * 再进行 n -1次 两两合并
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        //按左端点从小到大排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
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
