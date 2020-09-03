package com.maomao.test.array;

import java.util.Arrays;

/**
 * 最短无序连续子数组
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 你找到的子数组应是最短的，请输出它的长度。
 *
 * 示例 1:
 *
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 *
 * @author huida
 * @date 2020/9/2
 */
public class FindUnsortedSubarray {

    /**
     * 我们将数组 nums进行排序，记为 nums_sorted 。然后我们比较 nums 和 nums_sorted 的元素来决定最左边和最右边不匹配的元素。
     * 它们之间的子数组就是要求的最短无序子数组
     *
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length <2) {
            return 0;
        }
        int[] temp = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            temp[i] = nums[i];
        }
        Arrays.sort(nums);
        int start = nums.length-1;
        int end = 0;
        for (int i=0; i< nums.length; i++) {
            if (temp[i] != nums[i]) {
                start = Math.min(i, start);
                end = Math.max(i, end);
            }
        }

        return (end - start >= 0 ? end - start + 1 : 0);
    }
}
