package com.maomao.test.string;

/**
 * 回文子串
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 *
 * 示例 1:
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 *
 * 示例 2:
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 *
 * @author huida
 * @date 2020/5/21
 */
public class CountSubstrings {

    /**
     *  中心扩展法
     *  枚举2n-1个中心，统计回文数
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        int count = 0;
        for (int i=0; i < s.length(); i++) {
            //奇数中心
            count += countPalindrome(s, i,i);
            //偶数中心
            count += countPalindrome(s,i,i+1);
        }
        return count;
    }

    private int countPalindrome(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }


    /**
     * 动态规划
     * 定义状态：dp[i][j]表示子串[i,j]是否是回文子串
     * 状态转移方程：
     * dp[i][j] = true s[i]==s[j] && j-i<=1 单个或两个字符的回文子串
     * dp[i][j] = true s[i]==s[j] && dp[i+1][j-1] 三个字符以上的回文子串
     * @param s
     * @return
     */
    public int countSubstringsIII(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int res = 0;
        //对角线初始化
        for (int i=0; i<n; i++) {
            dp[i][i] = true;
        }
        //从下往上，从左往右,对角线遍历
        for (int i=n-1; i>=0; i--) {
            for (int j=i; j<n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j-i <= 1) {
                        //两个或一个字符的回文子串
                        dp[i][j] = true;
                        res++;
                    } else {
                        if (dp[i+1][j-1]) {
                            dp[i][j] = true;
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }
}
