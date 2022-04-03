package com.maomao.test.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
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
     * 转移方程： dp[i] = max(dp[i], dp[j] + 1) for j in [0, i)。
     * dp[i] 以第 i 个数字结尾的最长上升子序列的长度
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
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
     * @param nums
     * @return
     */
    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int res = 1;
        //以nums[i]结尾的最长子序列长度
        int[] dp = new int[nums.length];
        //以nums[i]结尾的最长子序列个数
        int[] count = new int[nums.length];
        //初始化为1
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        for (int i=0; i<nums.length; i++) {
            for (int j=0; j<i; j++) {
                //遍历求dp
                if(nums[j] < nums[i]){
                    if ((dp[j] + 1)> dp[i]) {
                        //第一次找到dp[j]+1长度且以nums[i]结尾的最长递增子序列 ?
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        //这个长度的递增序列已找到过
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

    public static void main(String[] args) {
        int [] a = {10,9,2,5,3,4};
        System.out.println(new LengthOfLIS().lengthOfLIS(a));
        int[] b = {1,2,4,3,5,4,7,2};
        System.out.println(new LengthOfLIS().findNumberOfLIS(b));
    }
}
