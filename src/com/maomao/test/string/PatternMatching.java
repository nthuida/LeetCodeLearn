package com.maomao.test.string;

/**
 * 模式匹配
 * 你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。
 * 例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。
 * 但需注意"a"和"b"不能同时表示相同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。
 *
 * 示例 1：
 *
 * 输入： pattern = "abba", value = "dogcatcatdog"
 * 输出： true
 *
 * 示例 2：
 * 输入： pattern = "abba", value = "dogcatcatfish"
 * 输出： false
 *
 * 示例 3：
 * 输入： pattern = "aaaa", value = "dogcatcatdog"
 * 输出： false
 *
 * 示例 4：
 * 输入： pattern = "abba", value = "dogdogdogdog"
 * 输出： true
 * 解释： "a"="dogdog",b=""，反之也符合规则
 *
 * @author huida
 * @date 2020/7/2
 */
public class PatternMatching {

    /**
     * 主要是围绕这个方程lv=ca*la+cb*lb
     *
     * lv:value的长度
     * ca:匹配串中a的个数
     * la:a的长度
     * cb:匹配串中b的个数
     * lb:b的长度
     * 枚举la，求出lb，在判断是否匹配
     *
     * @param pattern
     * @param value
     * @return
     */
    public boolean patternMatching(String pattern, String value) {
        //a出现的个数
        int countA = 0;
        int countB = 0;
        if (pattern.length() == 0) {
            return false;
        }
        for (char ch : pattern.toCharArray()) {
            if (ch == 'a') {
                countA++;
            } else {
                countB++;
            }
        }
        //字符串为空，匹配字符串a或者b的个数为空才成立
        if (value.length() == 0) {
            return countA*countB ==0;
        }
        //a为空
        if (countA == 0) {
            if (value.length() % countB != 0){
                return false;
            }
            int lenB = value.length() / countB;
            String aa = value.substring(0, lenB);
            for (int i = aa.length(); i < value.length(); i += aa.length()) {
                if (!value.substring(i, i + aa.length()).equals(aa)) {
                    return false;
                }
            }
            return true;
        }

        if (countB == 0) {
            if (value.length() % countA != 0){
                return false;
            }
            int lenA = value.length() / countA;
            String aa = value.substring(0, lenA);
            for (int i = aa.length(); i < value.length(); i += aa.length()) {
                if (!value.substring(i, i + aa.length()).equals(aa)) {
                    return false;
                }
            }
            return true;
        }

        //a、b都不为空
        //枚举
        for (int lenA = 0; lenA*countA <= value.length(); lenA++) {
            int rest = value.length() - lenA*countA;
            if (rest % countB !=0) {
                continue;
            }
            int lenB = rest/countB;
            int pos = 0;
            boolean match = true;
            String valueA = "", valueB = "";
            for (char ch : pattern.toCharArray()) {
                if (ch == 'a') {
                    String sub = value.substring(pos, pos+lenA);
                    if (valueA.length() == 0) {
                        //第一次进来
                        valueA = sub;
                    } else {
                        if (!sub.equals(valueA)) {
                            match = false;
                            break;
                        }
                    }
                    pos += lenA;
                } else {
                    String sub = value.substring(pos, pos+lenB);
                    if (valueB.length() == 0) {
                        //第一次进来
                        valueB = sub;
                    } else {
                        if (!sub.equals(valueB)) {
                            match = false;
                            break;
                        }
                    }
                    pos += lenB;
                }
            }
            if (match && !valueA.equals(valueB)) {
                return true;
            }
        }

        return false;
    }


}
