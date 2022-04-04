package com.maomao.test.string;

/**
 * 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 * 注意：
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 *
 * @author huida
 * @date 2020/8/3
 */
public class AddStrings {

    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        //进位
        int sum = 0;
        for (int i=num1.length()-1, j = num2.length()-1; i>=0 || j>=0; i--,j--) {
            if (i>=0) {
                sum += num1.charAt(i) - '0';
            }
            if (j>=0) {
                sum += num2.charAt(j) - '0';
            }
            res.append(sum%10);
            sum = sum/10;
        }

        if (sum == 1) {
            res.append(sum);
        }

        return res.reverse().toString();
    }
}
