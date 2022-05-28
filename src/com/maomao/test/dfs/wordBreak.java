package com.maomao.test.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，
 * 使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * 说明：分隔时可以重复使用字典中的单词。
 *
 * 示例 1：
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 *
 * 示例 2：
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 *
 * @author: huida
 * @date: 2022/5/28
 **/
public class wordBreak {

    public List<String> wordBreak(String s, List<String> wordDict) {
        LinkedList<String> path = new LinkedList<>();
        List<String> res = new ArrayList<>();
        dfs(s, wordDict, res, path, 0);
        return res;
    }

    private void dfs(String s, List<String> wordDict, List<String> res, LinkedList<String> path, int start) {
        if (start == s.length()) {
            res.add(String.join(" ", path));
            return;
        }
        for (int i=start; i<s.length(); i++) {
            String str = s.substring(start, i+1);
            if (!wordDict.contains(str)) {
                continue;
            }
            path.add(str);
            dfs(s, wordDict, res, path, i+1);
            path.removeLast();
        }
    }
}
