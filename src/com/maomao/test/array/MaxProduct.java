package com.maomao.test.array;

/**
 * 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * 示例 1:
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 *
 * 示例 2:
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * @author huida
 * @date 2020/5/18
 */
public class MaxProduct {

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++) {
            int j = i;
            int sum = 1;
            while (j < nums.length) {
                sum *= nums[j];
                if (sum > max) {
                    max = sum;
                }
                j++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {-2,0,-1};
        System.out.println(new MaxProduct().maxProduct(a));
    }
}
