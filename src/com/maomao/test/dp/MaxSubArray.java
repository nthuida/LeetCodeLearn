package com.maomao.test.dp;

/**
 * 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * @author Administrator
 * @date 2019/3/24
 */
public class MaxSubArray {

    /**
     * 动态规划
     * 定义状态：dp[i] 表示以i结尾的最大子数组和
     * 状态转移方程： dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
     * 初始值： dp[0] = nums[0]
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i=1; i<nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }

        return  max;
    }
}
