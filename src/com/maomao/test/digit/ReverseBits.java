package com.maomao.test.digit;

/**
 * 颠倒二进制位
 * 颠倒给定的 32 位无符号整数的二进制位。
 *
 * 示例 1：
 * 输入: 00000010100101000001111010011100
 * 输出: 00111001011110000010100101000000
 * 解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
 *       因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
 *
 * @Author huida.mao
 * @Date 2019/10/29
 */
public class ReverseBits {
    /**
     * 二进制数右移32，把每一位加到结果上，再左移
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int result = 0;
        int i = 32;
        while (i-- > 0) {
            //左移一位
            result = result<<1;
            //最低位
            int low = n&1;
            //加上最低位
            result += low;
            //右移一位
            n = n>>1;
        }
        return result;
    }

}
