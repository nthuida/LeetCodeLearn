package com.maomao.test.dp;

import java.util.*;

/**
 * 单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 说明：
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 *
 * 示例 1：
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 *
 * 示例 2：
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 * 注意你可以重复使用字典中的单词。
 *
 * 示例 3：
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 * @author huida
 * @date 2020/7/2
 */
public class WordBreak {

    /**
     * 动态规划
     * dp[i]表示前i个字符能否拆分
     * 转移方程：dp[j] = dp[i] && check(s[i+1, j]);
     * check(s[i+1, j])就是判断s[i+1, j]是否是wordDict中的元素
     * 假如wordDict=["apple", "pen", "code"],s = "applepencode";
     * dp[8] = dp[5] + check("pen")
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        //空字符串，初始化为true
        dp[0] = true;
        for (int i=1; i<=s.length(); i++) {
            for (int j=0; j<i; j++) {
                //判断dp[j]，以及【j,i】的元素是否在字典内
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    /**
     * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，
     * 使得句子中所有的单词都在词典中。返回所有这些可能的句子。
     * 说明：
     * 分隔时可以重复使用字典中的单词。
     * 你可以假设字典中没有重复的单词。
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
     * 示例 3：
     * 输入:
     * s = "catsandog"
     * wordDict = ["cats", "dog", "sand", "and", "cat"]
     * 输出: []
     *
     * 递归: 先判断当前字符串在不在 wordDict 中，如果在的话就递归的去求剩余字符串的所有组成可能
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreakII(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        return wordBreakHelper(s, set, new HashMap<>());
    }

    private List<String> wordBreakHelper(String s, Set<String> wordDict, Map<String, List<String>> map) {
        if (s.length() == 0) {
            return new ArrayList<>();
        }
        if (map.containsKey(s)) {
            //map中有，直接返回
           return map.get(s);
        }
        List<String> res = new ArrayList<>();
        for (int i=0; i<s.length(); i++) {
            //字典里包含当前字符串
            if (wordDict.contains(s.substring(i, s.length()))) {
                if (i == 0) {
                    //直接加入
                    res.add(s.substring(i));
                } else {
                    //递归得到剩余字符串的结果
                    List<String> temp = wordBreakHelper(s.substring(0, i), wordDict, map);
                    for (int k=0; k<temp.size(); k++) {
                        res.add(temp.get(k) + " " + s.substring(i, s.length()));
                    }
                }
            }
        }
        map.put(s, res);
        return res;
    }
}
