package com.maomao.test.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 鸡蛋掉落
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 * 你的目标是确切地知道 F 的值是多少。
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 *
 * 示例 1：
 * 输入：K = 1, N = 2
 * 输出：2
 * 解释：
 * 鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
 * 否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
 * 如果它没碎，那么我们肯定知道 F = 2 。
 * 因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
 *
 * 示例 2：
 * 输入：K = 2, N = 6
 * 输出：3
 *
 * 示例 3：
 * 输入：K = 3, N = 14
 * 输出：4
 *
 * @author huida
 * @date 2020/5/21
 */
public class SuperEggDrop {
    Map<String, Integer> map = new HashMap<>();
    public int superEggDrop(int K, int N) {
        return recursive(K, N);
    }

    public int recursive(int K, int N) {
        if (N == 0 || N == 1 || K == 1) {
            return N;
        }
        //避免重复计算
        if (map.containsKey(K + "-" + N)) {
            return map.get(K + "-" + N);
        }
        int min = N;
        //遍历，从1层开始
        for (int i = 1; i <= N; i++) {
            //鸡蛋没碎和鸡蛋碎了，两种情况取最大值，保证最坏情况下
            int tMin = Math.max(recursive(K - 1, i - 1), recursive(K, N - i));
            min = Math.min(min, 1 + tMin);
        }
        map.put(K + "-" + N, min);
        return min;
    }

    /**
     * dp 数组的定义：dp[k][m] = n 表示，当前有 k 个鸡蛋，可以尝试扔 m 次鸡蛋，
     * 这个条件下最坏情况下最多能确切测试一栋 n 层的楼
     *
     * 1、无论你在哪层楼扔鸡蛋，鸡蛋只可能摔碎或者没摔碎，碎了的话就测楼下，没碎的话就测楼上。
     * 2、无论你上楼还是下楼，总的楼层数 = 楼上的楼层数 + 楼下的楼层数 + 1（当前这层楼）。
     * 根据这个特点，可以写出下面的状态转移方程：
     * dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1
     *
     * @param K
     * @param N
     * @return
     */
    int superEggDropII(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        // base case:
        // dp[0][..] = 0
        // dp[..][0] = 0
        for (int m = 1; m <= N; m++) {
            for (int k = 1; k <= K; k++) {
                dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1;
                //找到返回
                if (dp[k][m] >= N) {
                    return m;
                }
            }
        }
        return N;
    }
}
