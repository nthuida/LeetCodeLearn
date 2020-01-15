package com.maomao.test.digit;

/**
 * 有效的完全平方数
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 *
 * 说明：不要使用任何内置的库函数，如  sqrt。
 *
 * 示例 1：
 *
 * 输入：16
 * 输出：True
 * 示例 2：
 *
 * 输入：14
 * 输出：False

 * @Author huida.mao
 * @Date 2020/1/15
 */
public class IsPerfectSquare {

    /**
     * 超时
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        if (num ==1 ) {
            return true;
        }
        int mid = num /2;
        for (int i=0; i<=mid; i++) {
            if (num/i == i && num%i==0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 二分法
     * @param num
     * @return
     */
    public boolean isPerfectSquareI(int num) {
        if (num == 1 ) {
            return true;
        }
        long start = 2;
        long end = num /2;
        while (start <= end)  {
            long mid = start + (end - start) / 2;
            long sum = mid * mid;
            if (sum == num) {
                return true;
            } else if (sum < num) {
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new IsPerfectSquare().isPerfectSquareI(808201));
    }
}
