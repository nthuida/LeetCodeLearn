package com.maomao.test.string;

/**
 * 使括号有效的最少添加
 * 给定一个由'('和')'括号组成的字符串 S，
 * 我们需要添加最少的括号（ '('或是')'，可以在任何位置），以使得到的括号字符串有效。
 *
 * 从形式上讲，只有满足下面几点之一，括号字符串才是有效的：
 * 它是一个空字符串，或者
 * 它可以被写成AB（A与B连接）, 其中A 和B都是有效字符串，或者
 * 它可以被写作(A)，其中A是有效字符串。
 * 给定一个括号字符串，返回为使结果字符串有效而必须添加的最少括号数。
 * 
 * 示例 1：
 * 输入："())"
 * 输出：1
 *
 * 示例 2：
 * 输入："((("
 * 输出：3
 *
 * 示例 3：
 * 输入："()"
 * 输出：0
 *
 * 示例 4：
 * 输入："()))(("
 * 输出：4
 *
 * @author: huida
 * @date: 2021/12/3
 **/
public class MinAddToMakeValid {

    /**
     * 核⼼思路是以左括号为基准，通过维护对右括号的需求数 need，来计算最⼩的插⼊ 次数
     * @param s
     * @return
     */
    public int minAddToMakeValid(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        //左括号数
        int needLeft = 0;
        //右括号数
        int needRight = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                //需要右括号
                needRight++;
            }
            if (s.charAt(i) == ')') {
                needRight--;
            }
            if (needRight == -1) {
                //需要左括号
                needLeft++;
                needRight = 0;
            }
        }
        return needLeft + needRight;
    }
}
