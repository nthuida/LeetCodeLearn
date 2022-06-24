package com.maomao.test.dp;

/**
 * 分割等和子集
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 注意:
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 *
 * 示例 1:
 * 输入: [1, 5, 11, 5]
 * 输出: true
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *  
 * 示例 2:
 * 输入: [1, 2, 3, 5]
 * 输出: false
 * 解释: 数组不能分割成两个元素和相等的子集.
 *
 * @author huida
 * @date 2020/9/3
 */
public class CanPartition {

    /**
     * 动态规划  0-1背包问题
     * 状态定义：dp[i][j]表示从[0, i]区间内挑选一些正整数，使得这些数的和等于j
     * 状态转移方程 ： dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]]
     * 不选择 nums[i]，取决于上一个状态dp[i-1][j]；
     * 选择 nums[i]，取决与dp[i-1][j-nums[i]];
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //奇数不满足
        if (sum%2 == 1) {
            return false;
        }
        int target = sum/2;
        int len = nums.length;
        //行：物品，列：容量
        boolean[][] dp = new boolean[len][target+1];
        // 因为背包没有空间的时候，就相当于装满了
        for (int i=0; i<len; i++) {
            dp[i][0] = true;
        }
        //第0行初始化，target和num[0]相等的那列为true
        if (nums[0] == target) {
            dp[0][target] = true;
        }
        for (int i=1; i<len; i++) {
            for (int j=1; j<=target; j++) {
                if (nums[i] > j) {
                    //不选第i个元素
                    dp[i][j] = dp[i-1][j];
                } else  {
                    //选和不选都可以
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i]];
                }
                System.out.println();
            }
        }
        return dp[len-1][target];
    }

    public boolean canPartitionII(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //奇数不满足
        if (sum%2 == 1) {
            return false;
        }
        int target = sum/2;
        //dp[i]表示能否装满容量i的背包
        boolean[] dp = new boolean[target+1];
        //初始化
        dp[0] = true;
        for (int num : nums) {
            //倒序遍历，保证物品只被添加一次
            for (int j=target; j-num>=0; j--) {
                dp[j] = dp[j] || dp[j - num];
                System.out.println("dp[" + j + "]=" + dp[j]);
            }
        }
        return dp[target];
    }

}
