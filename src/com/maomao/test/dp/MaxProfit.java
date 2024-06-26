package com.maomao.test.dp;

/**
 * 最佳买卖股票时机含冷冻期
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 *
 * 示例:
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 * @author huida
 * @date 2020/7/10
 */
public class MaxProfit {

    /**
     * 定义状态：dp[i][j] 第i天状态为j时的最大利润
     * j 取三个值：0表示持有；1表示不持有，不在冷冻期；2表示不持有，在冷冻期；
     *
     * 状态转移方程：
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1]-prices[i]);
     * 持有：前一天持有或者前一天不持有，不处于冷冻期，今天买入
     * dp[i][1] = max(dp[i-1][2], dp[i-1][1]);
     * 不持有，不在冷冻期：前一天卖出，冷冻期或者前一天也是非冷冻
     * dp[i][2] = dp[i-1][0] + prices[i];
     * 不持有，在冷冻期: 前一天持有，今天卖出
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][3];
        //第0天持有
        dp[0][0] = -prices[0];
        for (int i=1; i<n; i++) {
            //持有：前一天持有或者前一天不持有，不处于冷冻期，今天买入
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]-prices[i]);
            //不持有，不在冷冻期：前一天卖出，冷冻期或者前一天也是非冷冻
            dp[i][1] = Math.max(dp[i-1][2], dp[i-1][1]);
            //不持有，在冷冻期: 前一天持有，今天卖出
            dp[i][2] = dp[i-1][0] + prices[i];
        }

        //最后一天股票要卖出，收益才大
        return Math.max(dp[n-1][1], dp[n-1][2]);
    }

    /**
     * 买卖股票的最佳时机含手续费
     * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
     * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
     * 返回获得利润的最大值。
     * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
     *
     * 示例 1:
     * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
     * 输出: 8
     * 解释: 能够达到的最大利润:
     * 在此处买入 prices[0] = 1
     * 在此处卖出 prices[3] = 8
     * 在此处买入 prices[4] = 4
     * 在此处卖出 prices[5] = 9
     * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
     *
     * 定义状态：
     * dp[i][0]表示第 i天不持有可获得的最大利润
     * dp[i][1]表示第 i天持有可获得的最大利润
     *
     * 状态转移方程：
     * dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee)
     * 对于今天不持有，可以从两个状态转移过来：1. 昨天也不持有；2. 昨天持有，今天卖出
     * dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i])
     * 对于今天持有，可以从两个状态转移过来：1. 昨天也持有；2. 昨天不持有，今天买入
     *
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        //第0天持有
        dp[0][1] = -prices[0];
        for(int i=1; i<len; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[len-1][0];
    }


    /**
     * 买卖股票的最佳时机
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
     * 注意你不能在买入股票前卖出股票。
     *
     * 示例 1:
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
     *
     * 示例 2:
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     *
     * 贪心
     * 最大利润 = max(第i天的价格 - 前i天里最低的买入价格)
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        //保存第i天之前的最低买入价格
        int min = prices[0];
        int max = 0;
        for (int i=1; i<len; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                int profit = prices[i] - min;
                max = Math.max(max, profit);
            }
        }
        return max;
    }

    /**
     * 定义状态：dp[i][2]
     * dp[i][0]表示第i天不持有可获得的最大利润
     * dp[i][1]表示第i天持有可获得的最大利润
     * 状态转移方程：
     * dp[i][1] = max(dp[i - 1][1], -prices[i])
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     * @param prices
     * @return
     */
    public int maxProfit2II(int[] prices) {
        int len = prices.length;
        //0表示不持有, 1持有，获取的最大利润
        int[][] dp = new int[len][2];
        dp[0][1] = -prices[0];
        for (int i=1; i<len; i++) {
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
        }
        return dp[len-1][0];
    }

    /**
     * 买卖股票的最佳时机II
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * 示例 1:
     * 输入: [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     *
     * 贪心算法
     * 将题目抽象化成数学问题，如果在Excel里画折线图就很容易理解，其实就是算上升期的数据总和。
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        int maxPro = 0, tmp = 0;
        for (int i = 1; i < prices.length; ++i) {
            tmp = prices[i] - prices[i-1];
            if (tmp > 0) {
                maxPro += tmp;
            }
        }
        return maxPro;
    }

    /**
     * 定义状态：dp[i][2]
     * dp[i][0]表示第i天不持有可获得的最大利润
     * dp[i][1]表示第i天持有可获得的最大利润
     * 状态转移方程：
     * dp[i][1] = max(dp[i - 1][1], dp[i-1][0] - prices[i])
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     * @param prices
     * @return
     */
    public int maxProfit3II(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][1] = -prices[0];
        for (int i=1; i<len; i++) {
            //多次买卖，和只买卖一次的区别
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
        }
        return dp[len-1][0];
    }

    /**
     * 买卖股票的最佳时机 III
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * 示例 1:
     * 输入：prices = [3,3,5,0,0,3,1,4]
     * 输出：6
     * 解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
     * 随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
     *
     * 示例 2：
     * 输入：prices = [1,2,3,4,5]
     * 输出：4
     * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
     * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
     * 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     *
     * 定义状态：dp[i][j][k]代表 第i天交易了k次时的最大利润，其中j代表当天是否持有股票，0不持有，1持有
     * 以买入代表交易的次数
     * 状态转移方程：
     * dp[i][0][k] = max(dp[i-1][0][k], dp[i-1][1][k] + prices[i])
     * dp[i][1][k] = max(dp[i-1][1][k], dp[i-1][0][k-1] - prices[i])
     * @param prices
     * @return
     */
    public int maxProfitIII(int[] prices) {
        int n = prices.length;
        if (n <= 1)    {
            return 0;
        }
        int[][][] dp = new int[n][2][3];
        //初始化
        for(int i=0; i<=2; i++){
            dp[0][0][i] = 0;
            dp[0][1][i] = -prices[0];
        }

        for(int i=1; i<n; i++){
            for(int k=1; k<=2; k++){
                //不持有
                dp[i][0][k] = Math.max(dp[i-1][0][k], dp[i-1][1][k] + prices[i]);
                //持有
                dp[i][1][k] = Math.max(dp[i-1][1][k], dp[i-1][0][k-1] - prices[i]);
            }
        }
        return dp[n-1][0][2];
    }


    /**
     * 买卖股票的最佳时机 IV
     * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * 示例 1：
     * 输入：k = 2, prices = [2,4,1]
     * 输出：2
     * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
     *
     * 示例 2：
     * 输入：k = 2, prices = [3,2,6,5,0,3]
     * 输出：7
     * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
     * 随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
     *
     */

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1)    {
            return 0;
        }
        //因为一次交易至少涉及两天，所以如果k大于总天数的一半，就直接取天数一半即可，多余的交易次数是无意义的
        k = Math.min(k, n/2);

        //dp定义：dp[i][j][k]代表 第i天交易了k次时的最大利润，其中j代表当天是否持有股票，0不持有，1持有
        int[][][] dp = new int[n][2][k+1];
        for(int i=0; i<=k; i++){
            dp[0][0][i] = 0;
            dp[0][1][i] = -prices[0];
        }

        for(int i=1; i<n; i++){
            for(int j=1; j<=k; j++){
                dp[i][0][j] = Math.max(dp[i-1][0][j], dp[i-1][1][j] + prices[i]);
                dp[i][1][j] = Math.max(dp[i-1][1][j], dp[i-1][0][j-1] - prices[i]);
            }
        }
        return dp[n-1][0][k];
    }

}
