package com.maomao.test.dp;

import java.util.Arrays;

/**
 * 最长连续递增序列
 * 给定一个未经排序的整数数组，找到最长且连续递增的子序列，并返回该序列的长度。
 *
 * 示例 1：
 * 输入：nums = [1,3,5,4,7]
 * 输出：3
 * 解释：最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
 *
 * @author: huida
 * @date: 2022/6/28
 **/
public class FindLengthOfLCIS {

    /**
     * 状态定义：dp[i]表示以i结尾的最长连续递增序列的长度
     * 状态转移方程：dp[i] = dp[i-1] + 1
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {
        int res = 1;
        int[] dp = new int[nums.length];
        //初始化为1
        Arrays.fill(dp, 1);
        for (int i=1; i<nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                dp[i] = dp[i-1] + 1;
                //更新结果
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}
