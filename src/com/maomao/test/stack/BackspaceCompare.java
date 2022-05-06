package com.maomao.test.stack;

import java.util.Stack;

/**
 *比较含退格的字符串
 *给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * 示例 1：
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * @author Administrator
 * @date 2019/3/17
 */
public class BackspaceCompare {
    /**
     * 用栈来保存两个字符串，并比较
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> a = new Stack<>();
        Stack<Character> b = new Stack<>();
        for (int i=0; i<S.length(); i++) {
            if (S.charAt(i) != '#') {
                a.push(S.charAt(i));
            } else {
                if (!a.empty()) {
                    a.pop();
                }
            }
        }

        for (int i=0; i<T.length(); i++) {
            if (T.charAt(i) != '#') {
                b.push(T.charAt(i));
            } else {
                if (!b.empty()) {
                    b.pop();
                }
            }
        }

        return a.equals(b);
    }

}
