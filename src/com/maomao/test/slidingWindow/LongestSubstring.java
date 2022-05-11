package com.maomao.test.slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
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
     * 滑动窗口法
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int result = 0, left = 0 , right = 0;
        int len = s.length();
        //set作为窗口保存元素
        HashSet<Character> hashSet = new HashSet<>();
        while (right < len) {
            if (!hashSet.contains(s.charAt(right))) {
                //窗口中不包含，右边界向右移动
                hashSet.add(s.charAt(right));
                right++;
                result = Math.max(result, right-left);
            } else {
                //包含，左边界向右移动
                hashSet.remove(s.charAt(left));
                left++;
            }
        }
        return result;
    }

    public int lengthOfLongestSubstring2(String s) {
        int result = 0;
        int left = 0, right = 0;
        //滑动窗口字符出现次数
        int[] window = new int[128];
        while (right < s.length()) {
            char r = s.charAt(right);
            window[r]++;
            right++;
            //判断左侧是否要收缩, window[r] >1说明有重复字符
            while (window[r] >1) {
                char l = s.charAt(left);
                window[l]--;
                left++;
            }
            //更新结果
            result = Math.max(result, right-left);
        }
        return result;
    }

}
