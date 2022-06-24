package com.maomao.test.dp;

import java.util.Arrays;

/**
 * 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 *
 * 示例 2:
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *
 * @author huida
 * @date 2020/5/29
 */
public class CoinChange {

    /**
     * 完全背包
     * 定义状态
     * dp[i] 表示组成金额i所需最少的硬币数量
     * 状态转移方程
     * dp[i]= min(dp[i],dp[i−coin[j]]+1) coin[j]为第j枚硬币的面值
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        int max = amount +1;
        //初始化为最大值，不可能达到，最大amounts
        Arrays.fill(dp,max);
        //金额为0，组合为0
        dp[0] = 0;
        for (int coin: coins) {
            for (int i=coin; i<=amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        //值为amount+1说明不存在
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }

    /**
     * 硬币有顺序和没有顺序都可以
     * 外层for循环遍历物品，内层for遍历背包
     * 或者外层for遍历背包，内层for循环遍历物品都是可以的！
     * @param coins
     * @param amount
     * @return
     */
    public int coinChangeII(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        int max = amount +1;
        //初始化为最大值，不可能达到，最大amounts
        Arrays.fill(dp,max);
        //金额为0，组合为0
        dp[0] = 0;
        for (int i=1; i<=amount; i++) {
            for (int coin : coins) {
                if (i-coin>=0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        //值为amount+1说明不存在
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}
