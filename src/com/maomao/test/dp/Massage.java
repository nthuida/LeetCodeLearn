package com.maomao.test.dp;

/**
 * 按摩师
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，
 * 因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 *
 * 示例 1：
 * 输入： [1,2,3,1]
 * 输出： 4
 * 解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
 *
 * 示例 2：
 * 输入： [2,7,9,3,1]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
 *
 * @author huida
 * @date 2020/6/10
 */
public class Massage {

    /**
     *  定义状态：dp[i]表示第i号预约的总时长
     *  状态转移方程：dp[n] = MAX(dp[n-1], dp[n-2]+num)
     *  由于不可以在相邻的预约，所以在当前位置 n 预约最大值，要么就是 n-1 预约的最大值，
     *  要么就是 n-2 预约的最大值加上当前预约的值，二者之间取最大值
     * @param nums
     * @return
     */
    public int massage(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }
        return dp[len];
    }
}
