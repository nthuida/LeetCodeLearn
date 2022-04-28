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
     * 暴力
     * @param s
     * @return
     */
    public int countSubstringsII(String s) {
        int count = 0;
        int len = s.length();
        for (int i=0; i<len; i++) {
            for (int end=i; end<len; end++) {
                String str = s.substring(i,end+1);
                String reverse = new StringBuilder(str).reverse().toString();
                if (str.equals(reverse)) {
                    count++;
                }
            }
        }
        return count;
    }
}
