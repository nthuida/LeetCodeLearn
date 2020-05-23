package com.maomao.test.string;

/**
 * 最小覆盖子串
 * 你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 *
 * 示例：
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 *
 * @author huida
 * @date 2020/5/23
 */
public class MinWindow {

    /**
     * 滑动窗口法
     * 一个用于「延伸」现有窗口的 r 指针，和一个用于「收缩」窗口的 l 指针。在任意时刻，只有一个指针运动，而另一个保持静止。
     * 我们在 s 上滑动窗口，通过移动 r 指针不断扩张窗口。当窗口包含 t 全部所需的字符后，如果能收缩，我们就收缩窗口直到得到最小窗口。
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
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
        for (int i=0; i<t.length(); i++) {
            ori[t.charAt(i)]++;
        }
        String res = "";
        int min = s.length();

        while (right < s.length()) {
            char ch = s.charAt(right);
            window[ch]++;
            if (ori[ch] > 0 && ori[ch] >= window[ch]) {
                count++;
            }
            //满足条件
            while (count == t.length()) {
                if (right-left <= min) {
                    min = right -left;
                    res = s.substring(left, right+1);
                }
                ch = s.charAt(left);
                if (ori[ch] > 0 && ori[ch] >= window[ch]) {
                    count--;
                }
                window[ch]--;
                left++;
            }

            right++;
        }
        return res;
    }
}
