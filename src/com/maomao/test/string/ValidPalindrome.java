package com.maomao.test.string;

/**
 * 验证回文字符串
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 * 输入: "aba"
 * 输出: True
 *
 * 示例 2:
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 *
 * 注意:字符串只包含从 a-z 的小写字母。字符串的最大长度是50000
 *
 * @author huida
 * @date 2020/5/19
 */
public class ValidPalindrome {

    /**
     * 复杂度 ：n^2,超时
     * @param s
     * @return
     */
    public boolean validPalindrome1(String s) {
        StringBuffer stringBuffer = new StringBuffer(s);
        if (stringBuffer.reverse().toString().equals(s)) {
            return true;
        }
        for (int i=0; i<s.length();i++) {
            //删除指定位置字符串
            StringBuffer buffer = new StringBuffer(s).deleteCharAt(i);
            if (buffer.toString().equals(buffer.reverse().toString())) {
                return true;
            }
        }
        return false;
    }

    public boolean validPalindrome(String s) {
        if (isPalindrome(s, 0, s.length()-1)) {
            return true;
        }
        int low  = 0;
        int high = s.length()-1;
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                //删除一个字符，判断左边或者右边是不是回文
                return isPalindrome(s, low+1, high) || isPalindrome(s, low, high-1);
            }
            low++;
            high--;
        }
        return true;
    }
    public boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "abca";
        System.out.println(new ValidPalindrome().validPalindrome(s));
    }
}
