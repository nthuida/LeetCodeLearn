package com.maomao.test.array;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 存在重复元素 II
 *
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 *
 * 示例 1:
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 *
 * 示例 2:
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 *
 * 示例 3:
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 *
 * @Author huida.mao
 * @Date 2019/10/29
 */
public class ContainsNearbyDuplicate {

    /**
     * 维护一个哈希表，里面始终最多包含 k 个元素，当出现重复值时则说明在 k 距离内存在重复元素
     * 每次遍历一个元素则将其加入哈希表中，如果哈希表的大小大于 k，则移除最前面的数字
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if(set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;

    }

    /**
     * 删除最先进来的
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>(k, 0.75f, false) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > k;
            }
        };
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                return true;
            } else {
                map.put(nums[i], 1);
            }

        }
        return false;
    }

}
