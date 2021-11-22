package com.maomao.test.array;

/**
 * 飞地的数量
 * 给出一个二维数组 A，每个单元格为 0（代表海）或 1（代表陆地）。
 * 移动是指在陆地上从一个地方走到另一个地方（朝四个方向之一）或离开网格的边界。
 * 返回网格中无法在任意次数的移动中离开网格边界的陆地单元格的数量。
 *
 * 示例 1：
 * 输入：[[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * 输出：3
 * 解释：
 * 有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
 *
 * 示例 2：
 * 输入：[[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
 * 输出：0
 * 解释：
 * 所有 1 都在边界上或可以到达边界。
 *
 * @author: huida
 * @date: 2021/11/22
 **/
public class NumEnclaves {

    int count = 0;
    public int numEnclaves(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        for (int i=0; i<row; i++) {
            //最左边
            dfs(grid, i, 0);
            //最右边
            dfs(grid, i, col-1);
        }
        for (int j=0; j<col; j++) {
            //最上边
            dfs(grid, 0, j);
            //最下边
            dfs(grid, row-1, j);
        }
        //剩下的岛屿
        count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1){
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    void dfs(int[][] grid, int r, int c) {
        // 判断 base case
        if (!inArea(grid, r, c)) {
            return;
        }
        // 如果这个格子不是岛屿，直接返回
        if (grid[r][c] != 1) {
            return;
        }
        // 将格子标记为「已遍历过」
        grid[r][c] = 2;
        count++;
        // 访问上、下、左、右四个相邻结点
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    /**
     * 判断坐标 (r, c) 是否在网格中
     * @param grid
     * @param r
     * @param c
     * @return
     */
    boolean inArea(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
    }
}
