package com.maomao.test.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 *
 * @author huida
 * @date 2020/5/28
 */
public class DecodeString {

    /**
     * 如果当前的字符为数位，解析出一个数字（连续的多个数位）并进栈
     * 如果当前的字符为字母或者左括号，直接进栈
     * 如果当前的字符为右括号，开始出栈，一直到左括号出栈，出栈序列反转后拼接成一个字符串，
     * 此时取出栈顶的数字，就是这个字符串应该出现的次数，我们根据这个次数和字符串构造出新的字符串并进栈
     *
     * @param s
     * @return
     */
    public String decodeString(String s) {
        LinkedList<String> stack = new LinkedList<>();
        StringBuilder digit = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            char chara = s.charAt(i);
            if (Character.isDigit(chara)) {
                //多个数字合并成一个
                digit.append(chara);
            }  else if (chara == '[') {
                stack.addLast(digit.toString());
                digit = new StringBuilder();
                stack.addLast(chara + "");
            } else if (Character.isLetter(chara)) {
                stack.addLast(chara + "");
            } else {
                List<String> list = new ArrayList<>();
                while (!"[".equals(stack.peekLast())) {
                    list.add(stack.removeLast());
                }
                //反转
                Collections.reverse(list);
                StringBuilder subStr = new StringBuilder();
                for (String string : list) {
                    subStr.append(string);
                }
                //左括号出栈
                stack.removeLast();
                int num = Integer.parseInt(stack.removeLast());
                StringBuilder newStr = new StringBuilder();
                while (num != 0) {
                    newStr.append(subStr);
                    num--;
                }
                //进栈
                stack.addLast(newStr.toString());
            }
        }
        StringBuffer result = new StringBuffer();
        for (String string : stack) {
            result.append(string);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String a = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        System.out.println(new DecodeString().decodeString(a));
    }
}
