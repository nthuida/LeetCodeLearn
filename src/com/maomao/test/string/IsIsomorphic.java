package com.maomao.test.string;

/**
 * 同构字符串
 *
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，
 * 但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "paper", t = "title"
 * 输出: true
 *
 * @Author huida.mao
 * @Date 2020/1/9
 */
public class IsIsomorphic {

    /**
     * 字符串中，同一个位置的字符在本串中第一次出现的位置相同。
     * 所以判断的关键点就是相同的字符要对应相同的字符，那么相同字符处于后位置的字符的第一次出现的位置就应该相同。
     * 所以我们在判断时，只需要判断两个字符串同位置的字符是否相同即可。
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if(s.indexOf(ch1[i]) != t.indexOf(ch2[i])){
                return false;
            }
        }
        return true;
    }

    /**
     * 单词规律
     * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
     * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
     *
     * 示例1:
     * 输入: pattern = "abba", str = "dog cat cat dog"
     * 输出: true
     *
     * 示例 2:
     * 输入:pattern = "abba", str = "dog cat cat fish"
     * 输出: false
     *
     * 示例 3:
     * 输入: pattern = "aaaa", str = "dog cat cat dog"
     * 输出: false
     *
     * 示例 4:
     * 输入: pattern = "abba", str = "dog dog dog dog"
     * 输出: false
     *
     * @param pattern
     * @param str
     * @return
     */
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if (strs.length != pattern.length()) {
            return false;
        }
        for (int i=0; i<pattern.length(); i++) {
            if (pattern.indexOf(pattern.charAt(i)) != indexOf(strs, strs[i])) {
                return false;
            }
        }
        return true;

    }

    public int indexOf(String[] strs, String index) {
        int ans = -1;
        for (int i=0; i< strs.length; i++) {
            if (index.equals(strs[i])) {
                ans = i;
                break;
            }
        }
        return ans;
    }
}
