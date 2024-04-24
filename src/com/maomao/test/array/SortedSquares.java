package com.maomao.test.array;

/**
 * 有序数组的平方
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 * 示例 1：
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 *
 * @auther: huida
 * @date: 2022/8/4
 */
public class SortedSquares {

    /**
     * 双指针
     * 原数组中的元素平方最大值一定产生在原数组的最左边或者最右边
     * right指向最右边，left指向最左边
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int[] res = new int[nums.length];
        //从最右边开始保存
        int index = nums.length-1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right]*nums[right]) {
                res[index--] = nums[left]*nums[left];
                left++;
            } else {
                res[index--] = nums[right]*nums[right];
                right--;
            }
        }
        return res;
    }
}
