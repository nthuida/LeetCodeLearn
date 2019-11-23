package com.maomao.test.array;

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

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,1,2,3};
        System.out.println(new SingleNumber().singleNumber(nums));
    }
}
