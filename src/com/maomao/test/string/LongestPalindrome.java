package com.maomao.test.string;

/**
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
     * 方法四：中心扩展算法

     * 我们观察到回文中心的两侧互为镜像。因此，回文可以从它的中心展开，并且只有 2n - 1个这样的中心。
     *
     * 你可能会问，为什么会是 2n - 1个，而不是 n个中心？原因在于所含字母数为偶数的回文的中心可以处于两字母之间（例如 {“abba”}“abba” 的中心在两个 {‘b’}‘b’ 之间）。
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if(s == null) {
            return "";
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
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("cbbd"));
    }
}
