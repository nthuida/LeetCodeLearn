package com.maomao.test.search;

/**
 * 寻找峰值
 * 峰值元素是指其值大于左右相邻值的元素。
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞。
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题
 *
 * 示例 1:
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 *
 * 示例 2:
 * 输入: nums = [1,2,1,3,5,6,4]
 * 输出: 1 或 5
 * 解释: 你的函数可以返回索引 1，其峰值元素为 2；或者返回索引 5， 其峰值元素为 6。
 *
 * @author huida
 * @date 2020/9/9
 */
public class FindPeakElement {

    /**
     * 二分法
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len-1;
        while (left < right) {
            int mid = left + (right-left)/2;
            if (nums[mid] > nums[mid+1]) {
                //比下一个元素大，峰值肯定在mid的左边，包含mid
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
