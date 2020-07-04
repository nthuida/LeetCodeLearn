package com.maomao.test.string;

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
     * 栈顶保存遍历过程中最后一个没有被匹配的右括号的下标
     * 扫描到右括号，就将栈顶出栈（代表栈顶的左括号匹配到了右括号），然后分两种情况。
     *
     * 1、栈不空，那么就用当前的位置减去栈顶的存的位置，然后就得到当前合法序列的长度，然后更新一下最长长度。
     * 2、栈是空的，说明之前没有与之匹配的左括号，那么就将当前的位置入栈。
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if (s == null || s == "") {
            return 0;
        }
        int max = 0;
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
                    //都已经匹配
                    stack.push(i);
                } else {
                    //计算最大值
                    max = Math.max(max, i - stack.peek());
                }
            }

        }
        return max;
    }
}
