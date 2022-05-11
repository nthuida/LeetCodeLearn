package com.maomao.test.slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找到字符串中所有字母异位词
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * 说明：
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 *
 * 示例 1:
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * 输出:
 * [0, 6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *
 * 示例 2:
 * 输入:
 * s: "abab" p: "ab"
 * 输出:
 * [0, 1, 2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 *
 * @author huida
 * @date 2020/9/4
 */
public class FindAnagrams {

    /**
     * 滑动窗口
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() ==0 || p.length()==0 || p.length() > s.length()) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        //目标字符串的字符个数
        int[] need = new int[128];
        //窗口中字符的个数
        int[] window = new int[128];
        for (char ch : p.toCharArray()) {
            need[ch]++;
        }
        int left = 0;
        int right = 0;
        int count = 0;
        while (right < s.length()) {
           char rightChar = s.charAt(right);
           //统计窗口中字符的个数
           window[rightChar]++;
            //向右滑动
           right++;
           //窗口内数据更新
           if (need[rightChar] >0 && need[rightChar] >= window[rightChar]) {
               count++;
           }
           //左窗口是否要收缩
           while ((right-left) == p.length()) {
               //满足条件,更新结果
               if (count == p.length()) {
                   res.add(left);
               }
                char leftChar = s.charAt(left);
                window[leftChar]--;
                left++;
                if (need[leftChar] >0 && need[leftChar] > window[leftChar]) {
                    count--;
                }
           }
        }
        return res;
    }

}
