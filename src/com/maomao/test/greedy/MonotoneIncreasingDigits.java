package com.maomao.test.greedy;

/**
 * 单调递增的数字
 * 当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。
 * 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。
 *
 * 示例 1:
 * 输入: n = 10
 * 输出: 9
 *
 * 示例 2:
 * 输入: n = 1234
 * 输出: 1234
 *
 *  @author huida
 *  @date 2020/5/15
 */
public class MonotoneIncreasingDigits {

    /**
     * 贪心算法，高位尽可能不变，如果不满足n[i]<n[i+1]，则n[i]-1,后面的都设为9
     * n    = 2333332
     * res  = 2299999
     * @param n
     * @return
     */
    public int monotoneIncreasingDigits(int n) {
        char[] chars = (n + "").toCharArray();
        //赋值9的开始位
        int start = chars.length;
        //从后往前遍历，
        for (int i=chars.length-1; i>0; i--) {
            if (chars[i-1] > chars[i]) {
                start = i;
                chars[i-1] -=1;
            }

        }
        //赋值为9
        for (int j=start; j<chars.length; j++) {
            chars[j] = '9';
        }
        return Integer.parseInt(new String(chars));
    }

}
