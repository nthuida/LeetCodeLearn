package com.maomao.test.array;

/**
 *  最佳买卖股票时机含冷冻期
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 * @author huida
 * @date 2020/7/10
 */
public class MaxProfit {

    /**
     * dp[i][j] 表示 [0, i] 区间内，在下标为 i 这一天后状态为 j 时的最大收益。
     *
     * 这里 j 取三个值：
     * 0 表示持股；
     * 1 表示不持股，不在冷冻期；
     * 2 表示不持股，在冷冻期；
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;

        int[][] dp = new int[n][3];
        //第0天持股，收益为负-prices[0]
        dp[0][0] = -prices[0];
        for (int i=1; i<n; i++) {
            //持股：前一天持股或者前一天不持股，不处于冷冻期
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]-prices[i]);
            //不持股，不在冷冻期：前一天卖出，冷冻期或者前一天也是非冷冻
            dp[i][1] = Math.max(dp[i-1][2], dp[i-1][1]);
            //不持股，在冷冻期:当天卖出
            dp[i][2] = dp[i-1][0] + prices[i];
        }

        //最后一天股票要卖出，收益才大
        return Math.max(dp[n-1][1], dp[n-1][2]);
    }
}
