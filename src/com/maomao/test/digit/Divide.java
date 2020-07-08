package com.maomao.test.digit;

/**
 * 两数相除
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 * 示例 1:
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 *
 * 示例 2:
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 *
 * @author huida
 * @date 2020/7/8
 */
public class Divide {

    /**
     * 将除法转化为减法，循环相减
     * 当t=Integer.MIN_VALUE时（t取相反数依旧是它本身）此时可能存在越界问题，因此都用负数进行计算
     *
     * dividend每次减去2^n个divisor（尽可能多），同时reslut每次加2^n
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        //特殊
        if (dividend==Integer.MIN_VALUE&&divisor==-1) {
            return Integer.MAX_VALUE;
        }
        int res = 0;
        //结果标志位
        boolean flag = (dividend>0 && divisor >0) || (dividend<0 && divisor<0);
        dividend = - Math.abs(dividend);
        divisor = - Math.abs(divisor);
        while (dividend <= divisor) {
            int temp = divisor;
            int sum = 1;
            while (dividend-temp <= temp) {
                temp = temp<<1;
                sum = sum<<1;
            }
            res += sum;
            dividend -= temp;
        }
        return flag ? res : -res;
    }
}
