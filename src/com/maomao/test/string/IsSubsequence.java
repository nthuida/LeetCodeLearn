package com.maomao.test.string;

/**
 * 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 *
 * 返回 true.
 *
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 *
 * 返回 false.
 *
 * @Author huida.mao
 * @Date 2019/11/2
 */
public class IsSubsequence {

    /**
     * 两个指针分别指向s和t，如果指针所指的位置相同，则两个指正都后移，否则只有指向t的指针后移。
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int i =0, j=0;
        while (i<s.length() && j<t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                //只有t向后移动
                j++;
            }
        }
        //遍历到最后
        if (i == s.length()) {
            return true;
        } else {
            return false;
        }
    }
}
