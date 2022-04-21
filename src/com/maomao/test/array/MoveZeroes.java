package com.maomao.test.array;

/**
 * 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * @Author huida.mao
 * @Date 2019/11/2
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int notZero = 0;
        //先排列非零元素
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != 0) {
                nums[notZero++] = nums[i];
            }
        }
        //剩余元素赋值0
        for (int i=notZero; i<nums.length; i++) {
            nums[i] = 0;
        }
    }

}
