package com.maomao.test.array;

/**
 * 使用最小花费爬楼梯
 *
 * 示例 1:
 * 输入: cost = [10, 15, 20]
 * 输出: 15
 * 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 *
 *示例 2:
 *
 * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出: 6
 * 解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
 *
 * @author: huida
 * @date: 2020/12/21
 **/
public class MinCostClimbingStairs {

    /**
     * 动态规划
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len];
        //走一步
        dp[0] = cost[0];
        //走两步
        dp[1] = cost[1];
        for (int i=2; i<len; i++) {
            dp[i] = Math.min(dp[i-1] + cost[i], dp[i-2]+cost[i]);
        }

        return Math.min(dp[len-2], dp[len-1]);

    }

    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(cost));
    }
}
