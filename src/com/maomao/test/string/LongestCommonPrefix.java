package com.maomao.test.string;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * @Author huida.mao
 * @Date 2019/10/14
 */
public class LongestCommonPrefix {
    /**
     * 首先假设最长前缀result=str[0], 遍历字符串数组，依次与result做比较，
     * 找出其最长前缀，然后更新result，再进行下一次比较。
     * @param strs
     * @return
     */
    public  String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String result = strs[0];
        for (int i=1; i<strs.length; i++) {
            //indexOf() 字符出现的最早位置
            while (strs[i].indexOf(result) != 0) {
                result = result.substring(0,result.length()-1);
                if (result.length() == 0) {
                    return "";
                }
            }
        }

        return result;

    }

}
