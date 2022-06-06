package com.maomao.test.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 腐烂的橘子
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 *
 * 示例 1：
 * 输入：[[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 *
 * 示例 2：
 * 输入：[[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 *
 * 示例 3：
 * 输入：[[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 *
 * @author huida
 * @date 2020/6/4
 */
public class OrangesRotting {

    public int orangesRotting(int[][] grid) {

        int[][] directions = new int[][]{{0,-1},{0,1},{1,0},{-1,0}};
        int row = grid.length;
        int col = grid[0].length;
        int newCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (grid[i][j] == 1) {
                    //新鲜橘子计数
                    newCount++;
                } else if (grid[i][j] ==2) {
                    //烂橘子入队列
                    queue.offer(new int[] {i,j});
                }
            }
        }

        int timeCount = 0;
        while (newCount >0 && !queue.isEmpty()) {
            //时间+1
            timeCount++;
            //每一分钟的烂橘子数
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int[] pop = queue.poll();
                int x = pop[0];
                int y = pop[1];

                // BFS 搜索四个方向
                for (int[] direction : directions) {
                    int newX = x + direction[0];
                    int newY = y + direction[1];
                    if (newX < 0 || newX >= row || newY < 0 || newY >= col ) {
                        continue;
                    }
                    if (grid[newX][newY] == 1) {
                        newCount--;
                        grid[newX][newY] = 2;
                        queue.offer(new int[] {newX, newY});
                    }
                }
            }
        }
        if (newCount >0) {
            return -1;
        } else {
            return timeCount;
        }
    }
}
