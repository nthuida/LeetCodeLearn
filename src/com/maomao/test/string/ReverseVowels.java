package com.maomao.test.string;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 * 示例 1:
 *
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 *
 * 输入: "leetcode"
 * 输出: "leotcede"
 *
 * @Author huida.mao
 * @Date 2020/1/13
 */
public class ReverseVowels {

    public String reverseVowels(String s) {
        HashSet<Character> set = new HashSet<>(Arrays.asList('a','o','e','i','u','A','O','E','I','U'));
        int len = s.length();
        StringBuilder stringBuilder = new StringBuilder(s);
        int start = 0;
        int end = len-1;
        while (start < end) {
            if (set.contains(stringBuilder.charAt(start)) && set.contains(stringBuilder.charAt(end))) {
                char temp = stringBuilder.charAt(end);
                stringBuilder.setCharAt(end, stringBuilder.charAt(start));
                stringBuilder.setCharAt(start, temp);
                start++;
                end--;
            } else if (set.contains(stringBuilder.charAt(start)) && !set.contains(stringBuilder.charAt(end))) {
                end--;
            } else if (!set.contains(stringBuilder.charAt(start)) && set.contains(stringBuilder.charAt(end))) {
                start++;
            } else {
                start++;
                end--;
            }
        }
        return stringBuilder.toString();
    }
}
