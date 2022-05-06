package com.maomao.test.slidingWindow;

/**
 * 字符串的排列
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 *
 * 示例 1：
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 *
 * 示例 2：
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 *
 * @author: huida
 * @date: 2021/11/23
 **/
public class CheckInclusion {

    /**
     * 滑动窗口
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s2.length() < s1.length()) {
            return false;
        }
        int left = 0;
        int right = 0;
        //用来对原字符串的字符计数
        int[] ori = new int[128];
        //滑动窗口字符计数
        int[] window = new int[128];
        //目前窗口找到的字符数
        int count = 0;
        //原字符串计数
        for (int i=0; i<s1.length(); i++) {
            ori[s1.charAt(i)]++;
        }
        while (right < s2.length()) {
            char ch = s2.charAt(right);
            window[ch]++;
            if (ori[ch] > 0 && ori[ch] >= window[ch]) {
                count++;
            }
            //满足条件,窗口大小等于s1长度
            while ((right-left +1) == s1.length()) {
                //需要字符数等于s1的长度
                if (count == s1.length()) {
                    return true;
                }
                ch = s2.charAt(left);
                //左边缩小窗口
                if (ori[ch] > 0 && ori[ch] >= window[ch]) {
                    count--;
                }
                window[ch]--;
                left++;
            }
            right++;
        }
        return false;
    }

}
