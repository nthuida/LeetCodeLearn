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
     * 假设最小公式值m = ƒ(n)
     * 那么n的值满足下列公式 ∑(A[i] * A[i]) = n
     * 令 k 为满足最小值 m 的时候，最大的平方数  。 令  d + k * k = n ;  d >= 0;
     * 得出 f(d) + f(k*k) = f(n);
     * 显然 f(k*k) = 1; 则  f(d) + 1 = f(n); 因为 d = n - k*k;
     * 则可以推出ƒ(n - k * k) + 1 = ƒ(n) ;  且 k * k <= n;
     * @param n
     * @return
     */
    public int numSquares(int n) {
        //初始化默认为0
        int[] dp = new int[n+1];
        for (int i=1; i<=n; i++) {
            //最大值
            dp[i] = i;
            for (int j=1; i-j*j >=0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j*j] +1);
            }
        }
        return dp[n];
    }
}
