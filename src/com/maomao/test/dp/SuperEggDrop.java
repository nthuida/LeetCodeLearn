package com.maomao.test.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 鸡蛋掉落
 * 你将获得 k 个鸡蛋，并可以使用一栋从 1 到 n  共有 n 层楼的建筑。
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 * 你知道存在楼层 f ，满足 0 <= f <= n 任何从高于 f 的楼层落下的鸡蛋都会碎，从 f 楼层或比它低的楼层落下的鸡蛋都不会破。
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 x 扔下（满足 1 <= x <= n）。
 * 你的目标是确切地知道 f 的值是多少。
 * 无论 f 的初始值如何，你确定 f 的值的最小移动次数是多少？
 *
 * 示例 1：
 * 输入：k = 1, n = 2
 * 输出：2
 * 解释：
 * 鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 f = 0 。
 * 否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 f = 1 。
 * 如果它没碎，那么我们肯定知道 f = 2 。
 * 因此，在最坏的情况下我们需要移动 2 次以确定 f 是多少。
 *
 * @author huida
 * @date 2020/5/21
 */
public class SuperEggDrop {
    Map<String, Integer> map = new HashMap<>();
    public int superEggDrop(int k, int n) {
        return recursive(k, n);
    }

    public int recursive(int k, int n) {
        //base case
        if (n == 1 || k == 1) {
            return n;
        }
        //避免重复计算
        if (map.containsKey(k + "-" + n)) {
            return map.get(k + "-" + n);
        }
        int min = n;
        //从1层开始遍历
        for (int i = 1; i <= n; i++) {
            //鸡蛋没碎和鸡蛋碎了，两种情况取最大值，保证最坏情况
            int tMin = Math.max(recursive(k - 1, i - 1), recursive(k, n - i));
            min = Math.min(min, 1 + tMin);
        }
        map.put(k + "-" + n, min);
        return min;
    }

    /**
     * 状态定义：dp[k][n] 表示k个鸡蛋，扔n次，最多可以测试的楼层数
     * 状态转移方程：dp[k][n] = dp[k][n - 1] + dp[k - 1][n - 1] + 1
     *  1、无论你在哪层楼扔鸡蛋，鸡蛋只可能摔碎或者没摔碎，碎了的话就测楼下，没碎的话就测楼上
     *  2、无论你上楼还是下楼，总的楼层数 = 楼上的楼层数 + 楼下的楼层数 + 1（当前这层楼)
     *
     * @param k
     * @param n
     * @return
     */
    int superEggDropII(int k, int n) {
        int[][] dp = new int[k+1][n+1];
        //先楼层数
        for (int j=1; j<=n; j++) {
            for (int i=1; i<=k; k++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j-1] + 1;
                //找到返回
                if (dp[i][j] >= n) {
                    return j;
                }
            }
        }
        return n;
    }
}
