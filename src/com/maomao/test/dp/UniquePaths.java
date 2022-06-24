package com.maomao.test.dp;

/**
 * 不同路径
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
 * @author huida
 * @date 2020/7/4
 */
public class UniquePaths {

    /**
     * 定义状态：dp[i][j] 表示到达 (i, j)的路径数
     * 动态转移方程：dp[i][j] = dp[i-1][j] + dp[i][j-1]
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

    /**
     * 不同路径II
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     * 网格中的障碍物和空位置分别用 1 和 0 来表示。
     *
     * 示例 1:
     * 输入:
     * [
     *   [0,0,0],
     *   [0,1,0],
     *   [0,0,0]
     * ]
     * 输出: 2
     * 解释:
     * 3x3 网格的正中间有一个障碍物。
     * 从左上角到右下角一共有 2 条不同的路径：
     * 1. 向右 -> 向右 -> 向下 -> 向下
     * 2. 向下 -> 向下 -> 向右 -> 向右
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        //自己是障碍物，直接返回
        if (obstacleGrid[row-1][col-1] == 1) {
            return 0;
        }
        int[][] dp = new int[row][col];
        //第0行和第0列是边界，只有一种走法
        for (int i=0; i<row;i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = 1;
            } else {
                //碰到障碍物，直接返回，后面的都是路径都是0
                break;
            }
        }
        for (int j =0; j<col; j++) {
            if (obstacleGrid[0][j] == 0) {
                dp[0][j] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i<row; i++) {
            for (int j=1; j<col; j++) {
                //是障碍物，路径为0
                if (obstacleGrid[i][j-1] == 1) {
                    dp[i][j-1] = 0;
                }
                if (obstacleGrid[i-1][j] == 1) {
                    dp[i-1][j] = 0;
                }
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[row-1][col-1];
    }
}
