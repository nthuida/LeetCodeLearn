package com.maomao.test.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 地图分析
 * 你现在手里有一份大小为 N x N 的「地图」（网格） grid，上面的每个「区域」（单元格）都用 0 和 1 标记好了。
 * 其中 0 代表海洋，1 代表陆地，请你找出一个海洋区域，这个海洋区域到离它最近的陆地区域的距离是最大的。
 * 我们这里说的距离是「曼哈顿距离」：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
 * 如果我们的地图上只有陆地或者海洋，请返回 -1。
 *
 * 示例 1：
 * 1 0 1
 * 0 0 0
 * 1 0 1
 *
 * 输入：[[1,0,1],[0,0,0],[1,0,1]]
 * 输出：2
 * 解释：海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。
 *
 * 示例 2：
 * 1 0 0
 * 0 0 0
 * 0 0 0
 *
 * 输入：[[1,0,0],[0,0,0],[0,0,0]]
 * 输出：4
 * 解释：海洋区域 (2, 2) 和所有陆地区域之间的距离都达到最大，最大距离为 4。
 *
 * @author huida
 * @date 2020/5/19
 */
public class MaxDistance {

    public int maxDistance(int[][] grid) {
        int max = -1;
        int[][] directions = new int[][]{{0,-1},{0,1},{1,0},{-1,0}};
        Queue<int[]> queue = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;

        // 标记当前位置是否都看过
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    //1入队列
                    queue.offer(new int[] {i, j});
                    grid[i][j] = 0;
                    visited[i][j] = true;
                }
            }
        }
        //都为海洋或者陆地
        if (queue.size() == 0 || queue.size() == row*col) {
            return -1;
        }
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            int x = top[0];
            int y = top[1];
            // BFS 搜索四个方向
            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (newX < 0 || newX >= row || newY < 0 || newY >= col || visited[newX][newY]) {
                    continue;
                }
                // 距离更新
                grid[newX][newY] = grid[x][y] + 1;
                //最大值
                if (grid[newX][newY] > max) {
                    max = grid[newX][newY];
                }
                visited[newX][newY] = true;
                // 新元素入队
                queue.add(new int[]{newX, newY});
            }
        }
        return max;
    }

}
