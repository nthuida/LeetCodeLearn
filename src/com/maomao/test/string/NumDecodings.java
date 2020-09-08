package com.maomao.test.string;

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
     * 用一个 dp 数组， dp [ i ] 代表字符串 s 从 i 开始到结尾的字符串的解码方式。
     * dp [ i ] = dp[ i + 1 ] + dp [ i + 2 ]
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        //动态数组
        int[] dp = new int[len+1];
        //将递归法的结束条件初始化为 1
        dp[len] = 1;
        //最后一个字符不为0，初始化
        if (s.charAt(len-1) != '0') {
            dp[len-1] = 1;
        }

        for (int i=len-2; i>=0; i--) {
            if (s.charAt(i) == '0') {
                continue;
            }
            //分割为一个字符和剩余
            dp[i] = dp[i+1];
            //分割为两个字符和剩余
            int temp = (s.charAt(i) - '0') * 10 + (s.charAt(i+1) - '0');
            if (temp <= 26) {
                dp[i] += dp[i+2];
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(new NumDecodings().numDecodings("220"));
    }
}
