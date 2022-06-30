package com.maomao.test.dp;

/**
 * 解码方法
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 *
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 * @author huida
 * @date 2020/9/8
 */
public class NumDecodings {

    /**
     * 状态定义：dp[i]表示以i结尾的字符串的解码总数
     * 状态转移方程
     * dp[i] = dp[i-1]  1<=a<=9 以一个字符i解码
     * dp[i] = dp[i-1] + dp[i-2] 10<=b<=26 以两个字符[i-1,i]解码
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len+1];
        //初始化 空字符串
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2; i<=len; i++) {
            int a = s.charAt(i-1) - '0';
            if (a != 0) {
                dp[i] = dp[i-1];
            }
            int b = (s.charAt(i-2)-'0')*10 + a;
            if (10 <=b && b<=26) {
                //两个字符解码
                dp[i] += dp[i-2];
            }
        }
        return dp[len];
    }

}
