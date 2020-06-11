package com.maomao.test.string;

/**
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。
 * 若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 *
 * 示例1:
 *  输入："aabcccccaaa"
 *  输出："a2b1c5a3"
 *
 * 示例2:
 *  输入："abbccd"
 *  输出："abbccd"
 *  解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 *
 * @author huida
 * @date 2020/6/10
 */
public class CompressString {
    public String compressString(String S) {
        if (S == null || S == "") {
            return S;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int len = S.length();
        int i = 0;
        int count = 1;
        while (i < len) {
            if ((i+1) < len && S.charAt(i) == S.charAt(i+1)) {
                count++;
            } else {
                stringBuffer.append(S.charAt(i)).append(count);
                count = 1;
            }
            i++;
        }
        if (stringBuffer.length() >= S.length()) {
            return S;
        } else {
            return  stringBuffer.toString();
        }
    }
}
