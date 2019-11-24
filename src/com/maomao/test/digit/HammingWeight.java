package com.maomao.test.digit;

/**
 * 位1的个数
 *
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 *
 * 示例 1：
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 *
 * @Author huida.mao
 * @Date 2019/10/29
 */
public class HammingWeight {

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if ((n&1) == 1) {
                count++;
            }
            n = n>>1;
        }
        return count;
    }

    /**
     * 将 n 和 n−1 与运算总是能把 n 中最低位的 1 变成 0 ，并保持其他位不变
     * @param n
     * @return
     */
    public int hammingWeigth1(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;

    }

    /**
     * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
     *
     * 给出两个整数 x 和 y，计算它们之间的汉明距离。
     *
     * 注意：
     * 0 ≤ x, y < 231.
     *
     * 示例:
     *
     * 输入: x = 1, y = 4
     *
     * 输出: 2
     *
     * 解释:
     * 1   (0 0 0 1)
     * 4   (0 1 0 0)
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        int result = x^y;
        int sum = 0;
        while (result != 0) {
            sum++;
            result &= (result - 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new HammingWeight().hammingWeight(3));
    }
}
