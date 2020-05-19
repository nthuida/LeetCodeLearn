package com.maomao.test.array;

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
     * Tree的BFS:首先把 root 节点入队，再一层一层无脑遍历就行了
     * Tree 只有 1 个 root，而图可以有多个源点，所以首先需要把多个源点都入队；
     * Tree 是有向的因此不需要标识是否访问过，而对于无向图来说，必须得标志是否访问过哦！并且为了防止某个节点多次入队，
     * 需要在其入队之前就将其设置成已访问！
     *
     * 思路
     * 首先把每个源点 0入队，然后从各个 0 同时开始一圈一圈的向 1 扩散（每个 1 都是被离它最近的 0 扩散到的 ），
     * 扩散的时候可以设置 int[][] dist 来记录距离（即扩散的层次）并同时标志是否访问过。
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
