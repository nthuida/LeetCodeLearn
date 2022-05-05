package com.maomao.test.slidingWindow;

/**
 * 乘积小于K的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
 * 示例 1：
 * 输入：nums = [10,5,2,6], k = 100
 * 输出：8
 * 解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
 *
 * 示例 2：
 * 输入：nums = [1,2,3], k = 0
 * 输出：0
 *
 * @author: huida
 * @date: 2022/5/5
 **/
public class NumSubarrayProductLessThanK {

    /**
     * 暴力解
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanKII(int[] nums, int k) {
        int len = nums.length;
        int count = 0;
        for (int i=0; i<len; i++) {
            int sum = 1;
            for (int j=i; j<len; j++) {
                sum *= nums[j];
                if (sum < k) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    /**
     * 滑动窗口
     * 以每个数字为右边界所形成的有效子数组的个数
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanK(int[] nums, int k){
        if (k<=1) {
            return 0;
        }
        int left=0,right=0;
        int sum = 1;
        int res = 0;
        //用右边界遍历整个数组，每次循环右边界右移一次
        while (right < nums.length) {
            //计算当前窗口的积
            sum *= nums[right];
            while (sum >= k) {
                //去除左边界的乘积
                sum /= nums[left];
                //左边界右移
                left++;
            }
            //每次右指针位移到一个新位置，应该加上 x 种数组组合：
            //  nums[right]
            //  nums[right-1], nums[right]
            //  nums[right-2], nums[right-1], nums[right]
            //  nums[left], ......, nums[right-2], nums[right-1], nums[right]
            //共有 right - left + 1 种
            res += right-left+1;
            //右边界右移
            right++;

        }
        return res;
    }
}
