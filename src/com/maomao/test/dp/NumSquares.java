package com.maomao.test.dp;

/**
 * 完全平方数
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
 * 你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 *
 * 示例 2:
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 *
 * @author huida
 * @date 2020/8/28
 */
public class NumSquares {

    /**
     * 动态规划
     * dp[i] 表示当前i需要的最少平方数个数
     * 动态转移方程为：dp[i] = MIN(dp[i], dp[i - j * j] + 1)，i 表示当前数字，j*j 表示平方数
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i=1; i<=n; i++) {
            //最坏情况，都是1相加，最大值
            dp[i] = i;
            for (int j=1; i-j*j >=0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j*j] +1);
            }
        }
        return dp[n];
    }
}
