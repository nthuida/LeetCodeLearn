package com.maomao.test.stack;

import java.util.Stack;

/**
 * 去除重复字母
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。
 * 需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 * 示例 1：
 * 输入：s = "bcabc"
 * 输出："abc"
 *
 * 示例 2：
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 *
 * @author: huida
 * @date: 2020/12/20
 **/
public class RemoveDuplicateLetters {

    /**
     * 单调栈
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        //记录每个字符出现的次数
        int[] count = new int[128];
        for (int i=0; i<s.length(); i++) {
            count[s.charAt(i)]++;
        }
        //记录字符是否出现过
        boolean[] flag = new boolean[128];
        for (char ch : s.toCharArray()) {
            //每次遍历过，减1
            count[ch]--;
            if (flag[ch]) {
                continue;
            }
            //保证字典顺序，递减
            while (!stack.empty() && stack.peek()>ch) {
                // 若之后不存在栈顶元素了，则停止 pop
                if (count[stack.peek()] == 0) {
                    break;
                }
                // 若之后还有，则可以 pop
                flag[stack.pop()] = false;
            }
            stack.push(ch);
            flag[ch] = true;
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.empty()) {
            stringBuilder.append(stack.pop());
        }

        return stringBuilder.reverse().toString();
    }
}
