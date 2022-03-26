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
     * 一个用于扩大现有窗口的 r 指针，和一个用于缩小窗口的 l 指针。初始化为l=r=0
     * 先移动 r 指针不断扩张窗口，直到窗口中的字符串符合要求后停止；
     * 然后移动 l 指针，缩小窗口，直到窗口中的字符串不符合要求，每次移动l,需要更新结果；
     * 重复上面两步，直到 r 指针到达字符串的尽头
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
        //记录目标字符串字符出现次数
        int[] need = new int[128];
        //滑动窗口字符出现次数
        int[] window = new int[128];
        //目前窗口找到的字符数
        int count = 0;
        //目标字符串计数
        for (int i=0; i<t.length(); i++) {
            need[t.charAt(i)]++;
        }
        String res = "";
        int min = s.length();

        while (right < s.length()) {
            //移入窗口的字符
            char r = s.charAt(right);
            window[r]++;
            //右移窗口
            right++;
            if (need[r] > 0 && need[r] >= window[r]) {
                count++;
            }
            //判断左侧是否要收缩
            while (count == t.length()) {
                //更新结果
                if (right-left <= min) {
                    min = right -left;
                    res = s.substring(left, right);
                }
                //移出窗口的字符
                char l = s.charAt(left);
                window[l]--;
                //左边缩小窗口
                left++;
                if (need[l] > 0 && need[l] > window[l]) {
                    count--;
                }
            }
        }
        return res;
    }

    /**
     * 暴力解决，超时
     * @param s
     * @param t
     * @return
     */
    public String minWindowII(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m < n) {
            return "";
        }
        //截取长度n至m的字符串，分别比较
        for(int i=n; i<=m; i++) {
            for (int j=0; j+i<=m; j++) {
                String temp = s.substring(j, j+i);
                if (compare(temp, t)) {
                    return temp;
                }
            }
        }
        return "";
    }

    /**
     * 比较两字符串是否包含
     * @param a
     * @param b
     * @return
     */
    private boolean compare(String a, String b) {
        int[] ori = new int[128];
        for (int i=0; i<a.length(); i++) {
            ori[a.charAt(i)]++;
        }
        for (int j=0; j<b.length(); j++) {
            if (ori[b.charAt(j)]-- == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new MinWindow().minWindow("a", "a"));
    }
}
