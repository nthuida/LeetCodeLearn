package com.maomao.test.digit;

/**
 * 阶乘后的零
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 *
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 *
 * @Author huida.mao
 * @Date 2020/1/7
 */
public class TrailingZeroes {
    /**
     * 求包含5的个数
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int count = 0;
        for (int i=1; i<=n; i++) {
            int temp = i;
            while (temp > 0) {
                if (temp % 5 ==0) {
                    count++;
                } else {
                    temp = temp/5;
                }
            }
        }
        return count;
    }

    /**
     * 每隔 5 个数出现一个 5，所以计算出现了多少个 5，我们只需要用 n/5 就可以算出
     * 最终 5 的个数就是 n / 5 + n / 25 + n / 125 ...
     * @param n
     * @return
     */
    public int trailingZeroes2(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }
}
