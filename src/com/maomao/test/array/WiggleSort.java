package com.maomao.test.array;

import java.util.Arrays;

/**
 * 摆动排序 II
 * 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 *
 * 示例 1:
 *
 * 输入: nums = [1, 5, 1, 1, 6, 4]
 * 输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]
 * 示例 2:
 *
 * 输入: nums = [1, 3, 2, 2, 3, 1]
 * 输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2]
 *
 * @author huida
 * @date 2020/9/10
 */
public class WiggleSort {

    /**
     * 交替按逆序取较小一组的数和较大一组的数，直到较大一组的数取完，
     * 那么较小一组剩下0个或1个数没取。若是1个，把未取的数赋值给数组最后一个元素即可
     * @param nums
     */
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 0; i < len / 2; i++) {
            res[2 * i] = nums[(len - 1) / 2 - i];
            res[2 * i + 1] = nums[len - 1 - i];
        }
        if (len % 2 == 1) {
            res[len - 1] = nums[0];
        }

        for (int i=0; i<len; i++) {
            nums[i] = res[i];
        }
    }

}
