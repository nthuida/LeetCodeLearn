package com.maomao.test.array;

/**
 *打家劫舍
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * @Author huida.mao
 * @Date 2019/10/29
 */
public class Rob {

    /**
     * 标签：动态规划
     * 动态规划方程：dp[n] = MAX( dp[n-1], dp[n-2] + num )
     * 由于不可以在相邻的房屋闯入，所以在当前位置 n 房屋可盗窃的最大值，要么就是 n-1 房屋可盗窃的最大值，
     * 要么就是 n-2 房屋可盗窃的最大值加上当前房屋的值，二者之间取最大值
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len + 1];
        //打劫到第0家
        dp[0] = 0;
        //打劫到第1家
        dp[1] = nums[0];
        for (int i = 2; i <= len; i++) {
            //重要的状态转移方程
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[len];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(new Rob().rob(nums));
    }
}
