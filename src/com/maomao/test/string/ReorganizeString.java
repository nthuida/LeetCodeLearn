package com.maomao.test.string;

/**
 * 重构字符串
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 *
 * 示例 1:
 * 输入: S = "aab"
 * 输出: "aba"
 *
 * 示例 2:
 * 输入: S = "aaab"
 * 输出: ""
 *
 * @author huida
 * @date 2020/12/9
 */
public class ReorganizeString {

    public String reorganizeString(String S) {
        if (S.length() <=2) {
            return S;
        }
        char[] chars = S.toCharArray();
        //统计字符出现的次数
        int[] charCount = new int[26];
        for (int i=0; i<chars.length; i++) {
            charCount[chars[i] - 'a']++;
        }
        int max = 0;
        //最多字符的位置
        int locate = 0;
        //最多次数的阈值
        int threshold = (S.length() + 1) >> 1;
        //找出出现次数最多的字符
        for (int i=0; i<charCount.length; i++) {
            if (charCount[i] > max) {
                max = charCount[i];
                locate = i;
            }
            if (max > threshold) {
                return "";
            }
        }
        int index = 0;
        char[] res = new char[S.length()];
        //偶数位置存放出现次数最多的字符
        while (charCount[locate]-- >0) {
            res[index] = (char)(locate + 'a');
            index += 2;
        }
        //剩余字符放在其他位置
        for (int i = 0; i < charCount.length; i++) {
            while (charCount[i]-- > 0) {
                //?
                if (index >= res.length) {
                    index = 1;
                }
                res[index] = (char) (i + 'a');
                index += 2;
            }
        }
        return new String(res);

    }

}
