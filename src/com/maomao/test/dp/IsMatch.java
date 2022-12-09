package com.maomao.test.dp;

/**
 * 通配符匹配
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 *
 * 说明:
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 *
 * 示例 3:
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 *
 * 示例 4:
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 *
 * @author huida
 * @date 2020/9/7
 */
public class IsMatch {

    /**
     *  定义状态：dp[i][j]表示s的前i个字符和p的前j个字符是否匹配
     *  状态转移方程：
     *  dp[i][j] = dp[i-1][j-1]  s[i] == p[j] || p[j] == ?
     *  dp[i][j] = dp[i][j-1] || dp[i-1][j]    p[j] == *
     *     dp[i][j-1] 表示 * 代表的是空字符，例如 ab, ab*
     *     dp[i-1][j] 表示 * 代表的是非空字符，例如 abcd, ab*
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
            //s为空，p只有为*时，才有可能为true
            if (p.charAt(i-1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(j-1) == '*') {
                    //*匹配0个或若干个
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }
            }
        }

        return dp[m][n];
    }

    /**
     * 正则表达式匹配
     * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
     *
     * 示例 2:
     * 输入：s = "aa", p = "a*"
     * 输出：true
     * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。
     * 因此，字符串 "aa" 可被视为 'a' 重复了一次。
     *
     * 示例 3：
     * 输入：s = "ab", p = ".*"
     * 输出：true
     * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
     */

    /**
     * 定义状态：dp[i][j]表示s的前i个字符和p的前j个字符是否匹配
     * 状态转移方程:
     * dp[i][j] = dp[i-1][j-1]  p[j] == s[i] || p[j] = '.'
     * dp[i][j] = dp[i][j-2]    p[j-1] != s[i]， in this case, a* only counts as empty
     * dp[i][j] = dp[i-1][j] || dp[i][j-1] || dp[i][j-2]  p[j-1] == s[i] or p[j-1] == '.'
     *
     * dp[i-1][j],in this case, a* counts as multiple a
     * dp[i][j-1],in this case, a* counts as single a
     * dp[i][j-2],in this case, a* counts as empty
     *
     * '*' 匹配零个等于删除，区别与通配符匹配
     *
     * @param s
     * @param p
     * @return
     */
    public boolean match(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];

        //初始化,都为空，可以匹配
        dp[0][0] = true;
        for (int i=1; i<=n; i++) {
            //s为空，p只有为*时，才有可能为true
            if (p.charAt(i-1) == '*') {
                dp[0][i] = dp[0][i-2];
            }
        }
        for (int i=1; i<=s.length(); i++) {
            for (int j=1; j<=p.length(); j++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.' ) {
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(j-1) == '*') {
                    if (p.charAt(j-2) == s.charAt(i-1) || p.charAt(j-2) == '.'){
                        //*匹配多个，一个或者0个
                        dp[i][j] = dp[i-1][j] || dp[i][j-1] || dp[i][j-2];
                    } else {
                        //*只能匹配0个，等于删除,
                        dp[i][j] = dp[i][j-2];
                    }
                }
            }
        }
        return dp[m][n];
    }
}
