package com.maomao.test.string;

/**
 * 通配符匹配
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 *
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * 示例 3:
 *
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * 示例 4:
 *
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * 示例 5:
 *
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输出: false
 *
 * @author huida
 * @date 2020/9/7
 */
public class IsMatch {

    /**
     *  状态 dp[i][j] : 表示 s 的前 i 个字符和 p 的前 j 个字符是否匹配 (true 的话表示匹配)
     *  状态转移方程：
     *  1. 当 s[i] == p[j]，或者 p[j] == ? 那么 dp[i][j] = dp[i - 1][j - 1];
     *  2. 当 p[j] == * 那么 dp[i][j] = dp[i][j - 1] || dp[i - 1][j]    其中：
     *     dp[i][j - 1] 表示 * 代表的是空字符，例如 ab, ab*
     *     dp[i - 1][j] 表示 * 代表的是非空字符，例如 abcd, ab*
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];

        //初始化,都为空，可以匹配
        dp[0][0] = true;
        for (int i=1; i<=n; i++) {
            //s为空，p只有为*时，才为true； s不为空，p为空时，都为false,即第一列都为false，
            dp[0][i] = dp[0][i-1] && p.charAt(i-1) == '*';
        }
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "adceb";
        String p = "*a*b";
        System.out.println(new IsMatch().isMatch(s,p));
    }
}
