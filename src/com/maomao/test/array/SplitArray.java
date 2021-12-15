package com.maomao.test.array;

/**
 * 分割数组的最大值
 * 给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。
 * 设计一个算法使得这 m 个子数组各自和的最大值最小。
 *
 * 示例 1：
 *
 * 输入：nums = [7,2,5,10,8], m = 2
 * 输出：18
 * 解释：
 * 一共有四种方法将 nums 分割为 2 个子数组。 其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4,5], m = 2
 * 输出：9
 *
 * @author: huida
 * @date: 2021/12/14
 **/
public class SplitArray {

    /**
     * 假设一个最大子数组和 max，来反推最大子数组和为 max 时，可以将 nums 分割成m个子数组。
     * 子数组和越大，分割的次数越少
     * @param nums
     * @param m
     * @return
     */
    public int splitArray(int[] nums, int m) {
        //最大子数组和的最大值， sum(nums)
        int sum = 0;
        //最大子数组和的最小值， max(nums)
        int max = 0;
        for (int i : nums) {
            sum += i;
            max = Math.max(i, max);
        }
        int high = sum;
        int low = max;
        //算法返回最小的那个 max，二分查找，搜索左边界
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int n = split(nums, mid);
            if (n == m) {
                //收缩右边边界
                high = mid-1;
            } else if (n < m) {
                //最大子数组和上限高了，减小一些
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return low;
    }

    /**
     * nums最大子数组和为max时，至少分割的次数
     * @param nums
     * @param max
     * @return
     */
    private int split(int[] nums, int max) {
        int sum = 0;
        int count = 1;
        for (int i=0; i<nums.length; i++) {
            if (sum + nums[i] > max) {
                count++;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
        }
        return count;
    }
}
