package com.maomao.test.string;

import java.util.HashSet;

/**
 *给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LongestSubstring {
    /**
     * 暴力法：遍历所有的子串，并判断子串是否有重复的字符串,复杂度o(n^3)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String subString = s.substring(i, j);
                char[] elements = subString.toCharArray();
                boolean flag = true;
                for(char e : elements){
                    if(subString.indexOf(e) != subString.lastIndexOf(e)){
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    result = Math.max(result, j-i);
                }

            }
        }
        return result;
    }

    /**
     * 滑动窗口法  复杂度o(n)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        int result = 0, i = 0 , j = 0;
        int len = s.length();
        HashSet<Character> hashSet = new HashSet<>();
        while (i < len && j < len) {
            if (!hashSet.contains(s.charAt(j))) {
                hashSet.add(s.charAt(j++));
                result = Math.max(result, j-i);
            } else {
                hashSet.remove(s.charAt(i++));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstring().lengthOfLongestSubstring("Abcde"));
        System.out.println(new LongestSubstring().lengthOfLongestSubstring1("AA"));

    }
}
