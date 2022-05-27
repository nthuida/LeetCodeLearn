package com.maomao.test.dfs;

import java.math.BigInteger;
import java.util.LinkedList;

/**
 * 累加数
 * 累加数 是一个字符串，组成它的数字可以形成累加序列。
 * 一个有效的 累加序列 必须 至少 包含 3 个数。除了最开始的两个数以外，序列中的每个后续数字必须是它之前两个数字之和。
 * 给你一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是 累加数 。如果是，返回 true ；否则，返回 false 。
 * 说明：累加序列里的数，除数字 0 之外，不会 以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 *
 * 示例 1：
 * 输入："112358"
 * 输出：true
 * 解释：累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 *
 * 示例 2：
 * 输入："199100199"
 * 输出：true
 * 解释：累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
 *
 * @author: huida
 * @date: 2022/5/27
 **/
public class IsAdditiveNumber {

    public boolean isAdditiveNumber(String num) {
        LinkedList<String> path = new LinkedList<>();
        return dfs(path, num, 0);
    }

    private boolean dfs(LinkedList<String> path, String num, int start) {
        //结束条件
        if (start == num.length()) {
            if (path.size()>=3) {
                return valid(path);
            }
        }
        for (int i=start; i<num.length(); i++) {
            // 剪枝：不能做为前导0，但可以单独做为0来使用的 "101" 、"1023"
            if (num.charAt(start) == '0' && i > start) {
                return false;
            }
            String str = num.substring(start, i+1);
            path.add(str);
            //两数相加不符合，剪枝
            if (path.size()>=3) {
                if (!valid(path)) {
                    path.removeLast();
                    continue;
                }
            }
            System.out.println("回溯前：" + path.toString());
            if (dfs(path, num, i+1)) {
                return true;
            }
            path.removeLast();
            System.out.println("  回溯后： " + path.toString());
        }
        return false;
    }

    /**
     * 大数相加，防止溢出
     * @param list
     * @return
     */
    private boolean valid(LinkedList<String> list) {
        String first = list.get(list.size()-3);
        String second = list.get(list.size()-2);
        String sum = new BigInteger(first).add(new BigInteger(second)).toString();
        String third = list.get(list.size()-1);
        if (sum.equals(third)) {
            return true;
        }
        return false;
    }


}
