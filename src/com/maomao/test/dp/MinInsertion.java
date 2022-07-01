package com.maomao.test.dp;

/**
 * 让字符串成为回文串的最少插入次数
 * 给你一个字符串 s ，每一次操作你都可以在字符串的任意位置插入任意字符。
 *
 * 请你返回让 s 成为回文串的 最少操作次数 。
 *
 * 「回文串」是正读和反读都相同的字符串。
 *
 * 示例 1：
 *
 * 输入：s = "zzazz"
 * 输出：0
 * 解释：字符串 "zzazz" 已经是回文串了，所以不需要做任何插入操作。
 * 示例 2：
 *
 * 输入：s = "mbadm"
 * 输出：2
 * 解释：字符串可变为 "mbdadbm" 或者 "mdbabdm" 。
 *
 * @author: huida
 * @date: 2021/12/11
 **/
public class MinInsertion {

    /**
     * 状态定义：dp[i][j] 表示子串s[i:j]变为回文串的最小插入次数
     * 状态转移方程：
     * dp[i][j] = dp[i+1][j-1]                    s[i] == s[j]
     * dp[i][j] = min(dp[i+1][j], dp[i][j-1]) +1  s[i] != s[j]
     * @param s
     * @return
     */
    public int minInsertions(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        //从下往上，从左往右，对角线遍历
        for (int i=len-2; i>=0; i--) {
            for (int j=i+1; j<len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1]) +1;
                }
            }
        }
        return dp[0][len-1];
    }
}
