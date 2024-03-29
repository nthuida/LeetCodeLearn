package com.maomao.test.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 众数
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 *
 * @Author huida.mao
 * @Date 2019/10/28
 */
public class MajorityElement {
    /**
     * map计数
     * @param nums
     * @return
     */
    public int majorityElementII(int[] nums) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>(length);
        for (int i=0; i<length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
            if (map.get(nums[i]) > length/2) {
                return  nums[i];
            }
        }
        return 0;
    }

    /**
     * 投票法
     * “多数元素”和其他元素 两两相互抵消，抵消到最后肯定还剩余至少1个“多数元素”
     * 时间复杂度O(n), 空间复杂度O(1)
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int res = nums[0];
        //投票计数
        int count = 1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == res) {
                //相同计数
                count++;
            } else {
                //不同抵消减数
                count--;
                if (count == 0) {
                    //更新值，重新投票
                    res = nums[i];
                    count = 1;
                }
            }
        }
        return res;
    }
}
