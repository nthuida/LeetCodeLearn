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
     * 动态规划 完全背包
     * 定义状态：dp[i]表示前i个字符能否拆分
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
        boolean[] dp = new boolean[s.length()+1];
        //空字符串，初始化为true
        dp[0] = true;
        for (int i=1; i<=s.length(); i++) {
            for (int j=0; j<i; j++) {
                //判断dp[j]，以及[j,i]的元素是否在字典内
                //i对应的字符串坐标为i-1,j对应的字符串坐标为j-1,子串为j-1+1, i-1+1;
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    //找到一个就可以
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
