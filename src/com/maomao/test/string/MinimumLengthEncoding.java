package com.maomao.test.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 单词的压缩编码
 * 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
 * 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
 * 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。
 * 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
 *
 * 示例：
 * 输入: words = ["time", "me", "bell"]
 * 输出: 10
 * 说明: S = "time#bell#" ， indexes = [0, 2, 5] 。
 *
 * @author huida
 * @date 2020/6/2
 */
public class MinimumLengthEncoding {

    /**
     * 如果一个单词X是另一个单词Y的后缀，那么X可以不用考虑，一定可以用Y的编码表示
     * @param words
     * @return
     */
    public int minimumLengthEncoding(String[] words) {
        //去重
        Set<String> wordSet = new HashSet(Arrays.asList(words));
        for (String word : words) {
            for (int i=1; i<word.length(); i++) {
                //去掉后缀相同的单词
                wordSet.remove(word.substring(i));
            }
        }
        int len = 0;
        for (String str : wordSet) {
            //每个单词"#"结束
            len += str.length()+1;
        }
        return len;
    }
}
