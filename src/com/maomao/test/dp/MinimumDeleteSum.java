package com.maomao.test.dp;

/**
 * 两个字符串的最小ASCII删除和
 * 给定两个字符串s1, s2，找到使两个字符串相等所需删除字符的ASCII值的最小和。
 *
 * 示例 1:
 * 输入: s1 = "sea", s2 = "eat"
 * 输出: 231
 * 解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
 * 在 "eat" 中删除 "t" 并将 116 加入总和。
 * 结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
 *
 * 示例 2:
 * 输入: s1 = "delete", s2 = "leet"
 * 输出: 403
 * 解释: 在 "delete" 中删除 "dee" 字符串变成 "let"，
 * 将 100[d]+101[e]+101[e] 加入总和。在 "leet" 中删除 "e" 将 101[e] 加入总和。
 * 结束时，两个字符串都等于 "let"，结果即为 100+101+101+101 = 403 。
 * 如果改为将两个字符串转换为 "lee" 或 "eet"，我们会得到 433 或 417 的结果，比答案更大。
 *
 * @author: huida
 * @date: 2021/12/16
 **/
public class MinimumDeleteSum {

    /**
     * 转化为 找出两个字符串的最大公共子序列，并且使其ASCII编码最大
     * 状态定义：dp[i][j]表示以s1的i和s2的j结尾的ASCII和最大的最长公共子序列
     * 状态转移方程：
     * dp[i][j] = dp[i-1][j-1] + s1.charAt(i-1) s1[i]==s2[j]
     * dp[i][j] = max(dp[i-1][j], dp[i][j-1])   s1[i]!=s2[j]
     * @param s1
     * @param s2
     * @return
     */
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        //总ASCII和
        int sum = 0;
        for (int i=0; i<n; i++) {
            sum += s1.charAt(i);
        }
        for (int j=0; j<m; j++) {
            sum += s2.charAt(j);
        }
        //ASCII和最大的最长公共子序列
        int[][] dp = new int[n+1][m+1];
        for (int i =1; i<=n ;i++) {
            for (int j=1; j<=m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    //相等，计算和
                    dp[i][j] = dp[i-1][j-1] + s1.charAt(i-1);
                } else {
                    //不想等
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return sum - dp[n][m]*2;
    }

}
