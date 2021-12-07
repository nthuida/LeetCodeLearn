package com.maomao.test.array;

/**
 * 下降路径最小和
 * 给你一个 n x n 的 方形 整数数组matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列
 * （即位于正下方或者沿对角线向左或者向右的第一个元素）。
 * 具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 *
 * 示例 1：
 *
 * 输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * 输出：13
 * 解释：下面是两条和最小的下降路径，用加粗+斜体标注：
 * [[2,1,3],      [[2,1,3],
 *  [6,5,4],       [6,5,4],
 *  [7,8,9]]       [7,8,9]]
 * 示例 2：
 *
 * 输入：matrix = [[-19,57],[-40,-5]]
 * 输出：-59
 * 解释：下面是一条和最小的下降路径，用加粗+斜体标注：
 * [[-19,57],
 *  [-40,-5]]
 * 示例 3：
 *
 * 输入：matrix = [[-48]]
 * 输出：-48
 *
 * @author: huida
 * @date: 2021/12/7
 **/
public class MinFallingPathSum {

    /**
     * 动态规划
     * dp[i][j]=matrix[i][j]+Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i-1][j+1])
     * @param matrix
     * @return
     */
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0];

        }
        int[][] dp = new int[n][n];
        //第一行值初始化
        for(int i=0; i<n; i++) {
            dp[0][i] = matrix[0][i];
        }

        for(int i=1; i<n; i++) {
            for(int j=0; j<n; j++) {
                if (j == 0) {
                    //第一列
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i-1][j+1]);
                } else if (j == n-1) {
                    //最后一列
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j-1], dp[i-1][j]);
                } else {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i-1][j+1]));
                }
            }
        }

        int res = Integer.MAX_VALUE;
        //比较最后一列的值
        for(int i=0; i<n; i++) {
            res = Math.min(res, dp[n-1][i]);
        }
        return res;
    }
}
