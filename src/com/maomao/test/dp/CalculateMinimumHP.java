package com.maomao.test.dp;

/**
 * 地下城游戏
 * 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
 * 为了尽快到达公主，骑士决定每次只向右或向下移动一步。
 * 编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。
 * 例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，则骑士的初始健康点数至少为 7。
 *
 * -2 (K)   -3	   3
 * -5	   -10	   1
 * 10	   30	  -5 (P)
 *
 * @author: huida
 * @date: 2021/12/13
 **/
public class CalculateMinimumHP {

    /**
     * 状态定义：dp[i][j] 表示从坐标 (i,j) 到终点所需的最小初始值
     * 状态转移方程：dp[i][j] = max(min(dp[i+1][j], dp[i][j+1]) − dungeon(i,j), 1)
     * 当前房间的健康点数为正，骑士只需要1个健康点数
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] dp = new int[row][col];
        //最右下角的值
        dp[row-1][col-1] = Math.max(-dungeon[row-1][col-1] + 1, 1);
        //最右边列
        for(int i=row-2; i>=0; i--) {
            dp[i][col-1] = Math.max(dp[i+1][col-1] - dungeon[i][col-1], 1);
        }
        //最下边行
        for(int j=col-2; j>=0; j--) {
            dp[row-1][j] = Math.max(dp[row-1][j+1] - dungeon[row-1][j], 1);
        }
        //从下往上，从右往左计算
        for(int i=row-2; i>=0; i--) {
            for(int j=col-2; j>=0; j--) {
                int min = Math.min(dp[i+1][j], dp[i][j+1]);
                dp[i][j] = Math.max(min - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }
}
