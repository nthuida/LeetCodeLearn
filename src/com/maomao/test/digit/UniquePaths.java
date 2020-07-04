package com.maomao.test.digit;

/**
 * 不同的路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 *
 * 示例 1:
 *
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 *
 * 示例 2:
 *
 * 输入: m = 7, n = 3
 * 输出: 28
 *
 *
 * @author huida
 * @date 2020/7/4
 */
public class UniquePaths {

    /**
     *  dp[i][j] 是到达 i, j 最多路径
     * 动态方程：dp[i][j] = dp[i-1][j] + dp[i][j-1]
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //第0行和第0列是边界，只有一种走法
        for (int i=0; i<m;i++) {
            dp[i][0] = 1;
        }
        for (int j =0; j<n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i<m; i++) {
            for (int j=1; j<n; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }
}
