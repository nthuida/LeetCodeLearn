package com.maomao.test.digit;

import java.util.ArrayList;

/**
 * 圆圈中最后剩下的数字
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。
 * 求出这个圆圈里剩下的最后一个数字。
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，
 * 则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 * 示例 1：
 * 输入: n = 5, m = 3
 * 输出: 3
 *
 * 示例 2：
 * 输入: n = 10, m = 17
 * 输出: 2
 *
 * @author huida
 * @date 2020/6/11
 */
public class LastRemaining {

    /**
     * 约瑟夫环问题
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            //删除元素的位置，下一个元素的开始idx + m - 1，由于把当前位置的数字删除了，所以后面的前移一位，-1
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);

    }

    /**
     * 公式法
     * 反推 (当前index + m) % 上一轮剩余数字的个数
     * @param n
     * @param m
     * @return
     */
    public int lastRemainingII(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;

    }
}
