package com.maomao.test.array;

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
     * (i,j) 开区间只有三个数字的时候开始计算，储存每个小区间可以得到金币的最大值
     * 然后慢慢扩展到更大的区间，利用小区间里已经算好的数字来算更大的区间
     * 动态规划
     * @param nums
     * @return
     */
    public int maxCoins(int[] nums) {
        int n = nums.length;
        //加入头和尾1，方便计算
        int[] temp = new int[n+2];
        temp[0] = 1;
        temp[n+1] = 1;
        for (int i=0;i<n; i++ ) {
            temp[i+1] = nums[i];
        }
        int[][] dp = new int[n+2][n+2];
        //从小区间扩大到大区间
        for (int len=3; len<=n+2; len++) {
            //左开区间范围,最大n+2-len
            for (int left = 0; left<=n+2-len; left++) {
                int res = 0;
                //k为开区间(left, left+len-1)内的索引
                for (int k=left+1; k<left+len-1; k++) {
                    int leftVal = dp[left][k];
                    int rightVal = dp[k][left+len-1];
                    res = Math.max(res, leftVal + temp[left]*temp[k]*temp[left+len-1] + rightVal);
                }
                //保存值
                dp[left][left+len-1] = res;
            }
        }
        return dp[0][n+1];
    }
}
