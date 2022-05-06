package com.maomao.test.array;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
 * 使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * @Author huida.mao
 * @Date 2019/11/29
 */
public class ThreeSumClosest {

    /**
     * 先排序，遍历数组，两个指针，一个指向头，一个指向尾
     * 根据 sum = nums[i] + nums[start] + nums[end] 的结果，判断 sum 与目标 target 的距离，
     * 如果更近则更新结果 ans
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i=0; i<nums.length; i++) {
            int start = i+1;
            int end = nums.length-1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    //更靠近
                    result = sum;
                }
                if (sum < target) {
                    start++;
                } else if (sum > target){
                    end--;
                } else {
                    return result;
                }
            }
        }

        return result;
    }

}
