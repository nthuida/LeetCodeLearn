package com.maomao.test.array;

/**
 * 递增的三元子序列
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 *
 * 示例 1:
 * 输入: [1,2,3,4,5]
 * 输出: true
 *
 * 示例 2:
 * 输入: [5,4,3,2,1]
 * 输出: false
 *
 * @author huida
 * @date 2020/9/17
 */
public class IncreasingTriplet {

    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        //第一小
        int min = Integer.MAX_VALUE;
        //第二小
        int second = Integer.MAX_VALUE;
        for (int i=0; i< nums.length; i++) {
            if (nums[i] <= min) {
                min = nums[i];
            } else if (nums[i] <= second) {
                second = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}
