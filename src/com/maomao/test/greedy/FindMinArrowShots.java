package com.maomao.test.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 用最少数量的箭引爆气球
 * 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend，
 * 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。
 *
 * 给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
 *
 * 示例 1：
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：对于该样例，x = 6 可以射爆 [2,8],[1,6] 两个气球，以及 x = 11 射爆另外两个气球
 *
 * 示例 2：
 * 输入：points = [[1,2],[3,4],[5,6],[7,8]]
 * 输出：4
 *
 * 示例 3：
 * 输入：points = [[1,2],[2,3],[3,4],[4,5]]
 * 输出：2
 *
 * @author huida
 * @date 2020/11/23
 */
public class FindMinArrowShots {

    /**
     *
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        //按左边界从小到大排序
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int res = 1;
        //最小右边界
        int pos = points[0][1];
        for (int i=1; i<points.length; i++) {
            //气球的左边位置大于最小边界，就需要另一只箭才能射破
            if (points[i][0] > pos) {
                res++;
                //更新最小右边界
                pos = points[i][1];
            } else {
                //俩区间有重叠，保留右边界小的那个
                pos = Math.min(pos, points[i][1]);
            }
        }
        return res;
    }
}
