package com.maomao.test.dp;

/**
 * 使用最小花费爬楼梯
 *
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。
 * 一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * 请你计算并返回达到楼梯顶部的最低花费。
 *
 * 示例 1：
 * 输入：cost = [10,15,20]
 * 输出：15
 * 解释：你将从下标为 1 的台阶开始。
 * 支付 15 ，向上爬两个台阶，到达楼梯顶部。
 * 总花费为 15 。
 *
 * 示例 2：
 * 输入：cost = [1,100,1,1,1,100,1,1,100,1]
 * 输出：6
 * 解释：你将从下标为 0 的台阶开始。
 * 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
 * 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
 * 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
 * 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
 * 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
 * 支付 1 ，向上爬一个台阶，到达楼梯顶部。
 * 总花费为 6 。

 *
 * @author: huida
 * @date: 2020/12/21
 **/
public class MinCostClimbingStairs {

    /**
     * 动态规划
     * 定义状态：dp[i]表示到达第i个台阶的最低花费
     * 状态转移方程：dp[i] = min(dp[i-1], d[i-2]) + cost[i]
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len];
        //初始化
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i=2; i<len; i++) {
            dp[i] = Math.min(dp[i-1] + cost[i], dp[i-2]+cost[i]);
        }
        //可以爬一个或两个台阶
        return Math.min(dp[len-2], dp[len-1]);
    }

    public int minCostClimbingStairsII(int[] cost) {
        int len = cost.length;
        //dp[i]表示到达第i个台阶的最低花费
        int[] dp = new int[len+1];
        //下标为 0 或下标为 1 的台阶不付钱
        dp[0] = 0;
        dp[1] = 0;
        for (int i=2; i<=len; i++) {
            dp[i] = Math.min(dp[i-2] + cost[i-2], dp[i-1] + cost[i-1]);
        }
        return dp[len];

    }

}
