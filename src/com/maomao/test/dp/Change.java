package com.maomao.test.dp;

/**
 * 零钱兑换II
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * 假设每一种面额的硬币有无限个。 
 * 题目数据保证结果符合 32 位带符号整数。
 *
 * 示例 1：
 * 输入：amount = 5, coins = [1, 2, 5]
 * 输出：4
 * 解释：有四种方式可以凑成总金额：
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 *
 * 示例 2：
 * 输入：amount = 3, coins = [2]
 * 输出：0
 * 解释：只用面额 2 的硬币不能凑成总金额 3 。
 *
 * 示例 3：
 * 输入：amount = 10, coins = [10]
 * 输出：1
 *
 * @author: huida
 * @date: 2021/12/9
 **/
public class Change {

    /**
     * 动态规划
     * 定义状态：dp[i]表示可以凑成总金额i的硬币组合数
     * 状态转移方程：dp[i] += dp[i−coin[j]]
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        //金额0时只有1种组合
        dp[0] = 1;
        //先遍历硬币，再遍历金额，保证求的是组合数
        for (int coin : coins) {
            for (int j = 1; j <= amount; j++) {
                if(j-coin >= 0) {
                    dp[j] += dp[j - coin];
                }
            }
        }

        return dp[amount];
    }

    /**
     * 完全背包
     * 状态定义：dp[i][j]表示前i个硬币，能够凑成总金额为j的组合数
     * 状态转移方程：dp[i][j] = dp[i−1][j] + dp[i][j−coins[i]]
     * @param amount
     * @param coins
     * @return
     */
    public int change1(int amount, int[] coins) {
        int len = coins.length;
        int[][] dp = new int[len+1][amount+1];
        // base case
        for (int i = 1; i <= len; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - coins[i-1] >= 0){
                    dp[i][j] += dp[i][j - coins[i-1]];
                }
            }
        }
        return dp[len][amount];
    }

}