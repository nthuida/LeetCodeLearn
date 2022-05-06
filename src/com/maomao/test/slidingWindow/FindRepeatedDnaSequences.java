package com.maomao.test.slidingWindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 重复的DNA序列
 * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。
 * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 *
 * 示例 1：
 *
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 *
 * 示例 2：
 *
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 *
 * @author: huida
 * @date: 2020/12/22
 **/
public class FindRepeatedDnaSequences {

    /**
     * 滑动窗口
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> res = new HashSet<>();
        int len = s.length();
        for (int i=0; i<=len-10; i++) {
           String temp = s.substring(i, i+10);
           if (set.contains(temp)) {
               res.add(temp);
           } else {
               set.add(temp);
           }
        }
        return new ArrayList<>(res);

    }

}
