package com.maomao.test.dp;

/**
 * 编辑距离
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数。
 *
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *  
 *
 * 示例 1：
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 *
 * 示例 2：
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 *
 * @author huida
 * @date 2020/5/13
 */
public class MinDistance {

    /**
     * 定义状态：dp[i][j]表示以word1[i],word2[j]结尾转换所使用的最小操作数
     * 状态转移方程：
     * dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1])+1  word1[i] != word2[j]
     * dp[i-1][j-1]表示替换，dp[i-1][j]表示删除，dp[i][j-1]表示添加
     * dp[i][j] = dp[i-1][j-1]  word1[i] == word2[j]
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if (n==0 || m==0) {
            return n + m;
        }
        int[][] dp = new int[n + 1][m + 1];

        // 边界状态初始化，代表其中一个元素为空
        for (int i = 0; i < n + 1; i++) {
            //行
            dp[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            //列
            dp[0][j] = j;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int min = Math.min(dp[i-1][j] + 1, dp[i][j-1] +1);
                    dp[i][j] = Math.min(min, dp[i-1][j-1] + 1);
                }
            }
        }
        return dp[n][m];
    }

    /**
     * 两个字符串的删除操作
     * 给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
     * 每步 可以删除任意一个字符串中的一个字符。
     * 示例 1：
     * 输入: word1 = "sea", word2 = "eat"
     * 输出: 2
     * 解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
     *
     * 状态定义：dp[i][j]表示以word1[i],word2[j]结尾的字符相同所需的最小步数
     * 状态转移方程：dp[i][j] = dp[i-1][j-1]                     word1[i] == word2[j]
     *             dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + 1  word1[i] != word2[j]
     * @param word1
     * @param word2
     * @return
     */
    public int minDistanceII(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];

        for (int i=0; i<=n; i++) {
            dp[i][0] = i;
        }
        for (int j=0; j<=m; j++) {
            dp[0][j] = j;
        }

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
                }
            }
        }
        return dp[n][m];
    }
}
