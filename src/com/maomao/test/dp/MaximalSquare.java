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
     * 用 dp(i, j)表示以 (i, j)为右下角，且只包含 1的正方形的边长最大值。
     * 则 dp(i, j) 的值由其上方、左方和左上方的三个相邻位置的 dp 值决定。
     * 具体而言，当前位置的元素值等于三个相邻位置的元素中的最小值加 1，状态转移方程如下：
     * dp(i, j) = min(dp(i−1, j), dp(i−1, j−1), dp(i, j−1))+1
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        //边界为1
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        int maxSquare = maxSide * maxSide;
        return maxSquare;
    }
}
