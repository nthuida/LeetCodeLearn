package com.maomao.test.string;

import java.util.*;

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
     * 碰到'[',当前字符串和数字进栈
     * 碰到']'，数字和字符串出栈，重新拼接
     * @param s
     * @return
     */
    public String decodeString(String s) {
        //保存当前字符串
        Stack<String> stackStr = new Stack<>();
        //保存倍数
        Stack<Integer> stackNum = new Stack<>();
        StringBuilder res = new StringBuilder();
        //保存数字
        int num = 0;
        for (int i=0; i<s.length(); i++) {
            char chara = s.charAt(i);
            if (Character.isDigit(chara)) {
                num = num * 10 + (chara - '0');
            }  else if (chara == '[') {
                //将前面的数字和字符串进栈
                stackNum.add(num);
                stackStr.add(res.toString());
                //重新计算
                num = 0;
                res = new StringBuilder();
            } else if (Character.isLetter(chara)) {
                res.append(chara);
            } else {
                //拼接字符串 res = preStr + curNum * res
                //字符串重复倍数
                int curNum = stackNum.pop();
                StringBuilder temp = new StringBuilder();
                while (curNum != 0) {
                    //当前字符串重复
                    temp.append(res);
                    curNum--;
                }
                //前一个字符串
                String preStr = stackStr.pop();
                //更新结果
                res = new StringBuilder(preStr + temp);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String a = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        System.out.println(new DecodeString().decodeString(a));
    }
}
