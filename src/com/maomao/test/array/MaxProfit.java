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
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
     *
     * 示例 2:
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        //o(n*n)
        if (prices == null || prices.length <1) {
            return 0;
        }
        int len = prices.length;
        int max = 0;
        for (int i=0; i<len; i++) {
            for (int j=i+1; j<len; j++) {
                if (prices[j] - prices[i] > max) {
                    max = prices[j] - prices[i];
                }
            }
        }
        return max;
    }

    /**
     * 找到最小值和最大值
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        //o(n)
        if (prices == null || prices.length <1) {
            return 0;
        }
        int len = prices.length;
        int min = prices[0];
        int max = 0;
        for (int i=1; i<len; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                if ((prices[i] - min) > max) {
                    max = prices[i] - min;
                }
            }
        }
        return max;
    }

    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * 示例 1:
     * 输入: [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     *
     *  示例 2:
     * 输入: [1,2,3,4,5]
     * 输出: 4
     * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     *
     *      贪心算法，总是做出在当前看来是最好的选择，不从整体最优上加以考虑，也就是说，只关心当前最优解
     *      将题目抽象化成数学问题，如果在Excel里画折线图就很容易理解，其实就是算上升期的数据总和。
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
     * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
     * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
     * 返回获得利润的最大值。
     *
     * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
     *
     * 示例 1:
     *
     * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
     * 输出: 8
     * 解释: 能够达到的最大利润:
     * 在此处买入 prices[0] = 1
     * 在此处卖出 prices[3] = 8
     * 在此处买入 prices[4] = 4
     * 在此处卖出 prices[5] = 9
     * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
     *
     * 动态规划
     * 定义二维数组 dp[n][2]：
     *
     * dp[i][0]表示第 i天不持有可获得的最大利润；
     * dp[i][1]表示第 i天持有可获得的最大利润。
     * 定义状态转移方程：
     *
     * 不持有：dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee)
     * 对于今天不持有，可以从两个状态转移过来：1. 昨天也不持有；2. 昨天持有，今天卖出。两者取较大值。
     *
     * 持有：dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i])
     * 对于今天持有，可以从两个状态转移过来：1. 昨天也持有；2. 昨天不持有，今天买入。两者取较大值。
     *
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        //初始化 第0天不持有
        dp[0][0] = 0;
        //第0天持有
        dp[0][1] = -prices[0];
        for(int i=1; i<len; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[len-1][0];
    }


    /**
     * 买卖股票的最佳时机 IV
     * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * 示例 1：
     *
     * 输入：k = 2, prices = [2,4,1]
     * 输出：2
     * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
     *
     * 示例 2：
     *
     * 输入：k = 2, prices = [3,2,6,5,0,3]
     * 输出：7
     * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
     *      随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
     *
     *
     * 初始状态为 dp[0[0]
     * 第一次买dp[0][1]、第一次卖dp[1][0]
     * 第二次买dp[1][1]、第二次卖dp[2][0]
     * 第k次买dp[k-1][1]、第k次卖dp[k][0]
     *
     * DP公式如下：
     * dp[j-1][1] = max(dp[j-1][1],dp[j-1][0]-prices[i])
     * dp[j][0] = max(dp[j][0],dp[j-1][1]+prices[i])
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k == 0 || len <2) {
            return 0;
        }
        if (k>= len/2) {
            //不收交易次数限制
            return maxProfit3(prices);
        }
        int[][] dp = new int[k+1][2];
        //初始化
        for(int i=0;i<=k;++i) {
            dp[i][0] = 0;
            dp[i][1] = -prices[0];
        }

        for (int i=0; i<len ; i++) {
            for (int j=1; j<=k; j++) {
                //第k次买入
                 dp[j-1][1] = Math.max(dp[j-1][1],dp[j-1][0] - prices[i]) ;
                //第k次卖出
                 dp[j][0] = Math.max(dp[j][0],dp[j-1][1] + prices[i]);
            }
        }

        return dp[k][0];
    }

}
