package com.maomao.test.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
 *
 *  
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
     * 回溯剪枝
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        if (len<4 || len >12) {
            return res;
        }
        dfs(len,0,0, s, res, path);
        return res;
    }

    private void dfs(int len, int begin, int splitCount, String s, List<String> res, List<String> path) {
        if (begin == len) {
            //退出
            if (splitCount == 4) {
                //ip分为4段
                res.add(String.join(".", path));
            }
            return;
        }
        // 看到剩下的不够了，就退出（剪枝），len - begin 表示剩余的还未分割的字符串的位数
        if (len - begin < (4 - splitCount) || len - begin > 3 * (4 - splitCount)) {
            return;
        }

        for (int i=0; i<3;i++) {
            //分割
            if (begin + i >=len) {
                break;
            }
            int ip = judgeIfIpSegment(s, begin, begin+i);

            if (ip != -1) {
                path.add(ip +"");
                dfs(len, begin+i+1, splitCount+1, s, res, path);
                path.remove(path.size()-1);
            }
        }

    }

    private int judgeIfIpSegment(String s, int left, int right) {
        int len = right - left + 1;

        // 大于 1 位的时候，不能以 0 开头
        if (len > 1 && s.charAt(left) == '0') {
            return -1;
        }

        // 转成 int 类型
        int res = 0;
        for (int i = left; i <= right; i++) {
            res = res * 10 + s.charAt(i) - '0';
        }

        if (res > 255) {
            return -1;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "010010";
        System.out.println(new RestoreIpAddresses().restoreIpAddresses(s));
    }


}

