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
     * 动态规划
     * 最后一个字母不同：dp[i][j] = min(dp[i-1][j-1]+1, dp[i-1][j ]+1, dp[i][j-1]+1)
     * 最后一个字母相同：dp[i][j] = min(dp[i-1][j-1], dp[i-1][j ]+1, dp[i][j-1]+1)
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // 有一个字符串为空串
        if (n==0 || m==0) {
            return n + m;
        }
        // DP 数组，有空字符串需要占一行一列
        int [][] D = new int[n + 1][m + 1];

        // 边界状态初始化
        for (int i = 0; i < n + 1; i++) {
            //行
            D[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            //列
            D[0][j] = j;
        }

        // 计算所有 DP 值
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int left = D[i][j-1] + 1;
                int up = D[i-1][j] + 1;
                int left_up = D[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    left_up += 1;
                }
                D[i][j] = Math.min(left, Math.min(up, left_up));
            }
        }
        return D[n][m];
    }

    public static void main(String[] args) {
        String a = "intention";
        String b = "execution";
        System.out.println(new MinDistance().minDistance(a,b));
    }
}
