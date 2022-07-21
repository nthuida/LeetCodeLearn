package com.maomao.test.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 串联所有单词的子串
 *
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 * 示例 1：
 * 输入：
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 *
 * 示例 2：
 * 输入：
 * s = "wordgoodgoodgoodbestword",
 * words = ["word","good","best","word"]
 * 输出：[]
 *
 * @author: huida
 * @date: 2021/1/6
 **/
public class FindSubstring {

    /**
     * 判断每个子串是否符合条件
     * 判断子串中单词出现的个数
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        if (s.length() == 0 || words.length == 0) {
            return new ArrayList<>();
        }
        //子串的长度
        int subLen = words.length * words[0].length();
        int wordLen = words[0].length();
        //统计数组中单词出现的次数
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : words) {
            wordsMap.put(word, wordsMap.getOrDefault(word,0) +1);
        }
        List<Integer> res = new ArrayList<>();
        //遍历所有子串
        for (int i=0; i<s.length() - subLen + 1; i++) {
            //截取子串
            String subTemp = s.substring(i, i+subLen);
            Map<String,Integer> mapTemp = new HashMap<>();
            //统计截取子串中单词出现的次数
            for (int j=0; j<subLen; j+=wordLen) {
                String string = subTemp.substring(j, j+wordLen);
                mapTemp.put(string, mapTemp.getOrDefault(string, 0) +1);
            }
            //两个map比较
            if (mapTemp.equals(wordsMap)) {
                res.add(i);
            }

        }
        return res;
    }
}
