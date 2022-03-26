package com.maomao.test.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，
 * 但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
 *
 * 示例 1：
 *
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 *
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 *
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 * 示例 4：
 *
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]

 * @author: huida
 * @date: 2020/12/18
 **/
public class RestoreIpAddresses {

    /**
     * 回溯
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        LinkedList<String> path = new LinkedList<>();
        //长度不满足
        if (len<4 || len >12) {
            return res;
        }
        dfs(0,0, s, res, path);
        return res;
    }

    /**
     *
     * @param begin      开始的索引
     * @param splitCount 分割的层数
     * @param s
     * @param res
     * @param path
     */
    private void dfs(int begin, int splitCount, String s, List<String> res, LinkedList<String> path) {
        //结束条件
        if (begin == s.length() && splitCount == 4) {
            //ip分为4段
            res.add(String.join(".", path));
            return;
        }
        for (int i= begin; i<s.length(); i++) {
            // 每次分割后，判断剩下的字符串的长度是否合理，进行剪枝
            if (s.length()-i-1 > 3 * (3 - splitCount)) {
                continue;
            }
            //ip是否合法
            if (!judgeIfIpSegment(s.substring(begin, i+1))) {
                continue;
            }
            //选择
            path.add(s.substring(begin, i+1));
            dfs(i+1,splitCount+1, s, res, path);
            //回溯
            path.removeLast();
        }


    }

    /**
     * 判断是否是合法的Ip
     * @param s
     * @return
     */
    private boolean judgeIfIpSegment(String s) {
        // 大于 1 位的时候，不能以 0 开头
        if (s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }
        //大于3位
        if (s.length() > 3) {
            return false;
        }
        if (Integer.parseInt(s) > 255) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "25525511135";
        System.out.println(new RestoreIpAddresses().restoreIpAddresses(s));
    }


}

