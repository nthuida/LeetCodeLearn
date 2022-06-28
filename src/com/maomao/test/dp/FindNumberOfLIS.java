package com.maomao.test.dp;

import java.util.Arrays;

/**
 * 最长递增子序列的个数
 * 给定一个未排序的整数数组，找到最长递增子序列的个数。
 *
 * 示例 1:
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 *
 * 示例 2:
 * 输入: [2,2,2,2,2]
 * 输出: 5
 * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
 *
 * @author: huida
 * @date: 2022/6/28
 **/
public class FindNumberOfLIS {

    public int findNumberOfLIS(int[] nums) {
        int res = 1;
        //以i结尾的最长子序列长度
        int[] dp = new int[nums.length];
        //以i结尾的最长子序列个数
        int[] count = new int[nums.length];
        //初始化为1
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        for (int i=1; i<nums.length; i++) {
            for (int j=0; j<i; j++) {
                //遍历求dp
                if(nums[j] < nums[i]){
                    if ((dp[j] + 1)> dp[i]) {
                        //第一次找到dp[j]+1长度的最长递增子序列
                        //长度增加，数量不变
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        //这个长度的递增序列已找到过
                        // 长度不变，数量增加
                        count[i] += count[j];
                    }
                }
            }
            res = Math.max(res, dp[i]);
        }
        int ans = 0;
        for (int i = 0; i<nums.length; i++) {
            if (dp[i] == res) {
                ans += count[i];
            }
        }
        return ans;
    }

}
