package com.maomao.test.array;

import java.util.Arrays;
import java.util.Stack;

/**
 * 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * @author huida
 * @date 2020/6/19
 */
public class NextPermutation {

    /**
     * 思路：下一个数增加的幅度尽可能的小
     * 从最右边(len-1)寻找比i大的值，交换，且重新升序i后面的值
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        //i从len-2开始，一直往左遍历，这样增加的幅度尽可能小
        for (int i=len-2; i>=0; i--) {
            //从最右边开始，寻找比i大的值
            for (int j=len-1; j>i; j--) {
                if (nums[i] < nums[j]) {
                    //找到比i大的值，交换
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    //从i的下一个开始升序排列
                    Arrays.sort(nums, i+1, len);
                    return;
                }

            }
        }
        //没找到，说明是降序排列的
        Arrays.sort(nums);
    }
}
