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
     * 动态规划
     * F(i)= min(F[i],F(i−coin[j])+1)  , F(i)为组成金额i所需最少的硬币数量,coin[j]为第j枚硬币的面值
     *
     * 对于这道题，以coins = [1, 2, 5], amount = 11为例
     * 我们要求组成11的最少硬币数，可以考虑组合中的最后一个硬币分别是1，2，5的情况，比如
     * 最后一个硬币是1的话，最少硬币数应该为【组成10的最少硬币数】+ 1枚（1块硬币）
     * 最后一个硬币是2的话，最少硬币数应该为【组成9的最少硬币数】+ 1枚（2块硬币）
     * 最后一个硬币是5的话，最少硬币数应该为【组成6的最少硬币数】+ 1枚（5块硬币）
     *
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
            for (int i=coin; i<amount+1; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        //值为amount+1说明不存在
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }

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
