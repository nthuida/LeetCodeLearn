package com.maomao.test.string;

/**
 * 最后一个单词的长度
 * @Author huida.mao
 * @Date 2019/10/14
 */
public class LengthOfLastWord {
    /**
     * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
     * 如果不存在最后一个单词，请返回 0 。
     * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
     *
     * 示例:
     * 输入: "Hello World"
     * 输出: 5
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        if (s == "" || s == null) {
            return 0;
        }
        s = s.trim();
        if (s.lastIndexOf(" ") == -1) {
            return s.length();
        } else {
            int index = s.lastIndexOf(" ");
            return s.length()-index-1;
        }
    }
}
