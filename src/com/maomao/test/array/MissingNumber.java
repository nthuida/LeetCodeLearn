package com.maomao.test.array;

/**
 * 缺失数字
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 1:
 *
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 *
 * @Author huida.mao
 * @Date 2019/11/2
 */
public class MissingNumber {

    /**
     * 先求正常n个序列的和，在减去数组的和，剩下的就是那个缺失的
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = 0;
        while (len!=0) {
            sum += len;
            len--;
        }
        for (Integer num : nums) {
            sum -= num;
        }
        return sum;
    }
}
