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
     * 中心扩展算法
     *
     * 我们观察到回文中心的两侧互为镜像。因此，回文可以从它的中心展开，并且只有 2n - 1个这样的中心。
     * 由于存在奇数的字符串和偶数的字符串，所以我们需要从一个字符开始扩展，或者从两个字符之间开始扩展，所以总共有 n+n-1 个中心
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            //奇数中心
            int len1 = expandAroundCenter(s, i, i);
            //偶数
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                //开始的位置
                start = i - (len - 1) / 2;
                //结束位置
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     * 计算回文的长度
     * @param s
     * @param left
     * @param right
     * @return
     */
    private int expandAroundCenter(String s, int left, int right) {
        int start = left, end = right;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return end - start - 1;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome(""));
    }
}
