package com.maomao.test.array;

/**
 * 除自身以外数组的乘积
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 
 * 中除 nums[i] 之外其余各元素的乘积。
 *
 * 示例:
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * @author huida
 * @date 2020/6/4
 */
public class ProductExceptSelf {

    /**
     * 对于给定索引i，等于左边所有数字的乘积乘以右边所有数字的乘积
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        //索引i左边的乘积
        int[] left = new int[len];
        //索引i右边的乘积
        int[] right = new int[len];
        //最左边没有元素，所以为1
        left[0] = 1;
        for (int i=1; i<len; i++) {
            left[i] = left[i-1] * nums[i-1];
        }
        //最右边没有元素，为1
        right[len-1] = 1;
        for (int i = len-2; i>=0; i--) {
            right[i] = right[i+1] * nums[i+1];
        }

        int[] res = new int[len];
        for (int i=0; i<len; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }
}
