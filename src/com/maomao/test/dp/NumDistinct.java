package com.maomao.test.dp;

/**
 * 不同的子序列
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。
 * （例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 *
 * 示例 1：
 * 输入：s = "rabbbit", t = "rabbit"
 * 输出：3
 *
 * @author: huida
 * @date: 2022/6/28
 **/
public class NumDistinct {

    /**
     * 状态定义：dp[i][j]表示以s[i]、t[j]结尾的不同子序列的个数
     * 状态转移方程：
     * dp[i][j] = dp[i-1][j-1] + dp[i-1][j]  s[i] == t[j]
     * 相等时，分为两种情况：用s[i]这个元素区去配,个数为dp[i-1][j-1]
     *                   不用s[i]这个元素去匹配，个数为dp[i-1][j]
     * dp[i][j] = dp[i-1][j]                 s[i] != t[j]
     *
     * 整个过程只对s进行删除操作
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        //初始化第0列，t为空
        for (int i=0; i<n+1; i++) {
            dp[i][0] = 1;
        }
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    //相等时，分为两种情况：选s[i]这个元素、不选s[i]这个元素
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }
}
