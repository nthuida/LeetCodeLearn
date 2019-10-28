package com.maomao.test.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 众数
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 *
 * @Author huida.mao
 * @Date 2019/10/28
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
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
}
