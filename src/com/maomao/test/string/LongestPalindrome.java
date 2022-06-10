package com.maomao.test.string;

/**
 * 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * @Author huida.mao
 * @Date 2019/11/14
 */
public class LongestPalindrome {

    /**
     * 中心扩展法
     * 回文中心的两侧互为镜像。因此，回文可以从它的中心展开，并且只有 2n - 1个这样的中心。
     * 中心从一个字符开始扩展，或者从两个字符之间开始扩展，所以总共有 n+n-1 个中心
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            //奇数中心
            String s1 = expandAroundCenter(s, i, i);
            //偶数中心
            String s2 = expandAroundCenter(s, i, i + 1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    /**
     * 判断回文
     * @param s
     * @param left
     * @param right
     * @return
     */
    private String expandAroundCenter(String s, int left, int right) {
        int start = left, end = right;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return s.substring(start+1, end);
    }

    /**
     * 定义状态：dp[i][j]表示子串i-j是否回文
     * 状态转移方程： dp[i[j]=s.charAt(i)==s.charAt(j)&&dp[i+1][j-1]
     * 初始值：dp[i][i] = true, 即单个字符是回文的
     * @param s
     * @return
     */
    public String longestPalindromeII(String s) {
        if (s.length() < 2) {
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        //初始化
        for (int i=0; i<s.length(); i++) {
            dp[i][i] = true;
        }
        int maxLen = 1;
        //起始位置
        int begin = 0;
        //对角线右上方遍历
        for (int right=1; right<s.length(); right++) {
            for (int left=0; left<right; left++) {
                //不等
                if (s.charAt(left) != s.charAt(right)) {
                    continue;
                } else {
                    if (right-left<=2) {
                        //长度小于等于3，直接返回true，例：bb, bab
                        dp[left][right] = true;
                    } else {
                        dp[left][right] = dp[left+1][right-1];
                    }
                }
                //回文串，更新最大值和开始位置
                if (dp[left][right] && right-left+1 > maxLen) {
                    maxLen = right-left+1;
                    begin = left;
                }
            }
        }

        return s.substring(begin, begin+maxLen);
    }

    /**
     * 最长回文串
     * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
     * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
     * 注意:
     * 假设字符串的长度不会超过 1010。
     *
     * 示例 1:
     * 输入:
     * "abccccdd"
     * 输出:
     * 7
     * 解释:
     * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
     *
     * @param s
     * @return
     */
    public int longestPalindrome1(String s) {
        //回文串，对称中心两侧都是偶数，
        if(s.length() == 0) {
            return 0;
        }
        int[] temp = new int[128];
        for (char cha: s.toCharArray()) {
            //统计字符出现的次数
            temp[cha]++;
        }
        int res = 0;
        for (int count : temp) {
            //先除以2取整，再乘计算总数
            res += count/2 * 2;
            if (count % 2 ==1 && res%2==0) {
                //奇数个可以作为对称中心，但只能算一次，在总长度为偶数是成立
                res++;
            }
        }
        return res;
    }

}
