package com.maomao.test.dp;

/**
 * 交错字符串
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 *
 * 示例 1：
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出：true
 *
 * 示例 2：
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出：false
 *
 * @author: huida
 * @date: 2022/7/5
 **/
public class IsInterleave {

    /**
     * 状态定义：dp[i][j]表示s1的前i个字符和s2的前j个字符是否可以构成s3的前i+j个字符
     * 状态转移方程：
     * dp[i][j] = dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)
     *            || dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1)
     * s1的前i-1个字符和s2的前j个字符构成s3的前i+j-1个字符，且s1[i] == s3[i+j]
     * 或者 s1的前i个字符和s2的前j-1个字符构成s3的前i+j-1个字符，且s2[j] == s3[i+j]
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3) {
            return false;
        }
        boolean[][] dp = new boolean[len1+1][len2+1];
        dp[0][0] = true;
        //初始化0列
        for (int i=1; i<=len1; i++) {
            dp[i][0] = dp[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
        }
        for (int j=1; j<=len2; j++) {
            dp[0][j] = dp[0][j-1] && s2.charAt(j-1) == s3.charAt(j-1);
        }

        for (int i=1; i<=len1; i++) {
            for (int j=1; j<=len2; j++) {
                dp[i][j] = dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)
                        || dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1);
            }
        }
        return dp[len1][len2];

    }
}
