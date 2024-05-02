package com.maomao.test.array;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 最接近原点的 K 个点
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 *
 * 示例 1：
 *
 * 输入：points = [[1,3],[-2,2]], K = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 *
 * @author huida
 * @date 2020/11/10
 */
public class Kclosest {

    public int[][] kClosest(int[][] points, int K) {
        if (K == 0 || points.length == 0) {
            return new int[0][2];
        }
        // 默认是小项堆，实现大项堆需要重写一下比较器。优先队列
        PriorityQueue<int []> pq = new PriorityQueue<>((p1, p2) -> (p2[0] * p2[0] + p2[1] * p2[1]) - (p1[0] * p1[0] + p1[1] * p1[1]));
        for (int[] point: points) {
            if (pq.size() < K) {
                pq.offer(point);
            } else if (pq.comparator().compare(point, pq.peek()) > 0) {
                // 否则，判断当前点的距离是否小于堆中的最大距离，若是，则将堆中最大距离poll出，将当前点加入堆中?
                pq.poll();
                pq.offer(point);
            }
        }

        // 返回堆中的元素
        int[][] res = new int[pq.size()][2];
        int idx = 0;
        for(int[] point: pq) {
            res[idx++] = point;
        }
        return res;
    }
}
