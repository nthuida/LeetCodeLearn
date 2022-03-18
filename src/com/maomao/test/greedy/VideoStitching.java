package com.maomao.test.greedy;

import java.util.Arrays;

/**
 * 视频拼接
 * 你将会获得一系列视频片段，这些片段来自于一项持续时长为 time 秒的体育赛事。这些片段可能有所重叠，也可能长度不一。
 * 使用数组 clips 描述所有的视频片段，其中 clips[i] = [starti, endi] 表示：某个视频片段开始于 starti 并于 endi 结束。
 * 甚至可以对这些片段自由地再剪辑：
 * 例如，片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。
 * 我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, time]）。返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。
 *
 * 示例 1：
 * 输入：clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], time = 10
 * 输出：3
 * 解释：
 * 选中 [0,2], [8,10], [1,9] 这三个片段。
 * 然后，按下面的方案重制比赛片段：
 * 将 [1,9] 再剪辑为 [1,2] + [2,8] + [8,9] 。
 * 现在手上的片段为 [0,2] + [2,8] + [8,10]，而这些覆盖了整场比赛 [0, 10]。
 *
 * 示例 2：
 * 输入：clips = [[0,1],[1,2]], time = 5
 * 输出：-1
 * 解释：
 * 无法只用 [0,1] 和 [1,2] 覆盖 [0,5] 的整个过程。
 *
 * @author: huida
 * @date: 2021/12/18
 **/
public class VideoStitching {

    /**
     * 贪心算法
     * 先按照起点升序排序，如果起点相同的话按照终点降序排序
     * @param clips
     * @param time
     * @return
     */
    public int videoStitching(int[][] clips, int time) {
        //排序
        Arrays.sort(clips, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            } else {
                return a[0] - b[0];
            }
        });
        //计数
        int res = 0;
        int i = 0;
        //区间终点，初始化为0
        int curEnd = 0, nextEnd = 0;
        int n = clips.length;
        while (i<n && clips[i][0] <= curEnd) {
            while (i<n && clips[i][0] <= curEnd) {
                //贪心选择终点最大的区间
                nextEnd = Math.max(nextEnd, clips[i][1]);
                i++;
            }
            //找下一个视频，更新 curEnd
            res++;
            curEnd = nextEnd;
            if (nextEnd >= time) {
                return res;
            }

        }
        return -1;

    }
}
