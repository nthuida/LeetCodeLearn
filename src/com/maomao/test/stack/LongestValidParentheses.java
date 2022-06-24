package com.maomao.test.stack;

import java.util.Stack;

/**
 * 最长的有效括号
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 *
 *
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 * @author huida
 * @date 2020/7/4
 */
public class LongestValidParentheses {

    /**
     * 思路：当前索引 - 出栈后新的栈顶索引
     * 两种索引会入栈：1、等待被匹配的左括号索引； 2、充当「参照物」的右括号索引
     * 扫描到右括号，就将栈顶出栈，然后分两种情况。
     * 1、栈不空，就用当前的位置减去栈顶的位置，得到当前合法序列的长度；
     * 2、栈是空的，说明之前没有与之匹配的左括号，就将当前的位置入栈当参照；
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if (s == null || s == "") {
            return 0;
        }
        int max = 0;
        //保存下标索引
        Stack<Integer> stack = new Stack<>();
        //便于计算第一个匹配的括号
        stack.push(-1);
        for (int i=0; i< s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else {
                //匹配,出栈
                stack.pop();
                if (stack.empty()) {
                    //都已经匹配，保存当前右括号的下标当参照
                    stack.push(i);
                } else {
                    //计算最大值
                    max = Math.max(max, i - stack.peek());
                }
            }

        }
        return max;
    }

    /**
     * 动态规划
     * 状态定义：dp[i] 表示以i结尾的最长有效括号长度
     * 状态转移方程： s[i] = '('   dp[i] = 0;
     *              s[i] = ')'  dp[i] = dp[i-2] + 2  if s[i-1] = '('
     *                          dp[i] = dp[i-1] + dp[i-dp[i-1]-2] + 2  if s[i-1] = ')'
     * @param s
     * @return
     */
    public int longestValidParenthesesII(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i=1; i<s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i-1) == '(') {
                    dp[i] = i-2 >=0 ? (dp[i-2] + 2) : 2;
                } else if (i-dp[i-1]-1 >=0 && s.charAt(i-dp[i-1]-1) == '('){
                    //i-1 对应的位置为 i-dp[i-1]-1
                    if (i-dp[i-1]-2 >=0) {
                        //需要加上i-dp[i-1]-1的前一个位置i-dp[i-1]-2对应的最长有效长度
                        dp[i] = dp[i-dp[i-1]-2] + dp[i-1] + 2;
                    } else {
                        dp[i] = dp[i-1] + 2;
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
