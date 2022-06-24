package com.maomao.test.dp;

/**
 * 整数拆分
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 * 返回 你可以获得的最大乘积 。
 *
 * 示例 1:
 * 输入: n = 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 *
 * 示例 2:
 * 输入: n = 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 *
 * @author: huida
 * @date: 2022/6/22
 **/
public class IntegerBreak {

    /**
     * 动态规划
     * 状态定义：dp[i]表示拆分i获得的最大乘积
     * 状态转移方程：dp[i] = max((i-j)*j, j*dp[i-j]), i<=j<i
     * (i-j)*j 表示只拆成两个
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[2] = 1;
        for (int i=3; i<=n; i++) {
            for (int j=1; j<i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j*(i-j), j*dp[i-j]));
            }
        }
        return dp[n];
    }
}
