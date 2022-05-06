package com.maomao.test.array;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，
 * 并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例: 
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 *
 * @author huida
 * @date 2020/6/28
 */
public class MinSubArrayLen {

    /**
     * 双指针
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int min = nums.length + 1;
        int start = 0;
        int end = 0;
        int sum = 0;
        while (start <= end && end < nums.length) {
            sum += nums[end];
            while (sum >= s) {
                min = Math.min(min, end-start+1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        if (min == nums.length+1) {
            return 0;
        } else {
            return min;
        }
    }
}
