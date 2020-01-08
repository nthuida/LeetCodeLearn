package com.maomao.test.string;

/**
 * Excel表列序号
 *
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * 例如，
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * 示例 1:
 *
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 *
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 *
 * 输入: "ZY"
 * 输出: 701
 *
 * @Author huida.mao
 * @Date 2020/1/8
 */
public class TitleToNumber {
    /**
     * 因为有26个字母，所以相当于26进制，每26个数则向前进一位
     * 计算其代表的数值num = 字母 - ‘A’ + 1
     *
     * @param s
     * @return
     */
    public int titleToNumber(String s) {
        int result = 0;
        for (int i =0; i<s.length(); i++) {
            int num = s.charAt(i) - 'A' + 1;
            result = result * 26 + num;
        }
        return result;
    }
}
