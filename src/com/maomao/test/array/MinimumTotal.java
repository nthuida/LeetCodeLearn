package com.maomao.test.array;

import java.util.List;

/**
 * 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）
 *
 * @author huida
 * @date 2020/9/27
 */
public class MinimumTotal {

    /**
     * 动态转移方程
     * dp[i][j]=min(dp[i-1][j],dp[i-1][j-1])+triangle[i][j]
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int row = triangle.size();
        int col = triangle.get(row-1).size();
        int[][] dp = new int[row][col];
        dp[0][0] = triangle.get(0).get(0);

        for (int i=1; i<row; i++) {
            for (int j=0; j<=i; j++) {
                if (j==0) {
                    //左边界
                    dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                } else if (j == i) {
                    //右边界
                    dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) +  triangle.get(i).get(j);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i=0; i<col; i++) {
            min = Math.min(min, dp[row-1][i]);
        }

        return min;

    }
}
