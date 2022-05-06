package com.maomao.test.array;

import java.util.HashMap;

/**
 * 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 * @author Administrator
 * @date 2019/3/24
 */
public class SingleNumber {
    /**
     * 异或，最后那个元素一定是不同的那个
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i=1; i<nums.length; i++) {
            result = result^nums[i];
        }
        return result;
    }

    /**
     * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。
     * 要求时间复杂度是O(n)，空间复杂度是O(1)。
     *
     * 示例 1：
     * 输入：nums = [4,1,4,6]
     * 输出：[1,6] 或 [6,1]
     *
     * 示例 2：
     * 输入：nums = [1,2,10,4,1,4,3,3]
     * 输出：[2,10] 或 [10,2]
     *
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        //两个不同元素的异或值
        int result = nums[0];
        for (int i=1; i<nums.length; i++) {
            result = result^nums[i];
        }
        int mark = 1;
        while ((result & mark)==0) {
            //找到不同的最低那位
            mark = mark<<1;
        }
        int a = 0;
        int b = 0;
        for (int i=0; i<nums.length; i++) {
            if ((nums[i] & mark) == 0) {
                //根据那位不同分组
                a ^= nums[i];
            } else {
                b ^= nums[i];
            }
        }
        return new int[]{a,b};
    }

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
     *
     * 说明：
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     *
     * 示例 1:
     * 输入: [2,2,3,2]
     * 输出: 3
     *
     * 示例 2:
     * 输入: [0,1,0,1,0,1,99]
     * 输出: 99
     *
     * @param nums
     * @return
     */
    public int singleNumberII(int[] nums) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int num : nums) {
            hashmap.put(num, hashmap.getOrDefault(num, 0) + 1);
        }
        for (int k : hashmap.keySet()) {
            if (hashmap.get(k) == 1){
                return k;
            }
        }
        return -1;

    }

}
