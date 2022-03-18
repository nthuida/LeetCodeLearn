package com.maomao.test.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 * 两个相邻元素间的距离为 1 。
 *
 * 示例 1:
 * 输入:
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 输出:
 * 0 0 0
 * 0 1 0
 * 0 0 0
 *
 * 示例 2:
 * 输入:
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 输出:
 * 0 0 0
 * 0 1 0
 * 1 2 1
 *
 * @author huida
 * @date 2020/5/18
 */
public class UpdateMatrix {
    /**
     * 一、广度优先搜索
     * 思路
     * 首先把每个源点 0入队，然后从各个 0 同时开始一圈一圈的向 1 扩散（每个 1 都是被离它最近的 0 扩散到的 ），
     * 扩散的时候可以设置 int[][] dist 来记录距离并同时标志是否访问过。
     *
     * @param matrix
     * @return
     */
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return matrix;
        }
        int[][] directions = new int[][]{{0,-1},{0,1},{1,0},{-1,0}};
        Queue<int[]> queue = new LinkedList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] res = new int[n][m];
        // 标记当前位置是否都看过
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    //0入队列
                    queue.offer(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] pop = queue.poll();
            int x = pop[0], y = pop[1];
            // BFS 搜索四个方向
            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (newX < 0 || newX >= n || newY < 0 || newY >= m || visited[newX][newY]) {
                    continue;
                }
                // 距离更新
                res[newX][newY] = res[x][y] + 1;
                visited[newX][newY] = true;
                // 新元素入队
                queue.add(new int[]{newX, newY});
            }
        }
        return res;
    }
}
