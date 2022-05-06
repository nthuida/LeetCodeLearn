package com.maomao.test.digit;

/**
 *  x 的平方根
 *  实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 *
 * @Author huida.mao
 * @Date 2020/1/7
 */
public class MySqrt {

    /**
     * 二分查找，确定开始和结束的范围
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int low = 1;
        //查找的范围，自己的一半
        int high = x/2 + 1;
        while (low <= high) {
            //取右边的中位数
            int mid = low + (high - low) / 2;
            //防止越界
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                return mid;
            }
            if (mid > x/mid) {
                high = mid-1;
            } else {
                low = mid +1;
            }

        }

        return -1;
    }

}
