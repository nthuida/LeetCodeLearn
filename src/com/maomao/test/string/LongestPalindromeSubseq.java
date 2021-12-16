package com.maomao.test.string;

/**
 * @author: huida
 * @date: 2021/12/16
 **/
public class LongestPalindromeSubseq {

    /**
     * 动态规划
     * dp[i][j] 表示 s 的第 i 个字符到第 j 个字符组成的子串中，最长的回文序列长度是多少。
     * 转移方程
     * 如果 s 的第 i 个字符和第 j 个字符相同的话
     * dp[i][j] = dp[i + 1][j - 1] + 2
     * 如果 s 的第 i 个字符和第 j 个字符不同的话
     * dp[i][j] = max(dp[i + 1][j], dp[i][j - 1])
     *
     * 为了保证每次计算dp[i][j]，左、下、左下三个方向的位置已经被计算出来，只能斜着遍历或者反着遍历：
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        //字符串长度为1，回文长度为1
        for (int k=0; k<n; k++) {
            dp[k][k] = 1;
        }
        //从下往上，从左往右遍历
        for (int i=n-1; i>=0; i--) {
            for (int j=i+1; j<n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }
        return dp[0][n-1];
    }
}
