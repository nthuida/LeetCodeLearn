package com.maomao.test.digit;

/**
 * 比特位计数
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 * 输入: 2
 * 输出: [0,1,1]
 *
 * 示例 2:
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 *
 * @author huida
 * @date 2020/9/1
 */
public class CountBits {

    public int[] countBits(int num) {
        int[] res = new int[num +1];
        for (int i=0; i<=num; i++) {
            res[i] = countBit(i);
        }
        return res;
    }

    private int countBit(int num) {
        int count = 0;
        while (num != 0) {
            num = num & (num-1);
            count++;
        }
        return count;
    }
}
