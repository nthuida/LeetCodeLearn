package com.maomao.test.dp;

/**
 * 组合总和IV
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。
 * 请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 * 题目数据保证答案符合 32 位整数范围。
 *
 * 示例 1：
 * 输入：nums = [1,2,3], target = 4
 * 输出：7
 * 解释：
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 请注意，顺序不同的序列被视作不同的组合。
 *
 * @author: huida
 * @date: 2022/6/22
 **/
public class CombinationSum {

    /**
     * 完全背包 有顺序
     * 定义状态：dp[i] 表示目标整数为i的组合数
     * 状态转移方程：dp[i] += dp[i−nums[j]]
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        //初始化
        dp[0] = 1;
        for (int i=1; i<=target; i++) {
            for(int num : nums) {
                if (i-num>=0) {
                    dp[i] += dp[i-num];
                    System.out.println("i=" + i + " dp[" + i + "] " + "+= dp[" + (i-num) + "]");
                }
            }
        }
        return dp[target];
    }

}
