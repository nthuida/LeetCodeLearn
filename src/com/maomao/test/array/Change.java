package com.maomao.test.array;

/**
 * 零钱兑换
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
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        //金额0时只有1种组合
        dp[0] = 1;
        //先遍历硬币，在遍历金额，保证求的是组合数
        for (int coin : coins) {
            //遍历硬币
            for (int j = 1; j <= amount; j++) {
                //遍历金额
                if(j < coin) {
                    continue;
                }
                dp[j] += dp[j - coin];
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        int[] a = {1,2,5};
        System.out.println(new Change().change(5, a));
    }
}