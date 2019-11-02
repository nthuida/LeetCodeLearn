package com.maomao.test.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 找不同
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 * 示例:
 *
 * 输入：
 * s = "abcd"
 * t = "abcde"
 *
 * 输出：
 * e
 * @Author huida.mao
 * @Date 2019/11/2
 */
public class FindTheDifference {

    /**
     * 对t中的字符map计数,遍历s去减掉出现的次数
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character character : t.toCharArray()) {
            if (map.containsKey(character)) {
                map.put(character, map.get(character) +1);
            } else {
                map.put(character, 1);
            }
        }
        for (Character character : s.toCharArray()) {
            if (map.containsKey(character)) {
                map.put(character, map.get(character) -1);
            }
        }
        for (Character character : map.keySet()) {
            if (map.get(character) == 1) {
                return character;
            }
        }
        return ' ';
    }

}
