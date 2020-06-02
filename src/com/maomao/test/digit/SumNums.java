package com.maomao.test.digit;

/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * 示例 1：
 * 输入: n = 3
 * 输出: 6
 *
 * @author huida
 * @date 2020/6/2
 */
public class SumNums {
    int res = 0;

    /**
     *逻辑运算的短路效应
     * @param n
     * @return
     */
    public int sumNums(int n) {
        boolean flag = n>1 && sumNums(n-1)>1;
        res += n;
        return res;
    }
}
