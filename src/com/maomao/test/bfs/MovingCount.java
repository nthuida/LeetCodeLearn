package com.maomao.test.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，
 * 因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * 示例 1：
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 *
 * 示例 2：
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 *
 * @author huida
 * @date 2020/5/22
 */
public class MovingCount {

    /**
     * BFS
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        int count = 0;
        boolean[][] visted = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        //加入（0,0）
        queue.add(new int[]{0,0});
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            int x = top[0];
            int y = top[1];
            if (x < 0 || x >= m || y < 0 || y >= n || visted[x][y] || k < (count(x)+count(y))) {
                continue;
            }
            count++;
            visted[x][y] = true;
            //加入当前坐标的下方和右方
            queue.offer(new int[]{x, y+1});
            queue.offer(new int[]{x+1, y});
        }
        return count;
    }

    public int count(int a) {
        int sum = 0;
        while (a!=0) {
            sum += a%10;
            a = a/10;
        }
        return sum;
    }

}
