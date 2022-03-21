package com.maomao.test.dfs;

/**
 * 统计封闭岛屿的数目
 * 有一个二维矩阵 grid ，每个位置要么是陆地（记号为 0 ）要么是水域（记号为 1 ）。
 * 我们从一块陆地出发，每次可以往上下左右 4 个方向相邻区域走，能走到的所有陆地区域，我们将其称为一座「岛屿」。
 * 如果一座岛屿 完全 由水域包围，即陆地边缘上下左右所有相邻区域都是水域，那么我们将其称为 「封闭岛屿」。
 * 请返回封闭岛屿的数目。
 *
 * 示例 1：
 * 输入：grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
 * 输出：2
 * 解释：灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。
 *
 * 示例 2：
 * 输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
 * 输出：1
 *
 * 示例 3：
 * 输入：grid = [[1,1,1,1,1,1,1],
 *              [1,0,0,0,0,0,1],
 *              [1,0,1,1,1,0,1],
 *              [1,0,1,0,1,0,1],
 *              [1,0,1,1,1,0,1],
 *              [1,0,0,0,0,0,1],
 *              [1,1,1,1,1,1,1]]
 * 输出：2
 *
 * @author: huida
 * @date: 2021/11/22
 **/
public class ClosedIsland {

    /**
     * 去除靠边的岛屿
     * @param grid
     * @return
     */
    public int closedIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        //去除边界的岛屿
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
        int count = 0;
        //剩下的岛屿
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 深度优先遍历搜索DFS主要框架
     * @param grid
     * @param r
     * @param c
     */
    void dfs(int[][] grid, int r, int c) {
        // 判断 base case
        if (!inArea(grid, r, c)) {
            return;
        }
        // 如果这个格子不是岛屿，直接返回
        if (grid[r][c] != 0) {
            return;
        }
        // 将格子标记为「已遍历过」
        grid[r][c] = 2;
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
