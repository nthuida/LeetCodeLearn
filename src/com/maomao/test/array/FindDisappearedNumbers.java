package com.maomao.test.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到所有数组中消失的数字
 *
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * @Author huida.mao
 * @Date 2019/11/8
 */
public class FindDisappearedNumbers {

    /**
     * 将所有正数作为数组下标，置对应数组值为负值。那么，仍为正数的位置即为（未出现过）消失的数字。
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            //对应下标的值取反
            nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
        }
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            //大于0 说明没有出现
            if (nums[i] > 0) {
                list.add(i+1);
            }
        }
        return list;
    }

    /**
     * 给定一个二进制数组， 计算其中最大连续1的个数。
     *
     * 示例 1:
     *
     * 输入: [1,1,0,1,1,1]
     * 输出: 3
     * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
     *
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int result = 0;
        for (int i =0; i<nums.length; i++) {
            if (nums[i] == 1) {
                result++;
            } else {
                result = 0;
            }
            if (result > max) {
                max = result;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(new FindDisappearedNumbers().findMaxConsecutiveOnes(nums));
    }
}
