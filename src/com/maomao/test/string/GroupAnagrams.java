package com.maomao.test.string;

import java.util.*;

/**
 * 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * @author huida
 * @date 2020/6/23
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i=0; i<strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            //排序
            Arrays.sort(chars);
            //转为字符串
            String str = String.valueOf(chars);
            if (map.containsKey(str)) {
                map.get(str).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(str, list);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = new GroupAnagrams().groupAnagrams(s);
        System.out.println(lists);
    }
}
