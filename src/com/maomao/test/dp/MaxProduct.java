package com.maomao.test.dp;

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

    /**
     * 动态规划
     * 定义状态：
     * dpMax[i]表示以i结尾的子数组乘积的最大值
     * dpMin[i]表示以i结尾的子数组乘积的最小值
     * 状态转移方程：
     * dpMax[i] = Math.max(Math.max(dpMax[i-1] * nums[i], nums[i]), dpMin[i-1] * nums[i]);
     * dpMin[i] = Math.min(Math.min(dpMin[i-1] * nums[i], nums[i]), dpMax[i-1] * nums[i]);
     * 因为有正负，最大值可以由最小值乘以负数得到，同样最小值可以由最大值乘以负数得到；
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        //以i结尾的子数组乘积的最大值
        int[] dpMax = new int[nums.length];
        //最小值
        int[] dpMin = new int[nums.length];
        int max = nums[0];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            //当前最大值 也有可能是前一个最小值乘以负数得到：dpMin[i-1] * nums[i]
            dpMax[i] = Math.max(Math.max(dpMax[i-1] * nums[i], nums[i]), dpMin[i-1] * nums[i]);
            //当前最小值，也有可能是前一个最大值乘以负数得到：dpMax[i-1] * nums[i]
            dpMin[i] = Math.min(Math.min(dpMin[i-1] * nums[i], nums[i]), dpMax[i-1] * nums[i]);

            max = Math.max(max, dpMax[i]);
        }
        return max;
    }
}
