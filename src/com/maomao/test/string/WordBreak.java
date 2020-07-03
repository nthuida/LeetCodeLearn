package com.maomao.test.string;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
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
 *      注意你可以重复使用字典中的单词。
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
     * 动态规划算法，dp[i]表示s前i个字符能否拆分
     * 转移方程：dp[j] = dp[i] && check(s[i+1, j]);
     * check(s[i+1, j])就是判断i+1到j这一段字符是否能够拆分
     * 其实，调整遍历顺序，这等价于s[i+1, j]是否是wordDict中的元素
     * 这个举个例子就很容易理解。
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
        dp[0] = true;
        for (int i=1; i<=s.length(); i++) {
            for (int j=0; j<i; j++) {
                //判断dp[j]是否可以且j->i的元素是否在字典内，s.substring(j, i)，不包括i，正好可以取出前i个元素
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
