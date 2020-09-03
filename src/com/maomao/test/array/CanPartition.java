package com.maomao.test.array;

/**
 * 分割等和子集
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *  
 *
 * 示例 2:
 *
 * 输入: [1, 2, 3, 5]
 *
 * 输出: false
 *
 * 解释: 数组不能分割成两个元素和相等的子集.
 *
 * @author huida
 * @date 2020/9/3
 */
public class CanPartition {

    /**
     * 动态规划
     * 状态定义：dp[i][j]表示从数组的 [0, i] 这个子区间内挑选一些正整数，使得这些数的和恰好等于 j。
     * 不选择 nums[i]，如果在 [0, i - 1] 这个子区间内已经有一部分元素，使得它们的和为 j ，那么 dp[i][j] = true；
     * 选择 nums[i]，如果在 [0, i - 1] 这个子区间内就得找到一部分元素，使得它们的和为 j - nums[i]。
     * 状态转移方程 ： dp[i][j] = dp[i - 1][j] or dp[i - 1][j - nums[i]]
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //奇数肯定不满足
        if ((sum&1) == 1) {
            return false;
        }
        int target = sum/2;
        //行代表每个数，列代表数的和，因为有和为0，所以target+1列
        boolean[][] dp = new boolean[nums.length][target+1];

        //初始化第0行
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i=1; i<nums.length; i++) {
            for (int j=0; j<=target; j++) {
                //某一行的元素等于列的值，true
                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }

                if (nums[i] < j) {
                    //选和不选都可以，或
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                } else {
                    //不选第i个元素
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[nums.length-1][target];
    }
}
