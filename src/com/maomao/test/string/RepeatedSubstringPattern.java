package com.maomao.test.string;

/**
 * 重复的字符子串
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 * 示例 1:
 *
 * 输入: s = "abab"
 * 输出: true
 * 解释: 可由子串 "ab" 重复两次构成。
 * 示例 2:
 *
 * 输入: s = "aba"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "abcabcabcabc"
 * 输出: true
 * 解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
 * @auther: huida
 * @date: 2024/4/27
 */
public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        //子串长度的最大值
        int subLen = s.length()/2;
        for (int i=1; i<=subLen; i++) {
            if (s.length()%i != 0) {
                //子串的个数需要为整数
                continue;
            }
            boolean flag = true;
            for (int j=i; j<s.length(); j++) {
                if (s.charAt(j) != s.charAt(j-i)) {
                    //对应位置的字符要相等
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }

    /**
     * 字符串 S 包含一个重复的子字符串，那么这意味着可以多次 “移位和换行”`字符串，并使其与原始字符串匹配
     * @param s
     * @return
     */
    public boolean repeatedSubstringPatternII(String s) {
        String str = s+s;
        return str.substring(1,s.length()-1).contains(s);
    }

}
