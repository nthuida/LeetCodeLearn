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
     *  动态规划o(n)
     *  sum[i]表示第i个元素结尾的最大的连续子数组，
     *  实际上要么是以第i-1个元素结尾且和最大的连续子数组加上这个元素，要么是只包含第i个元素，
     *  即sum[i] = max(sum[i-1] + a[i], a[i])。
     *  可以通过判断sum[i-1] + a[i]是否大于a[i]来做选择，而这实际上等价于判断sum[i-1]是否大于0
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int maxSum = nums[0];
        //目前的最大值
        int cur = nums[0];
        for (int i=1; i<len; i++) {
            if (cur > 0) {
                cur += nums[i];
            } else {
                //遇到负的重新计算
                cur = nums[i];
            }
            if (cur > maxSum) {
                maxSum = cur;
            }
        }
        return maxSum;
    }

    /**
     * 动态规划求解
     * dp[i] 表示以i结尾的最大子数组和
     * dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
     * @param nums
     * @return
     */
    public int maxSubArrayII(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int i : dp) {
            max = Math.max(max, i);
        }
        return  max;
    }
}
