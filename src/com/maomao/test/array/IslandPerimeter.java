package com.maomao.test.array;

/**
 * 岛屿的周长
 *
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。
 * 网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 *
 * 示例 :
 *
 * 输入:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *
 * 输出: 16
 *
 * 解释: 它的周长是下面图片中的 16 个黄色的边：
 *
 * @author huida
 * @date 2020/10/30
 */
public class IslandPerimeter {

    /**
     * 判断相邻是否为陆地
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int res = 0;
        int col = grid[0].length;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                int val = grid[i][j];
                if (val == 0) {
                    continue;
                }
                int left = j-1;
                int right = j+1;
                int up = i -1;
                int down = i +1;
                if (left <0) {
                    res++;
                } else if (grid[i][left] ==0) {
                    res++;
                }
                if (right == col) {
                    res++;
                } else if (grid[i][right] == 0) {
                    res++;
                }
                if (up <0) {
                    res++;
                } else if (grid[up][j] == 0) {
                    res++;
                }
                if (down == row) {
                    res++;
                } else if (grid[down][j] == 0) {
                    res++;
                }

            }
        }
        return res;
    }
}
