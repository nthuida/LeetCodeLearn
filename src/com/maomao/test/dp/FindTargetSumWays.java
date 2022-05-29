package com.maomao.test.dp;

/**
 * 目标和
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，
 * 你都可以从 + 或 -中选择一个符号添加在前面。
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
     * 每个数字都有两种状态：被进行“+”， 或者被进行“-”，因此可以将数组分成A和B两个部分：
     * A部分的数字全部进行“+”操作，B部分的数字全部进行“-”操作。
     *
     * 设数组的和为sum，A部分的和为sumA，B部分的和为sumB
     * 可以得出： sumA + sumB = sum
     * 同时有： sumA - sumB = target
     * 2sumB = sum - target 即 sumB = (sum - target) / 2
     * 原问题可以转化为0-1背包问题：数组nums中，存在数的和为sumB
     *
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int a : nums) {
            sum += a;
        }
        //不存在
        if (sum < target) {
            return 0;
        }
        //必须是偶数
        if ((sum - target)%2 ==1) {
            return 0;
        }
        //目标值
        target = (sum-target)/2;
        //转为背包问题 在前i个数字中，和为j的组合数
        int[][] dp = new int[nums.length][target+1];
        //初始化第0行
        for (int i=0; i<=target; i++) {
            if (nums[0] == i) {
                dp[0][i] = 1;
            }
        }
        if (nums[0] == 0) {
            //nums[0]为0，target为0， 可以选择放，也可以选择不放，2种很关键
            dp[0][0] = 2;
        } else {
            //1种，不放
            dp[0][0] = 1;
        }
        for (int i=1; i<nums.length; i++) {
            for (int j=0; j<=target; j++) {
                if (nums[i] > j) {
                    //不选第i个元素
                    dp[i][j] = dp[i-1][j];
                } else  {
                    //选和不选都可以
                    dp[i][j] = dp[i-1][j] + dp[i-1][j - nums[i]];
                }
            }
        }
        return dp[nums.length-1][target];
    }


    int res = 0;
    public int findTargetSumWaysII(int[] nums, int target) {
        dfs(nums, 0, target, 0);
        return res;
    }


    public void dfs(int[] nums, int i, int target, int sum ){

        if(i == nums.length) {
            if(sum == target) {
                res++;
            }
            return;
        }
        // 选择列表：1. 添加 “-”，即 target -= nums[i];
        sum -= nums[i];
        // 进入下层递归
        dfs(nums, i+1, target, sum);
        // 撤销添加“-”的选择
        sum += nums[i];
        //2. 添加 “+”，即 target += nums[i];
        sum += nums[i];
        dfs(nums, i+1, target, sum);
        // 撤销添加“+”的选择
        sum -= nums[i];
    }

    private void dfs1(int[] nums, int target, int sum, int start) {
        if (start == nums.length) {
            if (target == sum) {
                res++;
            }
            return;
        }
        dfs(nums, target, sum+nums[start], start+1);
        dfs(nums, target, sum-nums[start], start+1);
    }
}
