package com.maomao.test.array;

/**
 * 三维形体的表面积
 * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 * 请你返回最终形体的表面积。
 *
 * 示例 1：
 * 输入：[[2]]
 * 输出：10
 *
 * 示例 2：
 * 输入：[[1,2],[3,4]]
 * 输出：34
 *
 * 示例 3：
 * 输入：[[1,0],[0,2]]
 * 输出：16
 *
 * 示例 4：
 * 输入：[[1,1,1],[1,0,1],[1,1,1]]
 * 输出：32
 *
 * @author huida
 * @date 2020/6/2
 */
public class SurfaceArea {

    /**
     * 一个柱体一个柱体的看，每个柱体是由：2 个底面（上表面/下表面）+ 所有的正方体都贡献了 4 个侧表面积。
     * 然后，把柱体贴合在一起之后，我们需要把贴合的表面积给减掉，两个柱体贴合的表面积就是 两个柱体高的最小值*2。
     *
     * @param grid
     * @return
     */
    public int surfaceArea(int[][] grid) {
        int ans = 0;
        int len = grid.length;
        for (int i=0; i<len; i++) {
            for (int j=0; j<len; j++) {
                if (grid[i][j] >0) {
                    ans += (grid[i][j] * 4 + 2);
                    //上面的面
                    if (i>0) {
                        int up = Math.min(grid[i][j], grid[i-1][j]);
                        ans -= up*2;
                    }
                    if (j>0) {
                        //左边的面
                        int left = Math.min(grid[i][j],grid[i][j-1]);
                        ans -= left*2;
                    }

                }
            }
        }

        return ans;
    }
}
