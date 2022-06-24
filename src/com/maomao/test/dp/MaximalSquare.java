package com.maomao.test.dp;

/**
 * 最大正方形
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 * 输入:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 *
 * @author Administrator
 * @date 2020/5/8
 */
public class MaximalSquare {

    /**
     * 动态规划
     * dp[i][j]表示以 (i, j)为右下角，且只包含 1的正方形的边长最大值。
     * 状态转移方程
     * dp[i][j] = min(dp[i−1][j], dp[i−1][j−1], dp[i][j−1])+1
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        //初始化0列
        for (int i=0; i<rows; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                maxSide = 1;
            }
        }
        //0行
        for (int j=0; j<columns; j++) {
            if (matrix[0][j] == '1') {
                dp[0][j] = 1;
                maxSide = 1;
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        int maxSquare = maxSide * maxSide;
        return maxSquare;
    }
}
