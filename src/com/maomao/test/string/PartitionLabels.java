package com.maomao.test.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 划分字母区间
 *
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 *
 * 示例 1：
 *
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *
 * @author huida
 * @date 2020/10/22
 */
public class PartitionLabels {

    /**
     * 已扫描的字符能去到的最远位置，扫到这个位置就切割，切出的字符不会在之后出现
     * @param s
     * @return
     */
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] lastIndex = new int[26];
        //获取字母最远出现的位置；
        for (int i=0; i<s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        int start=0, end = 0;
        for (int i=0; i<s.length(); i++) {
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);
            //找到之前遍历过的所有字母的最远边界，分割
            if (i == end) {
                //长度
                res.add(end-start+1);
                //下一个开始
                start = end+1;
            }
        }

        return res;
    }
}
