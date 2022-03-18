package com.maomao.test.dp;

/**
 * 最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * @author huida
 * @date 2020/7/7
 */
public class MinPathSum {

    /**
     * 动态规划
     * dp[i][j] = min(dp[i][j-1] + grid[i][j], dp[i-1][j] + grid[i][j])
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int min = 0;
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        int val = 0;
        for (int i=0; i< col; i++) {
            val += grid[0][i];
            dp[0][i] = val;
        }
        val = 0;
        for (int i=0; i< row; i++) {
            val += grid[i][0];
            dp[i][0] = val;
        }
        for (int i =1; i<row; i++) {
            for (int j=1; j<col; j++) {
                dp[i][j] = Math.min(dp[i-1][j] + grid[i][j], dp[i][j-1] + grid[i][j]);
            }
        }
        return dp[row-1][col-1];
    }

    public static void main(String[] args) {
        int[][] a = {{1,3,1}, {1,5,1}, {4,2,1}};
        System.out.println(new MinPathSum().minPathSum(a));
    }
}
