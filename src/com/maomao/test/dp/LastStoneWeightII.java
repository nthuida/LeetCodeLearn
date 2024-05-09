package com.maomao.test.dp;

/**
 * 最后一块石头的重量
 * 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
 *
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 *
 * 示例 1：
 *
 * 输入：stones = [2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
 * 组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
 * 组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
 * 组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
 *
 * @auther: huida
 * @date: 2024/5/7
 */
public class LastStoneWeightII {

    /**
     * 转为01背包问题，把石头尽量分为重量相等的两堆 target = sum/2;
     * 一个：dp[target]
     * 一个：sum - dp[target]
     * 相减：sum - 2*dp[target]
     * @param stones
     * @return
     */
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int i: stones) {
            sum += i;
        }
        int target = sum/2;
        int[] dp = new int[target+1];

        for (int stone : stones) {
            for (int j=target; j>=stone; j--) {
                dp[j] = Math.max(dp[j], dp[j-stone] + stone);
            }
        }
        return sum - 2*dp[target];
    }
}
