package com.maomao.test.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

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

    public int lengthOfLongestSubstring2(String s) {
        int result = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                //左边界右移
                left = Math.max(left, map.get(s.charAt(i) + 1));
            }
            //更新当前字符位置
            map.put(s.charAt(i), i);
            result = Math.max(result, i-left+1);
        }
        return result;
    }

    /**
     * 至少有K个重复字符的最长子串
     * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求T中的每一字符出现次数都不少于 k 。输出 T的长度。
     *
     * 示例 1:
     * 输入:
     * s = "aaabb", k = 3
     * 输出:
     * 3
     * 最长子串为 "aaa" ，其中 'a' 重复了 3 次。
     *
     * 示例 2:
     * 输入:
     * s = "ababbc", k = 2
     * 输出:
     * 5
     * 最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
     *
     * @param s
     * @param k
     * @return
     */
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0 || s.length() < k) {
            return 0;
        }
        //统计字符出现的次数
        Map<Character, Integer> map = new HashMap<>();
        for (int i =0; i<s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        //确定不符合条件的字符的位置
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            if (map.get(s.charAt(i)) < k) {
                stringBuilder.append(',');
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }
        //以不符合条件的字符进行分割
        String[] strs = stringBuilder.toString().split(",");
        //只有一组，直接返回
        if (strs.length ==1) {
            return strs[0].length();
        }
        int max = 0;
        //多组， 递归比较获取最大
        for (String str: strs) {
            max = Math.max(max, longestSubstring(str, k));
        }

        return max;

    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstring().lengthOfLongestSubstring("Abcde"));
        System.out.println(new LongestSubstring().lengthOfLongestSubstring1("AA"));
        System.out.println(new LongestSubstring().longestSubstring("ababbc", 2));
    }
}
