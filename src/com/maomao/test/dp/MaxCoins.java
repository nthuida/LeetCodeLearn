package com.maomao.test.dp;

import java.util.Map;

/**
 *  戳气球
 * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * 现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得 nums[left] * nums[i] * nums[right] 个硬币。 
 * 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
 *
 * 求所能获得硬币的最大数量。
 *
 * 说明:
 * 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 *
 * 示例:
 * 输入: [3,1,5,8]
 * 输出: 167
 * 解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 * coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 *
 * @author huida
 * @date 2020/8/28
 */
public class MaxCoins {

    /**
     * 动态规划
     * dp[i][j]，表示戳破气球i和气球j之间（开区间，不包括i和j）的所有气球，可以获得的最高分数
     * dp[i][j] = dp[i][k] + dp[k][j] + points[i]*points[k]*points[j]，k为最后一个戳破的气球
     * 状态转移方程，穷举i < k < j的所有气球k，选择得分最高的作为dp[i][j]
     * dp[i][j] = max(dp[i][j], dp[i][k] + dp[k][j] + points[i]*points[k]*points[j]) i<k<j
     *
     * 怎么穷举i和j
     * 关于「状态」的穷举，最重要的一点就是：状态转移所依赖的状态必须被提前计算出来。
     * dp[i][j] 所依赖的状态是 dp[i][k] 和 dp[k][j]，那么我们必须保证：
     * 在计算 dp[i][j] 时，dp[i][k] 和 dp[k][j] 已经被计算出来了
     *
     * dp[i][k] 在 dp[i][j] 的 左边
     *             dp[k][j] 在 dp[i][j] 的 下面
     *             遍历顺序  i 从下往上 j 从左往右
     *             --> --> -->     4   5   6
     *                 --> -->         2   3
     *                     -->             1
     *             j 从左往右 i 从下往上
     *             ↑   ↑   ↑       1   3   6
     *                 ↑   ↑           2   5
     *                     ↑               4
     * @param nums
     * @return
     */
    public int maxCoins(int[] nums) {
        int n = nums.length;
        //加入头和尾1的虚拟气球，方便计算
        int[] temp = new int[n+2];
        temp[0] = 1;
        temp[n+1] = 1;
        for (int i=0;i<n; i++ ) {
            temp[i+1] = nums[i];
        }
        //初始化为0
        int[][] dp = new int[n+2][n+2];
        //i从下往上遍历
        for (int i=n; i>=0; i--) {
            //j从左往右遍历
            for (int j = i+1; j<n+2; j++) {
                //穷举k,计算
                for (int k=i+1; k<j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + temp[i]*temp[k]*temp[j] + dp[k][j]);
                }

            }
        }
        return dp[0][n+1];
    }
}
