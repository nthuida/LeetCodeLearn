package com.maomao.test.array;

/**
 * 目标和
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，
 * 你都可以从 + 或 -中选择一个符号添加在前面。
 *
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 * 示例：
 *
 * 输入：nums: [1, 1, 1, 1, 1], S: 3
 * 输出：5
 * 解释：
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * 一共有5种方法让最终目标和为3。
 *
 * @author huida
 * @date 2020/9/2
 */
public class FindTargetSumWays {

    /**
     *  状态转移方程： dp[ i ][ j ] = dp[ i - 1 ][ j - nums[ i ] ] + dp[ i - 1 ][ j + nums[ i ] ]
     *  dp[ i ][ j ]定义为从数组nums中 0 - i 的元素进行加减可以得到 j 的方法数量
     * 可以理解为nums[i]这个元素可以执行加，还可以执行减，那么dp[i][j]的结果值就是加/减之后对应位置的和。
     *
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int a : nums) {
            sum += a;
        }
        if (Math.abs(S) > Math.abs(sum)) {
            return 0;
        }
        //列的长度，+/-/0
        int col = 2 * sum + 1;
        int[][] dp = new int[nums.length][col];

        //初始化第0行和等于自己的那两列
        if (nums[0] == 0) {
            //加和减，算2次
            dp[0][sum + nums[0]] = 2;
        } else {
            dp[0][sum - nums[0]] = 1;
            dp[0][sum + nums[0]] = 1;
        }

        for (int i=1; i< nums.length; i++) {
            for (int j=0; j<col; j++) {
                //边界
                int l = (j - nums[i]) >= 0 ? j - nums[i] : 0;
                int r = (j + nums[i]) < col ? j + nums[i] : 0;

                dp[i][j] = dp[i - 1][l] + dp[i - 1][r];
            }
        }

        return dp[nums.length-1][sum + S];
    }
}
