package com.maomao.test.dp;

/**
 * 最长回文子序列
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 *
 * 示例 1：
 * 输入：s = "bbbab"
 * 输出：4
 * 解释：一个可能的最长回文子序列为 "bbbb" 。
 *
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出：2
 * 解释：一个可能的最长回文子序列为 "bb" 。
 *
 * @author: huida
 * @date: 2021/12/16
 **/
public class LongestPalindromeSubseq {

    /**
     * 动态规划
     * 状态定义：dp[i][j] 表示 s 的第 i 个字符到第 j 个字符组成的子串中，最长回文序列的长度
     * 转移方程：
     * dp[i][j] = dp[i + 1][j - 1] + 2             s[i] == s[j]
     * dp[i][j] = max(dp[i + 1][j], dp[i][j - 1])  s[i] != s[j]
     *
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
        //从下往上，从左往右遍历, 对角线遍历
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
