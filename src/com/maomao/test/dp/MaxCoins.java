package com.maomao.test.dp;

/**
 * 戳气球
 * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * 现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得 nums[left] * nums[i] * nums[right] 个硬币。 
 * 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
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
     * 状态定义：dp[i][j]，表示戳破气球i和气球j之间（开区间，不包括i和j）的所有气球，可以获得的分数
     * 状态转移方程：
     * dp[i][j] = max(dp[i][j], dp[i][k] + dp[k][j] + points[i]*points[k]*points[j]) i<k<j，k为最后一个戳破的气球
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
        int[][] dp = new int[n+2][n+2];
        //结果dp[0][n+1]在右上角，i从下往上遍历
        for (int i=n; i>=0; i--) {
            //j从左往右遍历
            for (int j = i+1; j<n+2; j++) {
                //穷举k
                for (int k=i+1; k<j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + temp[i]*temp[k]*temp[j] + dp[k][j]);
                }

            }
        }
        return dp[0][n+1];
    }
}
