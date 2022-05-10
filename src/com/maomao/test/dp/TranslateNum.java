package com.maomao.test.dp;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，
 * ……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * 示例 1:
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 * @author huida
 * @date 2020/6/9
 */
public class TranslateNum {

    /**
     *  动态规划dp[i]，表示以i为结尾的数字的翻译方案数量
     * ​ i-1和i组成的两位数字可以被翻译，则 dp[i] = dp[i - 1] + dp[i - 2]；否则 dp[i] = dp[i - 1];
     *
     * @param num
     * @return
     */
    public int translateNum(int num) {
        String str = num + "";
        //代表第i位，初始化dp(1) = 1
        int a = 1;
        //i-1位, 初始化dp(0) = 1
        int b = 1;
        for (int i=2; i<=str.length(); i++) {
            String s = str.substring(i-2, i);
            //滚动数组，结合动态表达式
            int temp = 0;
            if (s.compareTo("10") >=0 && s.compareTo("25")<=0) {
                temp = a+b;
            } else {
                temp = a;
            }
            b = a;
            a = temp;
        }
        return a;
    }


    public int translateNumII(int num) {
        String str = num + "";
        int len = str.length();
        int[] dp = new int[len+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2; i<=len; i++) {
            String s = str.substring(i-2, i);
            if (s.compareTo("10") >=0 && s.compareTo("25")<=0) {
                dp[i] = dp[i-1] + dp[i-2];
            } else {
                dp[i] = dp[i-1];
            }
        }
        return dp[len];
    }
}
