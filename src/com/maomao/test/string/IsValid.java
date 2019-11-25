package com.maomao.test.string;

import java.util.Stack;

/**
 * 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * @Author huida.mao
 * @Date 2019/10/14
 */
public class IsValid {
    /**
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if (s == null || s == "") {
            return true;
        }
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if (stack.empty()) {
                    return false;
                }
                if (s.charAt(i) == ')') {
                    if (stack.pop() != '(') {
                        return false;
                    }
                }
                if (s.charAt(i) == ']') {
                    if (stack.pop() != '[') {
                        return false;
                    }
                }
                if (s.charAt(i) == '}') {
                    if (stack.pop() != '{') {
                        return false;
                    }
                }

            }
        }
        return stack.empty();

    }
}
