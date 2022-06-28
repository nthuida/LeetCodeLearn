package com.maomao.test.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 最长递增子序列
 * 给定一个无序的整数数组，找到其中最长递增子序列的长度。
 *
 * 示例:
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 * @author huida
 * @date 2020/5/28
 */
public class LengthOfLIS {

    /**
     * 动态规划
     * 定义状态：dp[i] 以第 i 个数字结尾的最长上升子序列的长度
     * 转移方程：dp[i] = max(dp[i], dp[j] + 1)   0<=j<i
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
       int res = 1;
       int[] dp = new int[nums.length];
       //初始化为1
        Arrays.fill(dp, 1);
       for (int i=1; i<nums.length; i++) {
           for (int j=0; j<i; j++) {
               //遍历求dp
               if(nums[j] < nums[i]){
                   dp[i] = Math.max(dp[i], dp[j] + 1);
               }
           }
           //更新结果
           res = Math.max(res, dp[i]);
       }
        return res;
    }

}
