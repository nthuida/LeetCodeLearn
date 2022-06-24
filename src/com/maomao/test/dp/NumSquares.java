package com.maomao.test.dp;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 完全平方数
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
 * 你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 *
 * 示例 2:
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 *
 * @author huida
 * @date 2020/8/28
 */
public class NumSquares {

    /**
     * 动态规划  完全背包
     * 定义状态：dp[i] 表示当前i需要的最少平方数个数
     * 动态转移方程：dp[i] = MIN(dp[i], dp[i - j * j] + 1)
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i=1; i<=n; i++) {
            //默认最大值
            dp[i] = i;
            for (int j=1; j*j<=i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j*j] +1);
            }
        }
        return dp[n];
    }

    /**
     * BFS
     * 一层层的减去一个平方数，直到某层为0，当前层数就是所求的最小值
     * @param n
     * @return
     */
    public int numSquaresII(int n) {
        Queue<Integer> queue = new LinkedList<>();
        //保存计算过的结果
        Set<Integer> set = new HashSet<>();
        queue.offer(n);
        set.add(n);
        //当前层数
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int cur = queue.poll();
                //一次减去一个平方数
                for (int j=1; j*j<=cur; j++) {
                    int num = cur - j*j;
                    //找到结果
                    if (num == 0) {
                        return level;
                    }
                    if (!set.contains(num)) {
                        set.add(num);
                        queue.offer(num);
                    }
                }
            }
        }
        return level;
    }
}
