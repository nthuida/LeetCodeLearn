package com.maomao.test.greedy;

/**
 * 由范围 [0,n] 内所有整数组成的 n + 1 个整数的排列序列可以表示为长度为 n 的字符串 s ，其中:
 * 如果 perm[i] < perm[i + 1] ，那么 s[i] == 'I' 
 * 如果 perm[i] > perm[i + 1] ，那么 s[i] == 'D' 
 * 给定一个字符串 s ，重构排列 perm 并返回它。如果有多个有效排列perm，则返回其中 任何一个 。
 *
 * 示例 1：
 * 输入：s = "IDID"
 * 输出：[0,4,1,3,2]
 *
 * 示例 2：
 * 输入：s = "III"
 * 输出：[0,1,2,3]
 *
 * 示例 3：
 * 输入：s = "DDI"
 * 输出：[3,2,0,1]
 *
 * @author: huida
 * @date: 2022/5/9
 **/
public class DiStringMatch {

    /**
     * I 和 D 决定了 前后位置的大小关系，每次根据 I 或 D 选取 T 中最小或最大的数字；
     *
     * 具体步骤如下：
     * 用两个指针来保存当前 T 中的 最大值max 和最小值min ；
     * 遍历字符串
     * 如果 s[i]=‘I’，那么令 result[i] 为剩余数字中的最小数；
     * 如果 s[i]=‘D’，那么令 result[i] 为剩余数字中的最大数；
     * 最后一个数，填入 result[n] 中；
     *
     * @param s
     * @return
     */
    public int[] diStringMatch(String s) {
        int len = s.length();
        int[] res = new int[len+1];
        int min = 0, max=len;
        for (int i=0; i<len; i++) {
            if (s.charAt(i) == 'I') {
                res[i] = min;
                min++;
            } else {
                res[i] = max;
                max--;
            }
        }
        res[len] = min;
        return res;

    }
}
