package com.maomao.test.digit;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 *
 *  示例 2:
 * 输入: 2.10000, 3
 * 输出: 9.26100
 *
 * 示例 3:
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。
 * @author Administrator
 * @date 2020/5/8
 */
public class MyPow {

    /**
     * 超时
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        boolean flag = false;
        double sum = 1;
        if (n < 0) {
            flag = true;
            n = -n;
        }
        for (int i=1; i<=n; i++) {
            sum *= x;
        }
        if (flag) {
            return 1/sum;
        } else {
            return sum;
        }
    }

    /**
     * 快速幂+ 迭代
     * 判断n的奇偶性 例： x^8 按照 x->x^2->x^4->x^8,奇数的话，在额外乘x;
     * @param x
     * @param n
     * @return
     */
    public double myPow1(double x, int n) {
        return n >= 0 ? quickMul(x, n) : 1.0 / quickMul(x, -n);
    }

    public double quickMul(double x, int n) {
        if (n == 0 ) {
            return 1.0;
        }
        double y = quickMul(x, n/ 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

}
