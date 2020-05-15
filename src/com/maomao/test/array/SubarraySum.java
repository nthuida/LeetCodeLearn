package com.maomao.test.array;

/**
 * 和为K的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 *
 * @author huida
 * @date 2020/5/15
 */
public class SubarraySum {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i=0; i<nums.length; i++) {
            int sum = 0;
            int j = i;
            while (j <= nums.length-1) {
                sum += nums[j++];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
