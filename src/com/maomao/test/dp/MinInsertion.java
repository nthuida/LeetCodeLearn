package com.maomao.test.dp;

/**
 * 让字符串成为回文串的最少插入次数
 * 给你一个字符串 s ，每一次操作你都可以在字符串的任意位置插入任意字符。
 *
 * 请你返回让 s 成为回文串的 最少操作次数 。
 *
 * 「回文串」是正读和反读都相同的字符串。
 *
 * 示例 1：
 *
 * 输入：s = "zzazz"
 * 输出：0
 * 解释：字符串 "zzazz" 已经是回文串了，所以不需要做任何插入操作。
 * 示例 2：
 *
 * 输入：s = "mbadm"
 * 输出：2
 * 解释：字符串可变为 "mbdadbm" 或者 "mdbabdm" 。
 * 示例 3：
 *
 * 输入：s = "leetcode"
 * 输出：5
 * 解释：插入 5 个字符后字符串变为 "leetcodocteel" 。
 * 示例 4：
 *
 * 输入：s = "g"
 * 输出：0
 * 示例 5：
 *
 * 输入：s = "no"
 * 输出：1
 *
 * @author: huida
 * @date: 2021/12/11
 **/
public class MinInsertion {

    /**
     * dp[i][j] 最少添加的字符数量，使得 s[i:j] 变为回文串
     * base case：i == j 时 dp[i][j] = 0，单个字符本身就是回文
     * 三种情况
     * L 到 R -1 回文 补充一个 R 的字  ++
     * L + 1 到 R 回文 补充一个 L 的字 ++
     * L == R 且 L + 1 到 R -1  回文 不补充
     * @param s
     * @return
     */
    public int minInsertions(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        int len = s.length();
        int[][] dp = new int[len][len];
        //从下往上
        for (int i=len-2; i>=0; i--) {
            //从左往右
            for (int j=i+1; j<len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1]) +1;
                }
            }
        }
        return dp[0][len-1];
    }
}
