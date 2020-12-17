package com.maomao.test.array;

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
     *  以第i个元素结尾且和最大的连续子数组实际上，要么是以第i-1个元素结尾且和最大的连续子数组加上这个元素，要么是只包含第i个元素，即sum[i]
     * = max(sum[i-1] + a[i], a[i])。可以通过判断sum[i-1] + a[i]是否大于a[i]来做选择，而这实际上等价于判断sum[i-1]是否大于0
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
                cur = nums[i];
            }
            if (cur > maxSum) {
                maxSum = cur;
            }
        }
        return maxSum;
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
    public int maxProfit(int[] prices) {
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
    public int maxProfit1(int[] prices) {
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
    public int maxProfit2(int[] prices) {
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



    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(nums[0]);
        System.out.println(new MaxSubArray().maxSubArray(nums));
    }
}
