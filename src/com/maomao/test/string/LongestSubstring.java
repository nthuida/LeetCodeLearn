package com.maomao.test.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

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
 */
public class LongestSubstring {


    public int longestSubstring(String s, int k) {
        if (s.length() == 0 || s.length() < k) {
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

}
