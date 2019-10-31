package com.maomao.test.digit;

/**
 * 2的幂
 * 示例 1:
 *
 * 输入: 1
 * 输出: true
 *
 * @Author huida.mao
 * @Date 2019/10/31
 */
public class IsPowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        //负数不是
        if (n <= 0) {
            return false;
        }
        if ((n&(n-1)) == 0) {
            return true;
        }  else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new IsPowerOfTwo().isPowerOfTwo(1));
    }
}
