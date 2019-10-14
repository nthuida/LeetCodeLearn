package com.maomao.test.digit;

/**
 * @Author huida.mao
 * @Date 2019/10/14
 */
public class Palindrome {

    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     *
     * 示例 1:
     *
     * 输入: 121
     * 输出: true
     * 示例 2:
     *
     * 输入: -121
     * 输出: false
     * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 示例 3:
     *
     * 输入: 10
     * 输出: false
     * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        String origin = x + "";
        String reverse = new StringBuffer(origin).reverse().toString();
        return origin.equals(reverse);
    }
}
