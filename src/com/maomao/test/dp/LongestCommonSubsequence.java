package com.maomao.test.dp;

/**
 * 最长公共子序列
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 * 示例 1：
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 *
 * 示例 2：
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
 *
 * 示例 3：
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0 。
 *
 * @author: huida
 * @date: 2021/12/16
 **/
public class LongestCommonSubsequence {

    /**
     * dp[i][j] 表示 text1[0:i], text2[0:j] 的最长公共子序列的长度。i表示text1的前缀长度i
     * 当i或j为0时，dp[i][j] = 0, 因为空字符串和任何字符串的最长公共子序列的长度都是 0
     *
     * 状态转移方程
     * dp[i][j] =  dp[i−1][j−1]+1,  text1[i-1] = text2[j-1]
     *             max(dp[i−1][j],dp[i][j−1]), text1[i-1] != text2[j-1]
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                //第一个字符开始
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    // text1[i-1] 和 text2[j-1] 必然在 lcs 中
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    // text1[i-1] 和 text2[j-1] 至少有一个不在 lcs 中
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}
