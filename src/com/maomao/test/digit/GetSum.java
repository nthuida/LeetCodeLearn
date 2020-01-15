package com.maomao.test.digit;

/**
 * 两整数之和
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 *
 * 示例 1:
 *
 * 输入: a = 1, b = 2
 * 输出: 3
 * 示例 2:
 *
 * 输入: a = -2, b = 3
 * 输出: 1

 * @Author huida.mao
 * @Date 2020/1/15
 */
public class GetSum {
    /**
     * a + b 的问题拆分为 (a 和 b 的无进位结果) + (a 和 b 的进位结果)
     * 无进位加法使用异或运算计算得出
     * 进位结果使用与运算和移位运算计算得出
     * 循环此过程，直到进位为 0
     *
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        while (b != 0) {
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }
}
